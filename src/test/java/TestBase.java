import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBase extends Base{

    @BeforeMethod
    public void getStarted() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @AfterMethod
    public void finishTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
