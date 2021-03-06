package se4web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginPage extends Page {

    @FindBy(how = How.ID, using = "Email")
    @CacheLookup
    public WebElement emailTextBox;

    @FindBy(how = How.ID, using = "Passwd")
    @CacheLookup
    public WebElement passwordTextBox;

    @FindBy(how = How.ID, using = "signIn")
    @CacheLookup
    public WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void setEmailTextBox(String strUserName) {
        emailTextBox.sendKeys(strUserName);
    }

    public void setPasswordTextBox(String password) {
        passwordTextBox.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public HomePage loginTo(String strUserName, String password) {
        this.setEmailTextBox(strUserName);
        this.setPasswordTextBox(password);
        this.clickSignIn();
        return PageFactory.initElements(driver, HomePage.class);
    }
}
