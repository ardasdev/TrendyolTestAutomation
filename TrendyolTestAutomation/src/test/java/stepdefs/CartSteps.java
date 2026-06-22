package stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import utils.DriverManager;
import utils.Methods;

public class CartSteps {

    WebDriver driver = DriverManager.getDriver();
    CartPage cartPage = new CartPage(driver);

    @When("listedeki ilk ürünü sepete ekler")
    public void listedeki_ilk_ürünü_sepete_ekler() {
        cartPage.ilkUrunuEkle();
    }

    @Then("ürün sepete eklenir")
    public void ürün_sepete_eklenir() {
        String sayi = cartPage.getSepetUrunSayisi();
        int sayiInt = Integer.parseInt(sayi);
        Assert.assertTrue("Sepet sayısı 0'dan büyük değil: " + sayi, sayiInt > 0);
    }

    @When("sepetim sayfasına gider")
    public void sepetim_sayfasına_gider() {
        cartPage.sepeteGit();
    }

    @Then("sepetteki ürün görüntülenir")
    public void sepetteki_ürün_görüntülenir() {
        String baslik = cartPage.getSepetBaslik();
        Assert.assertTrue("Sepette ürün görünmüyor. Başlık: " + baslik, baslik.contains("Ürün"));
    }
    @When("ürünün adet artırma butonuna tıklar")
    public void ürünün_adet_artırma_butonuna_tıklar() {
        cartPage.urunSayisiArttir();
    }

    @Then("ürün adedi {string} olur")
    public void ürün_adedi_olur(String urunAdedi) {
        Assert.assertEquals("Ürün Adedi Eşleşmedi", urunAdedi, cartPage.getAdetSayisi(urunAdedi));
    }
}