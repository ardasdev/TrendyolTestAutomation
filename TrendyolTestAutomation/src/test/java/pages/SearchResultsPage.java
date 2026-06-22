package pages;

import org.openqa.selenium.WebDriver;
import utils.Methods;

public class SearchResultsPage {

    private Methods methods = new Methods();

    public SearchResultsPage(WebDriver driver) { }

    public void aramaKutusunaGit(){
        methods.click("arama_kutusu");
    }

    public void kelimeGir(String item){
        methods.sendKeys("arama_input", item);
    }

    public void aramaBaslat(){
        methods.click("arama_btn");
    }

    public String getSonucBasligi() {
        return methods.getText("sonuc_basligi");
    }

    public void dropDownAc(){
        methods.click("siralama_select_box");
    }

    public void siralamaSec(String optionId){
        methods.click("siralama_select_box");
        methods.clickById(optionId);          // dinamik id -> yeni eklenen metot
    }

    public String getSeciliSiralama() {
        methods.waitForTextNotToBe("siralama_select_box", "Önerilen Sıralama", 10);
        return methods.getText("siralama_select_box").trim();
    }

    public void fiyatBaslikGit(){
        methods.click("fiyat_baslik");
    }

    public void fiyatAralıkMin(String min){
        methods.sendKeys("fiyat_min_input", min);
    }

    public void fiyatAralıkMax(String max){
        methods.sendKeys("fiyat_max_input", max);
    }

    public void fiyatButonTıkla(){
        methods.click("fiyat_uygula_btn");
        methods.waitForUrlContains("prc=", 10);
    }
}