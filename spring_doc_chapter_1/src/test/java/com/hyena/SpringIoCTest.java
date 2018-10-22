package com.hyena;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
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



}
