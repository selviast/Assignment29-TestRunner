package dibimbing.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {
    private static final String URL = "http://www.saucedemo.com/v1/";

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(css = "[data-test='error']")
    private WebElement errorAlert;

    public LoginPage(WebDriver driver) {
        super(driver); //cek
    }

    public void navigateToSaucedemo() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void assertLoginAlert() {

        WebElement alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']")));

        // Lakukan assertion setelah elemen muncul
        Assertions.assertThat(errorAlert.getText())
                .as("Login alert should be displayed")
                .contains("Epic sadface:");


    }


}
