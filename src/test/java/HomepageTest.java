import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Homepage;
import pageObject.LoginPage;

import java.io.IOException;

public class HomepageTest extends Base{

    @Test
    public void testInvalidLogin() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get("https://qaclickacademy.com/");

        Homepage home = new Homepage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("invalid", "password");
        Assert.assertTrue(login.errorMessageExist("Invalid email or password."));

        Thread.sleep(3000);
        driver.quit();
    }
}
