package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage {
    private WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailTextfield;

    @FindBy(css = "input#passwd")
    private WebElement passwordTextfield;

    @FindBy(css = "button#SubmitLogin")
    private WebElement loginButton;

    @FindBy(css = ".form-group.form-error #email")
    private WebElement invalidEmail;

    public AuthenticationPage(WebDriver driver) {
      this.driver = driver;

      // This call sets the WebElement fields.
      PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
      emailTextfield.sendKeys(email);
      passwordTextfield.sendKeys(password);
      loginButton.click();
    }
}

