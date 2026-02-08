package com.bank.tests;
import com.bank.Utility.GlobalProperties;
import com.bank.pom.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(groups = {"smoke", "regression"}, dataProvider = "validLoginData")
    public void loginWithValidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName,password);
        driver.findElement(By.tagName("a"));
    }

    @Test(groups = {"regression"}, dataProvider = "InvalidLoginData")
    public void loginWithInvalidCreds(String userName, String password) {
        LoginPage lp = new LoginPage(driver);
        lp.clickOnLoginBtn(userName, password);
        String alertText = driver.findElement(By.cssSelector("#alert-message")).getText();
        Assert.assertEquals(alertText,"⚠️ Invalid username or password. Please try again.");
        lp.takeScreenShot("Invalidcreds");
    }
    @Test(groups = {"regression"})
    public void verifyLoginHomeBtn(){
       LoginPage lp = new LoginPage(driver);
       lp.clickHomeBtn();
       Assert.assertEquals(lp.getParagraphTxt(), GlobalProperties.getExpvalues("paragraph.txt"));
    }
    @Test(groups = "regression")
    public void verifyLoginBlog() {
       LoginPage lp=new LoginPage(driver);
       lp.clickOnBlogBtn();//this is an loginBlog action
       Assert.assertEquals(lp.getblogPageTxt(), GlobalProperties.getExpvalues("blogHdr.Txt"));
       lp.takeScreenShot("blogPage");
    }

}
