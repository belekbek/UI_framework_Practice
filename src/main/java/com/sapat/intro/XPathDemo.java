package com.sapat.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class XPathDemo {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://glovoapp.com/");
    }
    @Test
    public void signUpToGlovo(){
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



    @AfterClass
    public void close(){
        driver.close();
        driver.quit();
    }
}
