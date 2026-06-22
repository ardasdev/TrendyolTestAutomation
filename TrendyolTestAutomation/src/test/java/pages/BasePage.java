package pages;

import org.openqa.selenium.WebDriver;
import utils.Methods;

public abstract class BasePage {

    protected WebDriver driver;
    protected Methods methods;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.methods = new Methods();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void goTo(String url) {
        driver.get(url);
    }
}