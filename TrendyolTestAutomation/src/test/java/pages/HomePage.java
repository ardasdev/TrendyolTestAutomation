package pages;

import org.openqa.selenium.WebDriver;
import utils.Methods;

public class HomePage {

    private Methods methods = new Methods();

    public HomePage(WebDriver driver) { }

    public void elektrikButton(){
        methods.click("elektronik_tab");
    }
}