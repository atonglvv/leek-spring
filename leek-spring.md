# Version2.0
新增 BeanDefinitionRegistry 接口

将 [注册BeanDefinition方法] 从AbstractBeanFactory中拆出来

# version3.0
新增 SingletonBeanRegistry 接口, 单例bean容器雏形
 
 去掉之前写在AbstractBeanFactory从容器中获取单例bean的代码, 改为直接extends DefaultSingletonBeanRegistry
 
 # version4.0
 fix 含有构造函数的bean无法通过version3.0实例化。
 
 # version4.1
 【策略模式】 实现bean的实例化, Java反射实现与cglib实现。
 
 # version 5.0
 在createBean的时候填充属性
 
 # version 5.1
BeanDefinition 中的 PropertyValues 中不存放Bean对象, 而是存放BeanName, createBean后填充属性的时候根据beanName获取Bean,进行填充

 # version 6.0
实现从xml中读取beanDefinition

# version6.1
按照资源加载的不同方式，资源加载器可以把这些方式集中到统一的类服务下进行处理，外部用户只需要传递资源地址即可，简化使用。
引入 ResourceLoader

用ResourceLoader代替test中的如下代码
```java
        Resource resource;
        String location = "classpath:spring.xml";
        if (location.startsWith("classpath:")) {
            resource = new ClassPathResource(location.substring("classpath:".length()));
        }
        else {
            try {
                URL url = new URL(location);
                resource = new UrlResource(url);
            } catch (MalformedURLException e) {
                resource = new FileSystemResource(location);
            }
        }
```