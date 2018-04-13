package login;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LandingPage;

import java.util.concurrent.TimeUnit;

/**
 * Created by qwerty on 4/2/18.
 */
public class LoginTest {
    WebDriver driver;

    @Test
    public void loginTest() throws InterruptedException {
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("https://test.ideasvoice.com/en/");

        LandingPage landingPage = new LandingPage(driver);
        Actions actions = new Actions(driver);

        actions.moveToElement(landingPage.loginButton).click().perform();

        landingPage.loginField.sendKeys("olga.kuznetsova+igor@orangesputnik.eu");
        landingPage.passField.sendKeys("123123");
        landingPage.subnitLoginButton.click();

        String expectedName = "Igor 1";
        WebElement actualName = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"bs-navbar-collapse-1\"]/ul[1]/li/div/a/div")));

        Assert.assertTrue(expectedName.equals(actualName.getText()));

        driver.quit();
    }

}
