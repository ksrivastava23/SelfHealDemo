package com.auto.stepdefs;

import com.auto.utility.Base;
import com.auto.utility.ReportingUtil;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class Hook  {


    private Base base;
    SelfHealingDriver driver;

    ReportingUtil reportingUtil;

    public Hook(Base base) {

        this.base = base;
        reportingUtil=new ReportingUtil(base);
    }

    @Before
    public void InitializeTest() throws IOException {
        System.out.println("Opening the browser ..");
        base.setDriver();
    }
//    @After
//    public void TearDownTest(Scenario scenario)
//    {
//        if(scenario.isFailed())
//            System.out.println("Scenario failed.." + scenario.getName());
//        //validate if scenario has failed
//        if(scenario.isFailed()) {
//            final byte[] screenshot = ((TakesScreenshot) base.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName());
//        }
//        System.out.println("Closing the browser ..");
//        base.getDriver().quit();
//    }
    @After
    public void TearDownTest(Scenario scenario)
    {
        System.out.println("Closing the browser ..");
        scenario.attach(reportingUtil.takeScreenShot(),"image/png", scenario.getName());
        base.getDriver().quit();
    }

    @AfterStep
    public void AfterEachStep(Scenario scenario)
    {
        System.out.println("After the step capture screenshot");
        scenario.attach(reportingUtil.takeScreenShot(),"image/png", scenario.getName());
    }
}
