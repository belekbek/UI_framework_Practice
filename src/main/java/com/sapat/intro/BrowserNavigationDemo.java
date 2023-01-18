package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserNavigationDemo extends BaseTest{

    @Test
    public void test1(){
        driver.get("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/full-inventory/#!/");
        driver.navigate().back();
        Helper.pause(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.imoving.com/");
        driver.navigate().refresh();
    }
    @Test
    public void testDownload(){
        driver.navigate().to("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\user\\Desktop\\50\\DSC_6908.JPG");
        Helper.pause(5000);
    }
}
