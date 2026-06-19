package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By ilkUrunKartLocater = By.cssSelector("[data-product-index='0']");
    private By ilkUrunButonLocater = By.cssSelector("[data-product-index='0'] .add-to-basket-button");
    private By sepetUrunSayısıLocater = By.className("basket-count");
    private By sepeteGitLocater = By.className("basket-wrapper-link");
    private By sepetBaslikLocater = By.className("basket-header-title");
    private By arttırButonLocater = By.cssSelector("[data-testid='quantity-button-increment'");
    private By adetSelector = By.cssSelector("[data-testid='quantity-selector']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void ilkUrunuEkle(){
        WebElement kart = wait.until(ExpectedConditions.presenceOfElementLocated(ilkUrunKartLocater));new Actions(driver).moveToElement(kart).perform();
        wait.until(ExpectedConditions.elementToBeClickable(ilkUrunButonLocater)).click();
    }

    public String getSepetUrunSayisi(){

        WebElement el = wait.until(
                ExpectedConditions.visibilityOfElementLocated(sepetUrunSayısıLocater));
        String metin = el.getText().trim();
        return metin.isEmpty() ? "0" : metin;
    }

    public void sepeteGit(){
        wait.until(ExpectedConditions.elementToBeClickable(sepeteGitLocater)).click();
    }

    public String getSepetBaslik(){
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(sepetBaslikLocater)).getText().trim();
    }

    public void urunSayısıArttır(){
        wait.until(ExpectedConditions.elementToBeClickable(arttırButonLocater)).click();
    }

    public String getAdetSayisi(String beklenen){

        wait.until(ExpectedConditions.attributeToBe(adetSelector, "value", beklenen));
        return driver.findElement(adetSelector).getAttribute("value").trim();
    }
}