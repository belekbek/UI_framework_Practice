package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionsDemo extends BaseTest{

    @Test
    public void testRadioButton() throws InterruptedException {
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesButton.click();
        Thread.sleep(3000);
        Assert.assertTrue(yesButton.isEnabled());

    }
    @Test
    public void testCheckBox(){
        driver.get("https://demoqa.com/checkbox");
        WebElement list = driver.findElement(By.xpath(".//div[@id='tree-node']/ol/li"));
        list.findElement(By.xpath(".//button[@title='Toggle']")).click();
    }

    @Test
    public void testRightClick(){
        driver.get("https://demoqa.com/buttons");
        WebElement rightClickButton = driver.findElement(By.id("doubleClickBtn"));
        Actions actions = new Actions(driver);
        actions.doubleClick(rightClickButton).perform();
        Assert.assertEquals(driver.findElement(By.id("doubleClickMessage")).getText(),"You have done a double click");
    }


    @Test
    public void testMoveToElementAndSelect(){
        driver.get("https://www.imoving.com/");
        WebElement selectMenu = driver.findElement(By.id("houseTypeSelectList"));
        Select select = new Select(selectMenu);
        select.selectByVisibleText("My Storage");
        Helper.pause(3000);
        select.selectByVisibleText("My Apartment");
    }
}
