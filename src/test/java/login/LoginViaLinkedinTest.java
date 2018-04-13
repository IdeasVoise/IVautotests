package login;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by qwerty on 4/2/18.
 */
public class LoginViaLinkedinTest {

    WebDriver driver;

    @Before
    public void beforeTest(){

        driver = new ChromeDriver();
        driver.get("https://www.ideasvoice.com/en/");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void loginViaLinkedinTest() throws InterruptedException, IOException {

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        LandingPage landingPage = new LandingPage(driver);

        landingPage.loginButton.click();

        Actions actions = new Actions(driver);

        actions.moveToElement(landingPage.loginByLinkedinButton).click().perform();

        String parentWindow = driver.getWindowHandle();

        for (String windHandle : driver.getWindowHandles()){
            driver.switchTo().window(windHandle);
        }

        WebElement emailInputField = driver.findElement(By.id("session_key-oauthAuthorizeForm"));
        emailInputField.sendKeys("olga.ideasvoice@gmail.com");

        WebElement passwordInputField = driver.findElement(By.id("session_password-oauthAuthorizeForm"));
        passwordInputField.sendKeys("orangesputnik123");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        submitButton.click();

        driver.switchTo().window(parentWindow);

        String expectedName = "John Smitt";
        WebElement actualName = driver.findElement(By.xpath("//div[@class=\"btn-group blue-dropdown\"]/a/div"));

        Assert.assertTrue(expectedName.equals(actualName.getText()));



    }

}
