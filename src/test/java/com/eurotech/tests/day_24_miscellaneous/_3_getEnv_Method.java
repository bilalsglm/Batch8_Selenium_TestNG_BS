package com.eurotech.tests.day_24_miscellaneous;

import org.testng.annotations.Test;

public class _3_getEnv_Method {

    /**
     * environment variables'da bulunan değişkenlere erişmek için kullanılır.
     */

    @Test
    public void test1(){
        String path = System.getenv("Path");
        System.out.println("path = " + path);

        String temp = System.getenv("TEMP");
        System.out.println("temp = " + temp);

        String username = System.getenv("USERNAME");
        System.out.println("username = " + username);
    }
}
