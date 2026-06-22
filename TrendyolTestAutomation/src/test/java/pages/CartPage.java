package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Methods;

public class CartPage extends BasePage {


    public CartPage(WebDriver driver) {
        super(driver);
    }
    public void ilkUrunuEkle(){

        WebElement kart = methods.findElement("ilk_urun_kart");
        new Actions(driver).moveToElement(kart).perform();
        methods.click("ilk_urun_sepet_btn");
    }

    public String getSepetUrunSayisi(){
        String metin = methods.getText("sepet_urun_sayisi").trim();
        return metin.isEmpty() ? "0" : metin;
    }

    public void sepeteGit(){
        methods.click("sepete_git_link");
    }

    public String getSepetBaslik(){
        return methods.getText("sepet_baslik").trim();
    }

    public void urunSayisiArttir(){
        methods.click("adet_arttir_btn");
    }

    public String getAdetSayisi(String beklenen){

        methods.waitForElementAttributeContains("adet_selector", "value", beklenen, 15);
        return methods.findElement("adet_selector").getAttribute("value").trim();
    }
}