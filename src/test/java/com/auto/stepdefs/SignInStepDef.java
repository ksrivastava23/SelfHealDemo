package com.auto.stepdefs;

import com.auto.pages.SignInPage;
import com.auto.utility.Base;
import com.epam.healenium.SelfHealingDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignInStepDef {
    private Base base;
    SelfHealingDriver driver;

    public static Logger log = LogManager.getLogger();
    public SignInPage signInPage;

    public SignInStepDef(Base base) {
        this.base = base;
        signInPage= new SignInPage(base.getDriver(),base);
    }

    @Given("I navigate to the signin page")
    public void iNavigateToTheSigninPage() {
        log.info("Given i navigate");
        base.getDriver().navigate().to(base.getProp().getProperty("url"));
    }

    @And("I enter the {string} {string} and {string}")
    public void iEnterTheAnd(String name, String email, String password) {
        log.info("The user enters sign in details");
        signInPage.enterLoginCredentialsByXpath(name,email,password);
    }

    @And("I click the signup button")
    public void iClickTheSignUpButton() {
        log.info("Clicking the SignUp button");
        signInPage.clickSignUp();
    }

    @And("I click the signin button")
    public void iClickTheSignInButton() {
        log.info("Clicking the SignIn button");
        signInPage.clickSignIn();
    }

    @And("I enter the {string} {string} and {string} using ID")
    public void iEnterTheAndUsingID(String name, String email, String password) {
        log.info("The user enters sign in details");
        signInPage.enterLoginCredentialsByID(name,email,password);
    }

    @Then("I should see the homepage")
    public void iShouldSeeTheHomepage() {

    }
}
