package dibimbing.test;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.HomePage;
import dibimbing.pages.LoginPage;
import org.testng.annotations.Test;


public class HomePageValidationTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void testTitleHomePage() {
        HomePage homepage = new HomePage(DriverManager.getDriver());
        homepage.hardAssertHomePage();
    }

    @Test(groups = {"smoke"})
    public void testContentHomePage() {
        HomePage homepage = new HomePage(DriverManager.getDriver());
        homepage.softAssertHomePage();
    }
}
