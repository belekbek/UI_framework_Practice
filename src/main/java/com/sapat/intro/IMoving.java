package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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
        Helper.pause(3000);
        driver.findElement(By.xpath("//a[text()='GOT IT']")).click();
        Helper.pause(3000);
        driver.findElement(By.xpath(".//a[@id='closeTutorial']")).click();
        Helper.pause(3000);
    }

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
    }
    @Test(dependsOnMethods = {"addDresser"})
    public void addBed(){
        // Adding Bed
        Actions bed = new Actions(driver);
//        WebElement bed1 = driver.findElement(By.xpath("//div[@class='13']"));
        WebElement bed1 = driver.findElement(By.xpath("//div[@class='13']")).findElement(By.xpath("//div[@style='z-index: 14']"));
        bed.moveToElement(bed1).perform();
        Helper.pause(1000);
        bed1.findElement(By.xpath(".//a[contains(text(),'Add to Inventory')]")).click();
        Helper.pause(1000);
        bed1.findElement(By.xpath("//button[@class='quantity-plus']")).click();
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
        TV1.findElement(By.xpath("//button[@class='quantity-plus']")).click();
    }
}
