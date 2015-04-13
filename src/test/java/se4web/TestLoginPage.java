package se4web;

import org.openqa.selenium.support.PageFactory;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se4web.pages.HomePage;
import se4web.pages.LoginPage;

public class TestLoginPage extends TestNgTestBase {

  private LoginPage loginpage;
  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
    loginpage = PageFactory.initElements(driver, LoginPage.class);
  }

  @Test (priority=1)
  public void testLoginPageHasTitle() {
    driver.get(baseUrl);
    Assert.assertFalse("".equals(loginpage.getTitle()));
  }

  @Test (priority=1)
  public void testSignInButtonDisplayed() {
    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isDisplayed());
  }

  @Test (priority=1)
  public void testSignInButtonEnabled() {
    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isEnabled());
  }

  @Test (priority=2)
  public void testLoginRightCredentials() {
    driver.get(baseUrl);
    homepage = loginpage.loginTo("se4web@gmail.com", "Se4webSe4web");
    Assert.assertTrue(homepage.getTitle().startsWith("Inbox"));
  }
}
