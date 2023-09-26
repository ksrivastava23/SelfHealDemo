package com.auto.utility;

import com.auto.Drivers;
import com.auto.ConfigConstants;
import com.auto.pages.SignInPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base {
    private WebDriver driver;
    //    private WebDriver delegate;
//    private SelfHealingDriver driver;
    private String profile;
    private String configPath;
    private Properties prop = new Properties();
    public static Logger log = LogManager.getLogger();

    private SignInPage signInPage;
    private int countAddedProducts;

    public int getCountAddedProducts() {
        return countAddedProducts;
    }

    public void setCountAddedProducts(int countAddedProducts) {
        this.countAddedProducts = countAddedProducts;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() throws IOException {
        readFromProperties();
        setBrowserDriverSelfHeal(prop.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public SignInPage getSignInPage() {
        return signInPage;
    }

    //    private void setBrowserDriver(String browserName) {
//        switch (browserName.toLowerCase().trim())
//        {
//            case "chrome":
////                setDriverExe(Drivers.DriverEnum.CHROME.getResource(),prop.getProperty("chromedriver"));
//                log.info("Driver setting for Chrome" );
////                driver = new ChromeDriver();
//                WebDriverManager.chromedriver().driverVersion("117.0.5938.88").setup();
//                // Create the driver object
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--remote-allow-origins=*");
//                driver = new ChromeDriver(options);
//                break;
//            case "firefox":
////                setDriverExe(Drivers.DriverEnum.FIREFOX.getResource(), prop.getProperty("firefoxdriver"));
//                log.info("Driver setting for Firefox" );
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//                break;
//            case "safari":
//                log.info("Driver setting for Safari" );
////                driver = new SafariDriver();
//                WebDriverManager.safaridriver().setup();
//                break;
//            case "ie":
////                setDriverExe(Drivers.DriverEnum.IE.getResource(), prop.getProperty("iedriver"));
//                log.info("Driver setting for IE" );
//                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
//                break;
//            default:
//                log.info("No driver found!!");
//        }
//    }
    private void setBrowserDriverSelfHeal(String browserName) {
        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                log.info("Driver setting for Chrome");
//                WebDriverManager.chromedriver().driverVersion("117.0.5938.88").setup();
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                //if(ConfigConstants.getIsLocal()) {
                /////////////////LOCALLY//////////////
                log.info("Driver setting for chrome - remotely");
//                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless");
//                driver = new RemoteWebDriver(options);
                driver = new ChromeDriver(options);
//                delegate = new ChromeDriver(options);
                /////////////////LOCALLY//////////////
                //  }
//                else {
                /////////////////REMOTELY//////////////
//                log.info("Driver setting for chrome - remotely");
//                options.addArguments("--remote-allow-origins=*");
//                options.addArguments("--no-sandbox");
//                options.addArguments("--disable-dev-shm-usage");
//                options.addArguments("--headless");
//                delegate = new RemoteWebDriver(options);
//                }
                /////////////////REMOTELY//////////////
//                driver = SelfHealingDriver.create(delegate);
                break;
            case "firefox":
                log.info("Driver setting for Firefox");
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions foptions = new FirefoxOptions();
//                delegate = new FirefoxDriver(foptions);
//                driver = SelfHealingDriver.create(delegate);
                break;
            case "safari":
                log.info("Driver setting for Safari");
                WebDriverManager.safaridriver().setup();
                break;
            case "ie":
                log.info("Driver setting for IE");
                WebDriverManager.iedriver().setup();
//                driver = new InternetExplorerDriver();
                break;
            default:
                log.info("No driver found!!");
        }
    }


    public void readFromProperties() throws IOException {

        getProfile();
        prop.load(getInputStream());
        log.info("Loading the browser as ---->" + prop.getProperty("browser"));
        String browserName = prop.getProperty("browser");
        setProp(prop);

    }

    private void getProfile() {
        profile = "qa";//System.getenv("ENVIRONMENT").toLowerCase().trim();
        log.info("Environment is set to --> " + profile);
        if (profile == null || profile.isEmpty()) {
            ConfigConstants.setIsLocal(true);
            log.info("Running locally!!!");
        } else {
            ConfigConstants.setIsLocal(false);
        }
    }

    private FileInputStream getInputStream() throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + profile + File.separator + "config.properties");
        return inputStream;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public void setDriverExe(String key, String exePath) {
        System.setProperty(key, exePath);
    }

    public void initializePageObjects(SelfHealingDriver driver, Base base) {
        signInPage = new SignInPage(driver, base);
    }
}
