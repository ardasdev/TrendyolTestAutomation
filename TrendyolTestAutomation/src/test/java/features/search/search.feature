Feature: Ürün Arama, Sıralama, Filtreleme

  Background:
    Given kullanıcı trendyol sitesine gider

  Scenario Outline: Ürün Arama
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    Then  "<aranan>" için sonuçlar listelenir

    Examples:
      | aranan |
      | kablosuz kulaklık |

  Scenario Outline: Ürünleri fiyata göre sıralama
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   sıralama seçeneklerinden "<siralama>" seçilir
    Then  ürünler artan fiyata göre sıralanır

    Examples:
      | aranan    | siralama |
      | kablosuz kulaklık | En düşük fiyat |

  Scenario Outline: Fiyat aralığına göre filtreleme
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   Fiyat başlık tıklar
    And   minimum fiyat "<min>" yazar
    And   maksimum fiyat "<max>" yazar
    And   fiyat filtresini uygular
    Then  listelenen ürünler "<min>" ile "<max>" aralığında olur

    Examples:
      | aranan  | min  | max  |
      | kablosuz kulaklık | 500  | 1500 |
      | kablosuz kulaklık | 300  | 900  |