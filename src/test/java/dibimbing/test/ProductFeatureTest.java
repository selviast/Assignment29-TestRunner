package dibimbing.test;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.LoginPage;
import org.testng.annotations.Test;

public class ProductFeatureTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void testLogin() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSaucedemo();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(groups = {"regression"})
    public void testAddtoCart() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSaucedemo();
        loginPage.login("standard_user", "secret_sauce");
    }

    @Test(groups = {"regression", "smoke"})
    public void testPayment() {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSaucedemo();
        loginPage.login("standard_user", "secret_sauce");
    }
}
