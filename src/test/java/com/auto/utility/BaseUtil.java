package com.auto.utility;

import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseUtil {

    protected static String profile;
    public Properties prop = new Properties();

    public void readFromProperties() throws IOException {

//        profile = System.getenv("ENVIRONMENT");
//        if (profile==null)
//        {
//            Assert.fail("Environment variable not set");
//        }
//        FileInputStream inputStream = new FileInputStream("C:\\Users\\khush\\OneDrive\\Projects\\AutomationFramework\\KPMG\\cucumberframework\\src\\test\\resources\\config\\qa\\config.properties");
//        prop.load(inputStream);
//
//        System.out.println("Loading the browser as ---->" + prop.getProperty("browser"));
//        String browserName = prop.getProperty("browser");
//        if (browserName.equals("chromw"))
//        {
//            System.setProperty("webdriver.chrome.driver", "C://Users//khush//OneDrive//Projects//Dependency//chromedriver.exe");
//
//        }




    }
}
