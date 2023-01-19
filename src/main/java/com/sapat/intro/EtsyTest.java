package com.sapat.intro;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EtsyTest extends BaseTest{
    @Test
    public void signIn(){
        Faker faker = new Faker();
        driver.navigate().to("https://www.etsy.com/");
        driver.findElement(By.xpath("//button[contains(text(), 'Войти')]")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'Зарегистрироваться')]")).click();
        Helper.pause(1000);
        WebElement email = driver.findElement(By.xpath("//input[@id='join_neu_email_field']"));
        email.sendKeys(faker.internet().emailAddress());
        Helper.pause(1000);
        WebElement name = driver.findElement(By.xpath("//input[@id='join_neu_first_name_field']"));
        name.sendKeys(faker.name().firstName());
        Helper.pause(1000);
        WebElement password = driver.findElement(By.xpath("//input[@id='join_neu_password_field']"));
        password.sendKeys(faker.internet().password());
        driver.navigate().refresh();
    }
}
