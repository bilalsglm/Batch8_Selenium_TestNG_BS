package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.utilities.ConfigurationReader;

public class _2_SingeletonDemo {
    private _2_SingeletonDemo(){}

    private static String driver;

    public static String getDriver(){
        if (driver==null){
            System.out.println("driver is null, assign a value to it.");
            driver= ConfigurationReader.get("browser");
        }else {
            System.out.println("It has vlaue, just return current value. ");
        }
        return driver;

    }
}
