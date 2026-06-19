Feature: Ana Sayfa

  Background:
    Given kullanıcı trendyol sitesine gider

  Scenario: Kategori menüsünden gezinme

    When   Elektronik kategorisine tıklar
    Then  "Elektronik" kategorisindeki ürünler listelenir