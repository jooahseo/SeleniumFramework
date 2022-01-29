import org.testng.annotations.Test;
import pageObject.Homepage;

import java.io.IOException;

public class HomepageTest extends Base{

    @Test
    public void HomeNavigation() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get("https://qaclickacademy.com/");

        Homepage home = new Homepage(driver);
        home.clickLogin();

        Thread.sleep(3000);
        driver.quit();
    }
}
