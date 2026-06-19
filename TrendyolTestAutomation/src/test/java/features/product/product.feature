Feature: Ürün Detayı

  Background:
    Given kullanıcı trendyol sitesine gider
    When  arama kutusuna "kablosuz kulaklık" yazar
    And   aramayı başlatır

  Scenario: Ürün detayını görüntüleme
    When  listedeki ilk ürüne tıklar
    Then  ürün adı ve fiyatı görüntülenir