package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductDetailPage;
import utils.DriverManager;

public class ProductDetailSteps {


    WebDriver driver = DriverManager.getDriver();

    ProductDetailPage productDetailPage = new ProductDetailPage(driver);


    @When("listedeki ilk ürüne tıklar")
    public void listedeki_ilk_ürüne_tıklar() {

        productDetailPage.urunTıkla();
    }
    @Then("ürün adı ve fiyatı görüntülenir")
    public void ürün_adı_ve_fiyatı_görüntülenir() {
        String ad = productDetailPage.getUrunAdi();
        String fiyat = productDetailPage.getUrunFiyati();

        Assert.assertFalse("Ürün adı boş", ad.isEmpty());
        Assert.assertFalse("Ürün fiyatı boş", fiyat.isEmpty());
    }

}
