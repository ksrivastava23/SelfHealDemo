package com.auto.pages;

import com.auto.utility.Base;
import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    private Base base;
    SelfHealingDriver driver;

    public SignInPage(SelfHealingDriver driver, Base base) {
        this.base = base;
        PageFactory.initElements(base.getDriver(),this);
    }

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Name\"]")
    public WebElement txtNameXPath;

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Password\"]")
    public WebElement txtPasswordXPath;

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Email\"]")
    public WebElement txtEmailXPath;

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Country\"]")
    public WebElement txtCountryXPath;

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Phone\"]")
    public WebElement txtPhoneXPath;

    @FindBy(how= How.XPATH, using = "//input[@placeholder=\"Company\"]")
    public WebElement txtCompanyXPath;

    @FindBy(how= How.ID, using = "txtName")
    public WebElement txtNameID;

    @FindBy(how= How.ID, using = "txtPassword")
    public WebElement txtPasswordID;

    @FindBy(how= How.ID, using = "txtEmail")
    public WebElement txtEmailID;

    @FindBy(how= How.ID, using = "txtCountry")
    public WebElement txtCountryID;

    @FindBy(how= How.ID, using = "txtPhone")
    public WebElement txtPhoneID;

    @FindBy(how= How.ID, using = "txtCompany")
    public WebElement txtCompanyID;
    @FindBy(how= How.ID, using = "registerBtn")
    public WebElement btnSignUp;

    @FindBy(how= How.ID, using = "signUpBtn")
    public WebElement btnSignIn;

    public void clickSignIn(){
        btnSignIn.click();
    }
    public void enterLoginCredentialsByXpath(String name, String password, String email)
    {
        txtNameXPath.sendKeys(name);
        txtEmailXPath.sendKeys(email);
        txtPasswordXPath.sendKeys(password);
        txtCountryXPath.sendKeys("United Kingdom");
        txtPhoneXPath.sendKeys("(+44)7778998273");
        txtCompanyXPath.sendKeys("KPMG");
    }

    public void enterLoginCredentialsByID(String name, String password, String email)
    {
        txtNameID.sendKeys(name);
        txtEmailID.sendKeys(email);
        txtPasswordID.sendKeys(password);
        txtCountryID.sendKeys("United Kingdom");
        txtPhoneID.sendKeys("(+44)7778943273");
        txtCompanyID.sendKeys("KPMG");
    }

    public void clickSignUp(){
        btnSignUp.submit();
    }

}
