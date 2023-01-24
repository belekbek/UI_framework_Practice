package com.sapat.intro;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void demo1(){
        //No such element
        browserHelper.openURL("https://demoqa.com/text-box");

    }
    @Test
    public void test(){
        browserHelper.openURL("https://demoqa.com/text-box");
        driver.findElement(By.id("submit")).sendKeys("sdsd");
    }

}
