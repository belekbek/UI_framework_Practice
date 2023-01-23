package com.sapat.intro;

import org.openqa.selenium.WebDriver;

import java.util.LinkedList;
import java.util.Set;

public class BrowserHelper {
    private WebDriver driver;
    public BrowserHelper(WebDriver driver){
        this.driver = driver;
    }
    public void openURL(String URL){
        driver.navigate().to(URL);
    }
    public void goBack(){
        driver.navigate().back();
    }
    public void goForward(){
        driver.navigate().forward();
    }
    public Set<String> getWindowHandler(){
        return driver.getWindowHandles();
    }
    public void switchToWindow(int index){
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandler());
        if (index < 0 || index > windowsId.size()){
            throw new IllegalArgumentException("Invalid index^ " + index);
        }
        driver.switchTo().window(windowsId.get(index));
    }
    public void switchToParentTab(){
        LinkedList<String> windowsId = new LinkedList<String>(getWindowHandler());
        driver.switchTo().window(windowsId.get(0));
    }

}
