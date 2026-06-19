package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {

    private WebDriver driver;

     By searchBoxLocator = By.className("suggestion-placeholder");
     By searchBoxInputLocator = By.className("search-bar-new-input-active-field");
     By searcBoxButtonLocator = By.className("search-bar-new-input-active-search");
     By sonucBasligiLocator = By.cssSelector("h1[data-testid='title']");
     By selectBoxLocator = By.className("select-box");
     By fiyatBaslikLocator = By.xpath("//div[@data-testid='aggregation-header'][.//h3[text()='Fiyat']]");
     By priceInputMin = By.id("price-range-input-min");
     By priceInputMax = By.id("price-range-input-max");
     By priceButton = By.className("price-range-button");



    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void aramaKutusunaGit(){

        driver.findElement(searchBoxLocator).click();
    }
    public void kelimeGir(String item){

        driver.findElement(searchBoxInputLocator).sendKeys(item);
    }
    public void aramaBaslat(){

        driver.findElement(searcBoxButtonLocator).click();
    }
    public String getSonucBasligi() {
        return driver.findElement(sonucBasligiLocator).getText();
    }
    public void dropDownAc(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(selectBoxLocator))
                .click();
    }
    public void siralamaSec(String optionId){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(selectBoxLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id(optionId))).click();
    }
    public String getSeciliSiralama() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.textToBe(selectBoxLocator, "Önerilen Sıralama")));
        return driver.findElement(selectBoxLocator).getText().trim();
    }
    public void fiyatBaslikGit(){
         driver.findElement(fiyatBaslikLocator).click();
    }


    public void fiyatAralıkMin(String min){
        driver.findElement(priceInputMin).sendKeys(min);

    }
    public void fiyatAralıkMax(String max){
        driver.findElement(priceInputMax).sendKeys(max);

    }
    public void fiyatButonTıkla(){
        driver.findElement(priceButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("prc="));
    }
}
