package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by qwerty on 3/22/18.
 */
public class LandingPage {

    WebDriver driver;

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]")
    public WebElement loginButton;
    
    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]/div/div/div[1]/input")
    public WebElement loginField;

    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]/div/div/div[2]/input")
    public WebElement passField;

    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]/div/div/div[3]/button")
    public WebElement subnitLoginButton;

    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]/div/div/div[6]/a[1]/div")
    public WebElement loginByFaceBookButton;

    @FindBy(xpath = "//*[@id=\"bs-navbar-collapse-1\"]/ul[2]/li/div/div[1]/div/div/div[6]/a[2]/div")
    public WebElement loginByLinkedinButton;


}
