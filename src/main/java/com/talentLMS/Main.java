package com.talentLMS;

import com.talentLMS.UI.dataProviders.ConfigReader;
import com.talentLMS.UI.driverFactory.Driver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(ConfigReader.getProperty("browser"));
        Driver.getDriver().get("https://www.amazon.com/");
        Thread.sleep(3000);
        Driver.closeDriver();
        System.out.println("Belek");
    }
}