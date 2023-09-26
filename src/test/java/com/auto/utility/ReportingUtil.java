package com.auto.utility;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ReportingUtil {

    private Base base;
    WebDriver driver;

    public ReportingUtil(Base base) {
        this.base = base;
    }
    public byte[] takeScreenShot(){
//        return ((TakesScreenshot)base.getDriver().getDelegate()).getScreenshotAs(OutputType.BYTES);
        return ((TakesScreenshot)base.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
