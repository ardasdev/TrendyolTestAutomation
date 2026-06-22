package pages;

import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public void urunTıkla(){
        methods.click("ilk_urun_kart");
        methods.switchToNewTab();
        
        if (methods.isDisplayed("onboarding_primary_btn")) {
            methods.click("onboarding_primary_btn");
        }
    }

    public String getUrunAdi(){
        return methods.getText("urun_adi").trim();
    }

    public String getUrunFiyati(){
        return methods.getText("urun_fiyati").trim();
    }
}