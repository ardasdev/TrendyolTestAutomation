package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailPage {

    private WebDriver driver;
    private WebDriverWait wait;

    By ilkUrunKartLocater = By.cssSelector("[data-product-index='0']");
    By urunAdıLocater = By.cssSelector("[data-testid='product-title']");   // bu locator şüpheli — aşağıda açıklıyorum
    By urunFiyatiLocater = By.className("new-price");

    public ProductDetailPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void urunTıkla(){
        String ilkSekme = driver.getWindowHandle();

        wait.until(ExpectedConditions.elementToBeClickable(ilkUrunKartLocater)).click();

        wait.until(d -> driver.getWindowHandles().size() > 1);

        for (String sekme : driver.getWindowHandles()) {
            if (!sekme.equals(ilkSekme)) {
                driver.switchTo().window(sekme);
                break;
            }
        }
    }

    public String getUrunAdi(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(urunAdıLocater))
                .getText().trim();
    }

    public String getUrunFiyati(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(urunFiyatiLocater))
                .getText().trim();
    }
}