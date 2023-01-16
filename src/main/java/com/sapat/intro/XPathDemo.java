package com.sapat.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class XPathDemo extends BaseTest {
    @Test
    public void signUpToGlovo(){
        driver.get("https://glovoapp.com/");
        // Creating fake data
        Faker fakeData = new Faker();
        String name = fakeData.name().fullName();
        String mail = fakeData.internet().emailAddress();
        String password = fakeData.internet().password();

        // clicking sign up button
        WebElement signup = driver.findElement(By.xpath("(//button[@id='user-register'])[2]"));
        signup.click();

        // signing up
        WebElement fullNameInputField = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[1]"));
        fullNameInputField.sendKeys(name);
        WebElement inputMail = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[2]"));
        inputMail.sendKeys(mail);
        WebElement inputAddress = driver.findElement(By.xpath("(//input[@data-test-id='text-field-input'])[3]"));
        inputAddress.sendKeys(password);
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        System.out.println("\n"+name + "\n" + mail + "\n" + password);
    }

}
