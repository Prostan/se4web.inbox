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

  @Test (groups={"login"})
  public void testLoginPageHasTitle() {
    driver.get(baseUrl);
    Assert.assertFalse("".equals(loginpage.getTitle()));
    System.out.println("testLoginPageHasTitle");
  }

  @Test (groups={"login","usability"})
  public void testSignInButtonDisplayed() {
    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isDisplayed());
    System.out.println("testSignInButtonDisplayed");
  }

  @Test (groups={"login","usability"})
  public void testSignInButtonEnabled() {
    driver.get(baseUrl);
    Assert.assertTrue(loginpage.signInButton.isEnabled());
    System.out.println("testSignInButtonEnabled");
  }

  @Test (dependsOnGroups={"login"})
  public void testLoginIncorrectCredentials() {
    driver.get(baseUrl);
    homepage = loginpage.loginTo("se4web@gmail.com", "se4web");
    Assert.assertFalse(homepage.getTitle().startsWith("Inbox"));
    System.out.println("testLoginIncorrectCredentials");
  }

  @Test (dependsOnMethods={"testLoginIncorrectCredentials"})
  public void testLoginCorrectCredentials() {
    driver.get(baseUrl);
    homepage = loginpage.loginTo("se4web@gmail.com", "Se4webSe4web");
    Assert.assertTrue(homepage.getTitle().startsWith("Inbox"));
    System.out.println("testLoginCorrectCredentials");
  }
}
