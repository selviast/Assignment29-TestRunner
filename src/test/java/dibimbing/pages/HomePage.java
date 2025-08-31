package dibimbing.pages;

import dibimbing.core.DriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage extends BasePage {
//    @FindBy(xpath = "//button[text()='ADD TO CART']")
//    private WebElement addToCartButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void hardAssertHomePage() {

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Swag Labs";

        System.out.println("Checking page title with Hard Assert");

        // Hard Assert
        Assert.assertEquals(actualTitle, expectedTitle, "Title mismatch!");

        // kalau assertion gagal, baris di bawah tidak akan dieksekusi
        System.out.println("Line ini tidak akan dijalankan jika Hard Assert gagal");
    }

    public void softAssertHomePage() {
        SoftAssert softAssert = new SoftAssert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //cek logo
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app_logo")));
        softAssert.assertTrue(logo.isDisplayed(), "Logo should be visible");

        //sengaja di salahin (cek ADD TO CART text)
        WebElement addToCartText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn_primary.btn_inventory")));
        softAssert.assertEquals(addToCartText.getText(), "add to cart");

        // cek add to cart Icon
        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_container")));
        softAssert.assertTrue(addToCart.isDisplayed(), "add to Cart tidak ada ada");

        System.out.println("Test: ini tetap tereksekusi meski ada assert yg gagal");

        softAssert.assertAll();

    }
}
