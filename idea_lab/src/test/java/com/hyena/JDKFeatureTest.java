package com.hyena;

import com.hyena.beans.Teacher;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;

public class JDKFeatureTest {


    /**
     * Core technologies: section_1_4
     *
     * 果然通过反射是没法获得参数名称的(argument name).
     * 解决方法：在构造方法上面使用@ConstructorProperties注解
     *
     * 详见：Teacher类的构造方法
     * @throws NoSuchMethodException
     */
    @Test
    public void cannotGetConstructArgName() throws NoSuchMethodException {
        Class<?> clazz = Teacher.class ;
        Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(new Class[]{String.class, int.class});
        Assert.assertNotNull(declaredConstructor);
    }
}
