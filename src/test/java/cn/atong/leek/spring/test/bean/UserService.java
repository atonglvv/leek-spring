package cn.atong.leek.spring.test.bean;

import cn.atong.leek.spring.beans.BeansException;
import cn.atong.leek.spring.beans.factory.*;
import cn.atong.leek.spring.context.ApplicationContext;
import cn.atong.leek.spring.context.ApplicationContextAware;

/**
 * @author atong
 * @version 1.0.0.1
 * @description User Service
 * @date 10:57 2022/3/25
 **/
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {


    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


    private String uId;

    private String name;

    private Integer age;

    private UserDao userDao;
    /** Factory Bean 创建的 Bean */
    private IUserDao userDaoFactoryBean;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String queryUserInfo() {
        System.out.println("用户Id = " + uId);
        System.out.println("用户age = " + age);
        System.out.println("查询用户信息:" + userDao.queryUserName(uId));
        return userDao.queryUserName(uId);
    }

    public String queryUserInfoFromIUserDao() {
        return userDaoFactoryBean.queryUserName(uId);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    /**
     * Bean 处理了属性填充后调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("Aware ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Aware Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
