package com.sapat.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class HW_WebTables extends BaseTest{
    @Test
    public void testTable(){
        driver.navigate().to("https://demoqa.com/webtables");

        driver.findElement(By.id("addNewRecordButton")).click();
        Faker faker = new Faker();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@placeholder='name@example.com']")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@placeholder='Age']")).sendKeys(String.valueOf((faker.number().numberBetween(15, 80))));
        driver.findElement(By.xpath("//input[@placeholder='Salary']")).sendKeys(String.valueOf((faker.number().numberBetween(2000, 10000))));
        driver.findElement(By.xpath("//input[@placeholder='Department']")).sendKeys(faker.company().name());
        Helper.pause(5000);
        driver.findElement(By.id("submit")).click();

        List<WebElement> table = driver.findElements(By.xpath("//div[contains(@class, 'rt-tr-group')]"));
        for (WebElement e: table){
            System.out.println(e.getText());
        }

    }
}
