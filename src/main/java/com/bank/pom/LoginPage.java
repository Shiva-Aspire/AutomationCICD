package com.bank.pom;

import com.bank.Utility.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utils {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //*************Locators**************************
    //Username Field
    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;
    //password Field
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordFeild;
    //LoginButton
    @FindBy(xpath = "//button[@id='login-btn']")
    private WebElement loginBtn;
    @FindBy(xpath = "//button[contains(text(), 'Home')]")
    private WebElement loginHomeBtn;
    @FindBy(xpath = "//p[contains(text(), 'Learn and')]")
    private WebElement homeParagraphTxt;
    @FindBy(xpath = "//button[text()='Blog']")
    private WebElement blogBtn;

    @FindBy(xpath = "//h1[text()='Latest Blog Posts']")
    private WebElement blogHdrTxt;


// *********   Actions   ************************

    public void clickOnLoginBtn(String userName, String password) {
        waitOfVisible(usernameField);
        usernameField.sendKeys(userName);
        waitOfVisible(passwordFeild);
        passwordFeild.sendKeys(password);
        click(loginBtn);
    }
    public void clickHomeBtn(){
        click(loginHomeBtn);
    }
    public String getParagraphTxt(){
        return getText(homeParagraphTxt);
    }
    public void clickOnBlogBtn(){
        click(blogBtn);
        getblogPageTxt();
    }
    public String getblogPageTxt(){
        return getText(blogHdrTxt);
    }
    public void getScreenshot(String screenshot){
        takeScreenShot(screenshot);
    }
}
