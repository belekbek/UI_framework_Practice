package com.sapat.intro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CssDemo extends BaseTest {

    @Test
    public void cssTest1(){
        driver.get("https://www.amazon.com/");
       // WebElement searchInput = driver.findElement(By.cssSelector("#twotabsearchtextbox")); //---> Мы сохраняем элемент  на новый обьект
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER); // можем работать не сохряняя
        WebElement appleText = driver.findElement(By.cssSelector("li[id='p_89/Apple']"));
        System.out.println(appleText.getText());
        //driver.findElement(By.xpath("(//span[@class='a-expander-prompt'])[12]")).click();
        List<WebElement> allBrands = driver.findElements(By.xpath("//div[@id='brandsRefinements']"));
        for (WebElement e:allBrands){
            if(e.getText().equals("SAMSUNG")){
                e.click();
            }
            System.out.println(e.getText());
        }
    }
}
