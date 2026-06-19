Feature: Sepet İşlemleri

  Background:
    Given kullanıcı trendyol sitesine gider
    When  arama kutusuna "kablosuz kulaklık" yazar
    And   aramayı başlatır
    And   listedeki ilk ürünü sepete ekler

  Scenario: Ürünü sepete ekleme
    Then  ürün sepete eklenir

  Scenario: Sepeti görüntüleme
    When  sepetim sayfasına gider
    Then  sepetteki ürün görüntülenir

  Scenario: Sepetteki ürün adedini artırma
    When  sepetim sayfasına gider
    And   ürünün adet artırma butonuna tıklar
    Then  ürün adedi "2" olur