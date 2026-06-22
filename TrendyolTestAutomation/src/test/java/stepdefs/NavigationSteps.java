package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class NavigationSteps {

    WebDriver driver = DriverManager.getDriver();

    @Given("kullanıcı trendyol sitesine gider")
    public void kullanıcı_trendyol_sitesine_gider() {

       // driver.get("https://www.trendyol.com");

    }

    @Then("listelenen ürünler {string} ile {string} fiyat aralığında olur")
    public void fiyat_araliginda_olur(String min, String max) {
        String url = driver.getCurrentUrl();
        String beklenen = "prc=" + min + "-" + max;
        Assert.assertTrue("URL beklenen fiyat filtresini içermiyor. Beklenen: " + beklenen + " | URL: " + url, url.contains(beklenen));
    }
}