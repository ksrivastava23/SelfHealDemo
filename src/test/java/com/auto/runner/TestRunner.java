package com.auto.runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:Report" },
        tags = "@smoke",
        glue = "com.auto.stepdefs",
        features = "src/test/resources/features",
        monochrome = true,
        dryRun = false)
public class TestRunner extends AbstractTestNGCucumberTests {


}
