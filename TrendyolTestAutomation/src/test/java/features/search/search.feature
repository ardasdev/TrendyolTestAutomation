Feature: Ürün Arama, Sıralama, Filtreleme

  Background:
    Given kullanıcı trendyol sitesine gider
    When  arama kutusuna "kablosuz kulaklık" yazar
    And   aramayı başlatır

  Scenario: Ürün Arama
    Then  "kablosuz kulaklık" için sonuçlar listelenir

  Scenario: Ürünleri fiyata göre sıralama
    When  sıralama seçeneklerinden "En düşük fiyat" seçilir
    Then  ürünler artan fiyata göre sıralanır

  Scenario: Fiyat aralığına göre filtreleme
    When  Fiyat başlık tıklar
    And   minimum fiyat "500" yazar
    And   maksimum fiyat "1500" yazar
    And   fiyat filtresini uygular
    Then  listelenen ürünler "500" ile "1500" aralığında olur