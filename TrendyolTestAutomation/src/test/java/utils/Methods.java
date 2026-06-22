package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.ElementModel;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.time.Duration;
import java.util.List;

public class Methods {

    private List<ElementModel> elements;
    private WebDriver driver;
    private WebDriverWait wait;

    public Methods() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    private By getBy(String key) {
        return ElementStore.getBy(key);
    }

    public WebElement findElement(String key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(getBy(key)));
    }

    public void click(String key) {
        wait.until(ExpectedConditions.elementToBeClickable(getBy(key))).click();
    }

    public void sendKeys(String key, String value) {
        WebElement el = findElement(key);
        el.clear();
        el.sendKeys(value);
    }

    public String getText(String key) {
        return findElement(key).getText();
    }

    public boolean isDisplayed(String key) {
        try {
            return findElement(key).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void waitForUrlToBe(String expectedUrl, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }


    public void waitForElement(String key) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(getBy(key)));
    }

    public void assertElementVisible(String key) {
        Assertions.assertTrue(isDisplayed(key), "Element görünür değil: " + key);
    }

    public void waitForElementAttributeContains(String key, String attribute, String expectedValue, int timeoutSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        localWait.until(ExpectedConditions.attributeContains(getBy(key), attribute, expectedValue));
    }

    public void removeOverlayByJS() {
        try {
            WebElement overlay = driver.findElement(By.cssSelector("div.onboarding-tour__overlay"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].remove();", overlay);
            System.out.println("Overlay JS ile kaldırıldı.");
        } catch (NoSuchElementException e) {
            System.out.println("Overlay zaten yok.");
        }
    }

    public void waitForTextInElement(String key, String expectedText, int timeoutInSeconds) {
        By locator = getBy(key);
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        boolean textFound = customWait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
        if (!textFound) {
            throw new AssertionError("Beklenen metin bulunamadı: " + expectedText);
        }
    }

    public void switchToNewTab() {
        String current = driver.getWindowHandle();
        wait.until(d -> driver.getWindowHandles().size() > 1);
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(current)) {
                driver.switchTo().window(handle);
                break;
            }
        }

    }
    public void clickById(String id) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }
    public void waitForUrlContains(String part, int timeoutInSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        localWait.until(ExpectedConditions.urlContains(part));
    }
    public void waitForTextNotToBe(String key, String notExpected, int timeoutInSeconds) {
        WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        localWait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(getBy(key), notExpected)));
    }
}
