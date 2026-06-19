package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    By categoryTabLocater = By.className("category-tab-text");
    By eletrikTabLocater = By.cssSelector("a[href*='elektronik']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

   /* public void hoverDropDown(){
        WebElement anaMenu = wait.until(
                ExpectedConditions.visibilityOfElementLocated(categoryTabLocater));
        actions.moveToElement(anaMenu).perform();
    }

    */
    public void elektrikButton(){

        driver.findElement(eletrikTabLocater).click();

    }


}
