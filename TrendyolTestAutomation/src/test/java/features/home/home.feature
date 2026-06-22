Feature: Ana Sayfa

  Background:
    Given kullanıcı trendyol sitesine gider

  Scenario Outline: Kategori menüsünden gezinme
    When  "<kategori>" kategorisine tıklar
    Then  "<kategori>" kategorisindeki ürünler listelenir

    Examples:
      | kategori   |
      | Elektronik |