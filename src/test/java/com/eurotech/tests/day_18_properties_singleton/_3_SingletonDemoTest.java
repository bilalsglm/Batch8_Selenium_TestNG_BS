package com.eurotech.tests.day_18_properties_singleton;

import org.testng.annotations.Test;

public class _3_SingletonDemoTest {

    @Test
    public void test1() {
        //classin constructor i private oldugundan nesne uretemem...
       // _2_SingeletonDemo singeletonDemo=new _2_SingeletonDemo();

        String s = _2_SingeletonDemo.getDriver();
        System.out.println("s = " + s);

        String s1 = _2_SingeletonDemo.getDriver();
        System.out.println("s1 = " + s1);
    }
}
