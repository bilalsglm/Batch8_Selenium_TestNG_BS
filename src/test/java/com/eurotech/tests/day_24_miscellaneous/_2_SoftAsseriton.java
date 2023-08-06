package com.eurotech.tests.day_24_miscellaneous;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _2_SoftAsseriton {

    SoftAssert softAssert=new SoftAssert();

    @Test
    public void test1(){
        softAssert.assertEquals(1,1);
        softAssert.assertEquals("Ali","Ahmet");
        softAssert.assertEquals(2.3,2.3);
        softAssert.assertTrue(0==1);
        softAssert.assertTrue("Ayse".contains("y"));
        softAssert.assertFalse(1>2);
        softAssert.assertFalse(1<2);
        softAssert.assertAll("demo soft assert");
        /**
         * Soft assertion: Normal assertte hata aldıktan sonraki assertleri test edemeyiz, ancak etmek istediğimiz
         * durumlarda soft assertion kullanabiliriz. Bu assertion tipinde bütün assertler biriktirilir, hatalı assertion olsa da kod
         * exception fırlatmaz ve execution devam eder. En son assertAll() metodunda geriye dönük olarak bütün assertionlar
         * değerlendirilir ve varsa hatalar, bu satır çalıştıktan sonra log kayıtlarında görünür ve hata fırlatılır.
         */
    }
}
