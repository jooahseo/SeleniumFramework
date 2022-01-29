package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//page object model of https://qaclickacademy.com/
public class Homepage {
    public WebDriver driver;
    By login = By.xpath("//a[contains(normalize-space(),'Login')]");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLogin(){
        driver.findElement(login).click();
    }
}
