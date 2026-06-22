package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;
import utils.ElementStore;          // YENİ

import java.time.Duration;


public class Hooks {

    @Before
    public void setUp() {
        ElementStore.load();         // YENİ — elementleri bir kez oku
        DriverManager.getDriver().get("https://www.trendyol.com/");
        popupKapat(DriverManager.getDriver());
        cookieKapat(DriverManager.getDriver());
    }

    private void popupKapat(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.className("modal-section-close"))).click();
        } catch (Exception e) {

        }
    }
    private void cookieKapat(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("onetrust-reject-all-handler"))).click();
        } catch (Exception e) {

        }
    }
    @After
    public void tearDown() {

        DriverManager.closeDriver();
    }
}