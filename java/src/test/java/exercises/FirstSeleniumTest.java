package exercises;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testcases.TestShopScenario;

public class FirstSeleniumTest extends TestShopScenario {

    @Test
    public void logInSuccesFull(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");

        // Click on the login link
        driver.findElement(By.className("login")).click();

        // Enter username
        driver.findElement(By.id("email")).sendKeys("tester@test.com");

        // Enter password
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");

        // Click the Log in button
        driver.findElement(By.id("SubmitLogin")).click();

        // Verify if the logout link is displayed
        Assertions.assertThat(driver.findElement(By.cssSelector("a.logout")).isDisplayed())
                .as("Logout link should be displayed").isTrue();

        String validationString = driver.findElement(By.cssSelector("h1.page-heading")).getText();

        // Verify if the MY ACCOUNT text is show
        Assertions.assertThat(validationString).as("My account element was not found").isEqualTo("MY ACCOUNT");

        driver.quit();
    }
}