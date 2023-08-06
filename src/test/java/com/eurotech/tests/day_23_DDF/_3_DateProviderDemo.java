package com.eurotech.tests.day_23_DDF;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _3_DateProviderDemo {

    @DataProvider
    public Object[][] testDate_1(){
        String [][] notes={
                {"Hasan Sari","70","100"},
                {"Veysel Candan","80","98"},
                {"Hanife Kara","90","95"},
                {"Burhan Eratli","87","98"},
                {"Sule Aylin Atmaca","100","93"},
                {"Eylem Sonmez","89","97"}
        };
        return notes;
    }

    @Test(dataProvider = "testDate_1")
    public void testNotes_1(String fulName,String visaNote, String finalNote){

        System.out.println(fulName+" "+visaNote+" "+finalNote);


    }

    @DataProvider(name = "StudentNotes")
    public Object[][] testDate_2(){
        Object [][] notes={
                {"Hasan Sari",70,100},
                {"Veysel Candan",80,98},
                {"Hanife Kara",90,95},
                {"Burhan Eratli",87,98},
                {"Sule Aylin Atmaca",100,93},
                {"Eylem Sonmez",89,97}
        };
        return notes;
    }

    @Test(dataProvider = "StudentNotes")
    public void testNotes_2(String fulName,int visaNote,int finalNote){

        System.out.println(fulName+" "+visaNote+" "+finalNote+ " Yil Sonu Notu ="+ (visaNote*0.4+finalNote*0.6));


    }
}
