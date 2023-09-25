package com.auto.utility;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportingUtil {

    private Base base;
    SelfHealingDriver driver;

    public ReportingUtil(Base base) {
        this.base = base;
    }
    public byte[] takeScreenShot(){
        return ((TakesScreenshot)base.getDriver().getDelegate()).getScreenshotAs(OutputType.BYTES);
    }
}
