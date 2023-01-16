package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
}
