import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.Homepage;
import pageObject.LoginPage;

public class HomepageTest extends TestBase{

    @Test(dataProvider = "loginData")
    public void testInvalidLogin(String username, String password){
        Homepage home = new Homepage(driver);
        log.info("Go to login page");
        home.clickLogin();

        LoginPage loginPage = new LoginPage(driver);
        log.info("try login with invalid credentials");
        loginPage.login(username, password);
        Assert.assertTrue(loginPage.errorMessageExist("Invalid email or password."));
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData(){
        //row stands for how many different data types test should run
        //column stands for how many values per each test
        Object[][] data = new Object[2][2]; //2 data and 2 tests
        data[0][0] = "test";
        data[0][1] = "1234";

        data[1][0] = "test2";
        data[1][1] = "1234";

        return data;
    }
}
