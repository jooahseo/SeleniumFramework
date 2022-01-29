package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    By emailInput = By.id("user_email");
    By passwordInput = By.id("user_password");
    By loginBtn = By.xpath("//input[@value='Log In']");
    By errorDiv = By.xpath("//div[@role='alert']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void login(String email, String password){
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public boolean errorMessageExist(String message){
        return driver.findElement(errorDiv).getText().contains(message);
    }
}
