package cn.atong.leek.spring.test;

import cn.atong.leek.spring.aop.AdvisedSupport;
import cn.atong.leek.spring.aop.MethodMatcher;
import cn.atong.leek.spring.aop.TargetSource;
import cn.atong.leek.spring.aop.aspectj.AspectJExpressionPointcut;
import cn.atong.leek.spring.aop.framework.Cglib2AopProxy;
import cn.atong.leek.spring.aop.framework.JdkDynamicAopProxy;
import cn.atong.leek.spring.aop.framework.ReflectiveMethodInvocation;
import cn.atong.leek.spring.beans.PropertyValue;
import cn.atong.leek.spring.beans.PropertyValues;
import cn.atong.leek.spring.beans.factory.config.BeanDefinition;
import cn.atong.leek.spring.beans.factory.support.DefaultListableBeanFactory;
import cn.atong.leek.spring.beans.factory.xml.XmlBeanDefinitionReader;
import cn.atong.leek.spring.context.support.ClassPathXmlApplicationContext;
import cn.atong.leek.spring.test.bean.*;
import cn.atong.leek.spring.test.event.CustomEvent;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;

import java.lang.reflect.*;

/**
 * @program: leek-spring
 * @description:
 * @author: atong
 * @create: 2022-03-24 15:01
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //UserDao 注册
        beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));

        // 2.注册 userService
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("uId", "10002"));
        propertyValues.addPropertyValue(new PropertyValue("name", "cc"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", beanFactory.getBean("userDao")));
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3.第一次获取 bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 4.第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getSingleton("userService");
        userService_singleton.queryUserInfo();
    }


    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"atong"});
        System.out.println(obj);
    }

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("atong");
        System.out.println(userService);
    }

    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = null;
        for (Constructor<?> ctor : declaredConstructors) {
            if (ctor.getParameterTypes().length == 1) {
                constructor = ctor;
                break;
            }
        }
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("atong");
        System.out.println(userService);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        UserService userService = (UserService) beanFactory.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_context() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = (UserService)applicationContext.getBean("userService");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);



        System.out.println("ApplicationContextAware："+userService.getApplicationContext());
        System.out.println("BeanFactoryAware："+userService.getBeanFactory());
    }


    @Test
    public void test_hook() throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
        Thread.sleep(5000);
    }


    @Test
    public void test_scope() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserScopeService userService1 = (UserScopeService)applicationContext.getBean("userScopeService");
        UserScopeService userService2 = (UserScopeService)applicationContext.getBean("userScopeService");

        System.out.println(userService1);
        System.out.println(userService2);

        System.out.println(userService1 + " 十六进制哈希：" + Integer.toHexString(userService1.hashCode()));
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 调用代理方法
        UserService userService = (UserService)applicationContext.getBean("userService");
        System.out.println("测试结果：" + userService.queryUserInfoFromIUserDao());
    }

    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }


    @Test
    public void test_proxy_class() {
        IUserService userService = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserService.class}, (proxy, method, args) -> "你被代理了！");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserService();

        // AOP 代理
        IUserService proxy = (IUserService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), targetObj.getClass().getInterfaces(), new InvocationHandler() {
            // 方法匹配器
            MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* cn.atong.leek.spring.test.bean.IUserService.*(..))");

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (methodMatcher.matches(method, targetObj.getClass())) {
                    // 方法拦截器
                    MethodInterceptor methodInterceptor = invocation -> {
                        long start = System.currentTimeMillis();
                        try {
                            return invocation.proceed();
                        } finally {
                            System.out.println("监控 - Begin By AOP");
                            System.out.println("方法名称：" + invocation.getMethod().getName());
                            System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                            System.out.println("监控 - End\r\n");
                        }
                    };
                    // 反射调用
                    return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                }
                return method.invoke(targetObj, args);
            }
        });
        String result = proxy.queryUserName();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* cn.atong.leek.spring.test.bean.UserService.*(..))");

        Class<UserService> clazz = UserService.class;
        Method method = clazz.getDeclaredMethod("queryUserName");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }


    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserService();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceInterceptor());
        advisedSupport.setMethodMatcher(new AspectJExpressionPointcut("execution(* cn.atong.leek.spring.test.bean.UserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserName());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService) new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }


    @Test
    public void test_aop_ioc() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        IUserAopService userAopService = applicationContext.getBean("userAopService", IUserAopService.class);
        System.out.println("测试结果：" + userAopService.queryUserInfo());
    }


}
