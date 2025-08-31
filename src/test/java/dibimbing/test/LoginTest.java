package dibimbing.test;

import dibimbing.core.BaseTest;
import dibimbing.core.DriverManager;
import dibimbing.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    //    Example for static define data provider
    @DataProvider(name = "loginCredentials")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "success"},
                {"locked_out_user", "secret_sauce", "failure"},
                {"problem_user", "secret_sauce", "success"},
                {"invalid_user", "bad_password", "failure"}

        };
    }

    @Test(groups = {"smoke"}, dataProvider = "loginCredentials")
    public void testLoginScenarios(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSaucedemo();
        loginPage.login(username, password);

        if ("success".equals(expectedResult)) {
            // cek halaman utama terbuka
            String actualTitle = DriverManager.getDriver().getTitle();
            Assert.assertEquals(actualTitle, "Swag Labs", "Login gagal, halaman utama tidak muncul");
        } else {
            // cek error muncul
            loginPage.assertLoginAlert();
        }

    }

}
