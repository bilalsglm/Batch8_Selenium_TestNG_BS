package com.eurotech.tests.day_18_properties_singleton;

import com.eurotech.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class _1_PropertiesTest {

    @Test
    public void test1() {
        String s = ConfigurationReader.get("browser");
        System.out.println("s = " + s);
    }
}
