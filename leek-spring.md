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
 
 