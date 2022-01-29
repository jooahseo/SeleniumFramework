import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/jooahseo/Google Drive (seo.jooah@gmail.com)/Coding Bootcamp/Java/SeleniumFramework/src/main/java/data.properties");

        prop.load(fis);
        String browser = prop.getProperty("browser");

        //execute browser driver accordingly
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/jooahseo/work/chromedriver");
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){

        }
        return driver;
    }
}
