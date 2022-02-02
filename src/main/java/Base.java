import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver getDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("/Users/jooahseo/Google Drive (seo.jooah@gmail.com)/Coding Bootcamp/Java/SeleniumFramework/src/main/resources/data.properties");

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

    public void getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        System.out.println("WHAT IS THE DIR "+ System.getProperty("user.dir"));
        String file = System.getProperty("user.dir")+"/reports/"+ testCaseName +".png";
        FileUtils.copyFile(source, new File(file));
    }
}
