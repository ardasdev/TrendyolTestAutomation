Feature: Sepet İşlemleri

  Background:
    Given kullanıcı trendyol sitesine gider

  Scenario Outline: Ürünü sepete ekleme
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   listedeki ilk ürünü sepete ekler
    Then  ürün sepete eklenir

    Examples:
      | aranan |
      | kablosuz kulaklık |

  Scenario Outline: Sepeti görüntüleme
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   listedeki ilk ürünü sepete ekler
    When  sepetim sayfasına gider
    Then  sepetteki ürün görüntülenir

    Examples:
      | aranan |
      | kablosuz kulaklık |

  Scenario Outline: Sepetteki ürün adedini artırma
    When  arama kutusuna "<aranan>" yazar
    And   aramayı başlatır
    And   listedeki ilk ürünü sepete ekler
    When  sepetim sayfasına gider
    And   ürünün adet artırma butonuna tıklar
    Then  ürün adedi "<adet>" olur

    Examples:
      | aranan            | adet |
      | kablosuz kulaklık | 2    |