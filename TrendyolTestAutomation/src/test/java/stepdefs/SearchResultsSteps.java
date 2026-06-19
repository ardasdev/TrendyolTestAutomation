package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.SearchResultsPage;
import utils.DriverManager;

public class SearchResultsSteps {

    WebDriver driver = DriverManager.getDriver();

    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

    @Given("kullanıcı trendyol sitesine gider")
    public void kullanıcı_trendyol_sitesine_gider() {

    }


    @When("arama kutusuna {string} yazar")
    public void arama_kutusuna_yazar(String aramaKelimesi) {
        searchResultsPage.aramaKutusunaGit();
        searchResultsPage.kelimeGir(aramaKelimesi);

    }
    @When("aramayı başlatır")
    public void aramayı_başlatır() {
        searchResultsPage.aramaBaslat();

    }
    @Then("{string} için sonuçlar listelenir")
    public void için_sonuçlar_listelenir(String aramaKelimesi) {
        String baslik = searchResultsPage.getSonucBasligi();
        Assert.assertEquals(
                "Arama başlığı beklenenle eşleşmedi",
                aramaKelimesi.toLowerCase(),
                baslik.toLowerCase()
        );
    }

    @When("sıralama seçeneklerinden {string} seçilir")
    public void sıralama_seçeneklerinden_seçilir(String secenek) {
        String optionId;
        if (secenek.equalsIgnoreCase("En düşük fiyat")) {
            optionId = "select-option-PRICE_BY_ASC";
        } else if (secenek.equalsIgnoreCase("En yüksek fiyat")) {
            optionId = "select-option-PRICE_BY_DESC";
        } else {
            throw new IllegalArgumentException("Bilinmeyen sıralama seçeneği: " + secenek);
        }
        searchResultsPage.siralamaSec(optionId);
    }
    @Then("ürünler artan fiyata göre sıralanır")
    public void ürünler_artan_fiyata_göre_sıralanır() {
        String seciliSiralama = searchResultsPage.getSeciliSiralama();
        Assert.assertEquals(
                "Sıralama seçimi butona yansımadı",
                "En Düşük Fiyat",
                seciliSiralama
        );
    }
   @And("Fiyat başlık tıklar")
    public void fiyatBaslikTiklar() {

        searchResultsPage.fiyatBaslikGit();
    }



    @And("minimum fiyat {string} yazar")
    public void minimum_fiyat_yazar(String string) {

        searchResultsPage.fiyatAralıkMin(string);

    }
    @And("maksimum fiyat {string} yazar")
    public void maksimum_fiyat_yazar(String string) {

        searchResultsPage.fiyatAralıkMax(string);

    }
    @And("fiyat filtresini uygular")
    public void fiyat_filtresini_uygular() {

        searchResultsPage.fiyatButonTıkla();

    }
    @Then("listelenen ürünler {string} ile {string} aralığında olur")
    public void listelenen_ürünler_ile_aralığında_olur(String min, String max) {
        String url = driver.getCurrentUrl();
        String beklenenParametre = "prc=" + min + "-" + max;
        Assert.assertTrue("URL beklenen fiyat filtresini içermiyor. Beklenen: " + beklenenParametre + " | URL: " + url, url.contains(beklenenParametre)
        );
    }


}
