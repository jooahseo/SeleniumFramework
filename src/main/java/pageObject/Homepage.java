package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//page object model of https://qaclickacademy.com/
public class Homepage {
    public WebDriver driver;

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    By login = By.xpath("//a[contains(normalize-space(),'Login')]");

    public void clickLogin(){
        driver.findElement(login).click();
    }
}
