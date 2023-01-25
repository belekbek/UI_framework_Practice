package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SeleniumExceptions extends BaseTest{

    @Test
    public void demo1(){
        //No such element
        browserHelper.openURL("https://demoqa.com/text-box");

    }
    @Test
    public void elementClickInterceptedException(){
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).click();
    }
    @Test
    public void elementNotInteractableException(){
        browserHelper.openURL("https://demoqa.com/radio-button");
        driver.findElement(By.id("noRadio")).sendKeys("saas");
    }
    @Test
    public void elementClickInterceptedExceptionTest(){
        browserHelper.openURL("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }

}
