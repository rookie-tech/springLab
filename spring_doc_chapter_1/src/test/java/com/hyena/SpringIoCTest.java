package com.hyena;

import com.hyena.commons.beans.MyBean;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {


    /**
     * section_1_1
     *
     * bug often happens here : can't find spring.xml
     * solve: 创建resources包，并将它mark as resource，这样ide就能就它复制到target/classes
     *
     */
    @Test
    public void loadXmlTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    }


    /**section_1_2
     *
     * 在spring中采用import标签，将不同的种类的bean放到各自的xml文件中，方便管理
     * 采用Assert.assertNotNull来测试对象是否存在
     */
    @Test
    public void springXmlImportTagTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object service = context.getBean("myService");
        Assert.assertNotNull(service);
    }


    /**
     * section_1_3
     * 在容器外注册对象(objects).
     *
     * 注意：The given instance is supposed to be fully initialized; the registry will not perform
     * any initialization callbacks (in particular, it won't call InitializingBean's afterPropertiesSet method).
     * The given instance will not receive any destruction callbacks (like DisposableBean's destroy method) either.
     *
     * When running within a full BeanFactory: Register a bean definition instead of an existing instance
     * if your bean is supposed to receive initialization and/or destruction callbacks.
     *
     * 翻译过来就是：容器不会将你的对象进行任何的初始化处理，包括不会调用IntializingBean的afterProperties方法。也不会调用
     * Destruction method。所以你要保证你的Object fully initialized。
     * 如果保证你的对象有init-method，destroy-method回调，请注册BeanDefinition，而不是一个现存的对象实例。。。。
     *
     */
    @Test
    public void registerBeanOutSizeIoC() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ConfigurableListableBeanFactory configurableListableBeanFactory = context.getBeanFactory();

        // register instance
        configurableListableBeanFactory.registerSingleton("obj", new Object());

    }


    /**
     * section_1_3
     *
     * 这个测试是区分bean标签里面的name和id属性。
     * 测试结论如下：id，name属性都叫做bean的identifiers。只不过id叫做bean的unique identifier
     * name叫做alias。
     *
     * 如果某个bean占用了某个identifier。那么其它的bean就不能使用这个identifier了。也就是说
     * 不能在id，name属性中使用这个identifier。
     *
     * 详情：resources/spring.xml
     *
     */
    @Test
    public void getBeanByIdentifier() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object uniqueBean = context.getBean("uniqueBean");

        // 通过alias获取bean
        Object aliasObj = context.getBean("anotherName");
        Object anotherAliasObj = context.getBean("oneName");


        Assert.assertEquals(aliasObj , anotherAliasObj);
        Assert.assertEquals(uniqueBean,aliasObj);
    }

    /**
     * section_1_3
     * 如果我们只是为这个bean设置name属性会怎么样？
     *
     * 结论：IoC会为这个bean生成一个unique name。
     *      其实也证明了如果只有name属性，那么name也不能作为bean的unique name。还是需要生成
     *
     * 详情：resources/spring.xml
     */
    @Test
    public void beanNoId() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object obj = context.getBean("myBean");
        Assert.assertNotNull(obj);

    }






}
