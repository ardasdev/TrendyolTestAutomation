package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverManager;

public class HomeSteps {


    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);


    @When("{string} kategorisine tıklar")
    public void kategorisine_tiklar(String kategori) {
        homePage.elektrikButton();
    }

    @Then("{string} kategorisindeki ürünler listelenir")
    public void kategorisindeki_ürünler_listelenir(String kategoriAdi) {

        String url = driver.getCurrentUrl();

        Assert.assertTrue("URL kategoriyi içermiyor", url.contains(kategoriAdi.toLowerCase()));

    }
}
