package login;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import pages.LandingPage;

/**
 * Created by qwerty on 3/22/18.
 */
public class LoginViaFaceBookTest {

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
    public void loginByFaceBookTest() throws InterruptedException {
        LandingPage landingPage = new LandingPage(driver);

        Thread.sleep(5000);

        landingPage.loginButton.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(landingPage.loginByFaceBookButton).click().perform();

        String parentWindow = driver.getWindowHandle();

        Thread.sleep(5000);


        for (String windHandle : driver.getWindowHandles()){
            driver.switchTo().window(windHandle);
        }


        WebElement emailInputField = driver.findElement(By.xpath("//*[@id=\"email\"]"));

        emailInputField.sendKeys("olga.kuznetsova+t@orangesputnik.eu");

        WebElement passlInputField = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
        passlInputField.sendKeys("orangesputnik123");

        WebElement loginFButton = driver.findElement(By.id("loginbutton"));
        loginFButton.click();

        Thread.sleep(10000);

        driver.switchTo().window(parentWindow);

        String expectedName = "Jim Hggh";
        WebElement actualName = driver.findElement(By.xpath("//div[@class=\"btn-group blue-dropdown\"]/a/div"));

        Assert.assertTrue(expectedName.equals(actualName.getText()));

    }







}
