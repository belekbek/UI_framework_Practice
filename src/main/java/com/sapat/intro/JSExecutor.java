package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutor extends BaseTest {

    @Test
    public void test1() {
        driver.navigate().to("https://www.etsy.com/");
        Helper.jsScrollDownThePage(driver);
        WebElement element = driver.findElement(By.xpath("//a[@href='https://investors.etsy.com']"));
        //Helper.jsClick(driver, element);
        Helper.scrollToFindElement(driver, element);

    }
}
