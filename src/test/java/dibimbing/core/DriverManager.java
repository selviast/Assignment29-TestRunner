package dibimbing.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        WebDriver webDriver = null;
        switch (browser.toLowerCase()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();
                //biar ga capek kalo ada notif save password
                options.addArguments("--incognito");

                webDriver = new ChromeDriver(options);
                webDriver.manage().window().maximize();
            }


            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                webDriver.manage().window().maximize();
            }
        }
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
