package com.talentLMS.UI.driverFactory;
import com.talentLMS.UI.dataProviders.ConfigReader;
import org.openqa.selenium.WebDriver;
public class Driver {
    private Driver(){
        //Singleton pattern
    }
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver == null){
            switch (ConfigReader.getProperty("browser").toLowerCase()){
                case "chrome":
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
                case "edge":
                    driver = EdgeWebDriver.loadEdgeDriver();
                    break;
                case "safari":
                    driver = SafariWebDriver.loadSafariDriver();
                    break;
                case "firefox":
                    driver = FireFoxWebDriver.loadFireFoxDriver();
                    break;
                default:
                    driver = ChromeWebDriver.loadChromeDriver();
                    break;
            }
        }
        return null;
    }
    public static void closeDriver(){
        try {
            if (driver != null){
                driver.close();
                driver.quit();
                driver = null;
            }
        }catch (Exception e){
            System.out.println("Error while closing driver");
        }
    }
}
