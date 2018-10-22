package com.hyena;

import com.hyena.service.RunAware;
import com.hyena.service.SingAware;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Test test = new Test();
        awareTest(test);

    }


    public static void awareTest(Object object) {
        Class target = object.getClass() ;
        if (RunAware.class.isAssignableFrom(target)) {
            ((RunAware)object).run();
        }
        if (SingAware.class.isAssignableFrom(target)) {
            ((SingAware)object).sing();
        }
    }


    static class Test implements SingAware, RunAware {
        @Override
        public void run() {
            System.out.println("i am running");
        }

        @Override
        public void sing() {
            System.out.println("i am singing");
        }
    }
}

