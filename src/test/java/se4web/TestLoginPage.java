package se4web;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import se4web.pages.HomePage;
import se4web.pages.LoginPage;

public class TestLoginPage extends TestNgTestBase {

  private LoginPage loginPage;
  private HomePage homepage;

  @BeforeMethod
  public void initPageObjects() {
//    loginPage = PageFactory.initElements(driver, LoginPage.class);
    driver.get(baseUrl);
    loginPage = new LoginPage(driver);
    loginPage.get();
  }

  @Test (groups={"login","usability"})
  public void testSignInButtonDisplayed() {
    Assert.assertTrue(loginPage.signInButton.isDisplayed());
    System.out.println("testSignInButtonDisplayed");
  }

  @Test (groups={"login","usability"})
  public void testSignInButtonEnabled() {
    Assert.assertTrue(loginPage.signInButton.isEnabled());
    System.out.println("testSignInButtonEnabled");
  }

  @Test (dependsOnGroups={"login"})
  public void testLoginIncorrectCredentials() {
    homepage = loginPage.loginTo("incorrect", "incorrect");
    Assert.assertFalse(driver.getTitle().startsWith("Inbox"));
    System.out.println("testLoginIncorrectCredentials");
  }

  @Test (dependsOnMethods={"testLoginIncorrectCredentials"})
  public void testLoginCorrectCredentials() {
    homepage = loginPage.loginTo("se4web@gmail.com", "Se4webSe4web");
    Assert.assertTrue(driver.getTitle().startsWith("Inbox"));
    System.out.println("testLoginCorrectCredentials");
  }

}
