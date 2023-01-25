package com.sapat.intro;

import com.sapat.intro.BaseTest;
import com.sapat.intro.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IMoving extends BaseTest {
    @Test (priority = 1)
    public void openSite(){
        driver.get("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My House");
        Select select1 = new Select(driver.findElement(By.id("hp-nav-select-house")));
        select1.selectByVisibleText("Just a few Items");
        driver.findElement(By.xpath("//button[text()='Compare Quotes']")).click();
    }

    @Test (priority = 2)
    public void closePopUpWindow(){
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[@class='btn btn-blue col-xs-6']")).click();
//        Helper.pause(3000);
//        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }

    Integer quantityOfItems = 0;

    @Test(priority = 3)
    public void addDresser(){
        // Adding Dresser
        Actions dresser = new Actions(driver); //Creating action to move mouse
        WebElement dresser1 = driver.findElement(By.xpath("//div[@class='14']")).findElement(By.xpath("//div[@class='item']"));
        dresser.moveToElement(dresser1).perform();
        Helper.pause(1000);
        dresser1.findElement(By.xpath(".//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
        dresser1.findElement(By.xpath("//button[@class='quantity-plus']")).click();
        Helper.pause(1000);
    }
    @Test(dependsOnMethods = {"addDresser"})
    public void addBed(){
        // Adding Bed
        Actions bed = new Actions(driver);
        WebElement bed1 = driver.findElement(By.xpath("//div[@class='13']")).findElement(By.xpath("//div[@class='item']"));
        bed.moveToElement(bed1).perform();
        Helper.pause(1000);
        bed1.findElement(By.xpath(".//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
        bed1.findElement(By.xpath("(//button[@class='quantity-plus'])[3]")).click();
        Helper.pause(1000);
        bed1.findElement(By.xpath("(//button[@class='quantity-plus'])[3]")).click();
        Helper.pause(1000);
    }
    @Test(dependsOnMethods = {"addBed"})
    public void addTV(){
        // Adding TV
        Actions TV = new Actions(driver);
        WebElement TV1 = driver.findElement(By.xpath("//div[@class='12']")).findElement(By.xpath("//div[@class='item']"));
        TV.moveToElement(TV1).perform();
        Helper.pause(1000);
        TV1.findElement(By.xpath(".//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
        TV1.findElement(By.xpath("(//button[@class='quantity-plus'])[5]")).click();
        Helper.pause(1000);
        TV1.findElement(By.xpath("(//button[@class='quantity-plus'])[5]")).click();
        Helper.pause(1000);
    }
    @Test(priority = 4)
    public void checkQuantity(){
        String dresser = driver.findElement(By.xpath("(//input[@type='number'])[1]")).getAttribute("value");
        String bed = driver.findElement(By.xpath("(//input[@type='number'])[3]")).getAttribute("value");
        String TV = driver.findElement(By.xpath("(//input[@type='number'])[5]")).getAttribute("value");
        quantityOfItems = Integer.parseInt(dresser) + Integer.parseInt(bed) + Integer.parseInt(TV);
        String str = driver.findElement(By.xpath("(//span[@ng-show='room.ItemsCount>0'])[1]")).getText();
        Integer sumOfItem = Integer.valueOf(str.substring(0,str.indexOf(" ")));
        Assert.assertEquals(quantityOfItems, sumOfItem);
    }
}
