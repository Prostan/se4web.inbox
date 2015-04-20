package se4web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

/**
 * Sample page
 */
public class HomePage extends LoadableComponent<HomePage> {

  private final WebDriver driver;

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  public HomePage(WebDriver driver) {
    this.driver = driver;

    PageFactory.initElements(driver, this);
  }

  @Override
  protected void isLoaded() throws Error {
    String url = driver.getCurrentUrl();
    Assert.assertTrue(url.contains("inbox"), "Not on the right page.");
  }

  @Override
  protected void load() {
    driver.get("https://inbox.google.com");
  }
}
