package dibimbing.core;

import dibimbing.pages.LoginPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeTest(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        DriverManager.initDriver(browser);
        DriverManager.getDriver().manage().window().maximize();
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        loginPage.navigateToSaucedemo();
        loginPage.login("standard_user", "secret_sauce");
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
