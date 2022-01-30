import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class TestBase extends Base{
    public static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeMethod
    public void getStarted() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        log.info("Navigate to: " + prop.getProperty("url"));
    }

    @AfterMethod
    public void finishTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
