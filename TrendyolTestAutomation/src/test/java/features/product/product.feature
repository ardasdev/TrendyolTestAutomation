Feature: Ürün Detayı

  Background:
    Given kullanıcı trendyol sitesine gider

  Scenario Outline: Ürün detayını görüntüleme
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   listedeki ilk ürüne tıklar
    Then  ürün adı ve fiyatı görüntülenir

    Examples:
      | aranan |
      | kablosuz kulaklık |