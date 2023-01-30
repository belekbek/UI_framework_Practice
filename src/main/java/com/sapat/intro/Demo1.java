package com.sapat.intro;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Demo1 {
    @Test
    public void testDemo(){
        WebDriverManager.chromedriver().setup(); //устанавливаем драйвер для Chrome
        WebDriver driver = new ChromeDriver(); //Создаём обьект райвера
        driver.manage().window().maximize(); //Maximizing window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); //Driver will wait 15 sec.
        driver.get("https://demoqa.com/text-box");// Will open this site

        Faker fakeData = new Faker();
        String name = fakeData.name().fullName();
        String mail = fakeData.internet().emailAddress();
        String address = fakeData.address().fullAddress();
        WebElement fullNameInputField = driver.findElement(By.id("userName"));
        fullNameInputField.sendKeys(name);
        WebElement inputMail = driver.findElement(By.id("userEmail"));
        inputMail.sendKeys(mail);
        WebElement inputAddress = driver.findElement(By.id("currentAddress"));
        inputAddress.sendKeys(address);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        WebElement clickSubmit = driver.findElement(By.id("submit"));
        clickSubmit.click();

        WebElement printName = driver.findElement(By.id("name"));
        System.out.println(printName.getText());
        WebElement printEmail = driver.findElement(By.id("email"));
        System.out.println(printEmail.getText());
        WebElement printAddress = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[6]/div/p[3]"));
        System.out.println(printAddress.getText());
        driver.close();
    }
}
