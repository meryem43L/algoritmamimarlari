# Ürün ve depo stok yönetim sistemi

## Proje Hakkında

Bu proje, ürünlerin ve depo stoklarının düzenli bir şekilde takip edilmesini sağlamak amacıyla geliştirilmiştir.
Sistem sayesinde ürün bilgileri, stok girişleri ve stok çıkışları yönetilebilir. Stok miktarı takip edilerek depo işlemlerinin daha düzenli yürtülmesi amaçlanıyor.
 
##Ekip Üyeleri
Meryem Alsaraj
Hüda Cuma 
Alperen Çetinkaya
Alaattin Yozğut
 
## Kullanılan Teknolojiler

- Java: Projenin temel programlama dili.
- Java Swing: Kullanıcı arayüzünü oluşturmak için.
- Eclipse IDE & VS: Projenin geliştirilmesi için kullanılan ortam.
- Git ve GitHub: Kodların sürüm kontrolü ve ekip çalışması için.

## Projenin Temel İşlevleri

Sistem aşağıdaki temel işlevleri gerçekleştirmek üzere tasarlanmıştır:

1. Ürün Yönetimi:
   Ürün ekleme, silme, güncelleme, arama ve listeleme işlemleri.

2. Stok Girişi:
   Depoya yeni ürün stoklarının giriş tarihleri ve miktarlarıyla kaydedilmesi.

3. Stok Çıkışı:
   Depodan ürün çıkışı yapılması ve stok miktarlarının güncellenmesi.

4. FIFO Stok Yönetimi:
   İlk giren stok partisinin ilk çıkmasını sağlayan FIFO yönteminin uygulanması.

5. Stok Takibi:
   Ürünlerin toplam stok miktarlarının hesaplanması ve düşük stok seviyelerinin belirlenmesi.

6. Stok Hareketleri:
   Gerçekleştirilen stok giriş ve çıkış işlemlerinin takip edilmesi.

7. Arama ve Sıralama:
   Ürünlerin ve stok partilerinin belirli kriterlere göre aranması ve sıralanması.
   
## Kullanılacak Veri Yapıları ve Tercih Nedenleri

### ArrayList
Kullanım alanı:
- Ürünlerin listelenmesi.
- Stok partilerinin tutulması.
- Stok hareketlerinin listelenmesi.

Tercih nedeni:
ArrayList, eleman sayısı çalışma sırasında değişebilen listeler için uygundur. Elemanlara indeks üzerinden erişim sağlar ve sıralama işlemlerini destekler.

### Comparator
Kullanım alanı:
- Stok partilerinin giriş tarihlerine göre sıralanması.
- Ürünlerin isme veya stok miktarına göre sıralanması.

Tercih nedeni:
Comparator, nesnelerin belirli kriterlere göre karşılaştırılmasını ve sıralanmasını sağlar.

### HashMap (geliştirme aşamasında)
Kullanım alanı:
- Ürün ID'sine göre ürünlere hızlı erişim sağlanması.

Tercih nedeni:
HashMap, anahtar-değer mantığıyla çalışır. Ürün ID'si anahtar olarak kullanılarak ilgili ürüne erişim kolaylaştırılabilir.

### FIFO (First In, First Out)
Kullanım alanı:
- Stok çıkış işlemleri.

Tercih nedeni:
Depoya ilk giren stok partisinin önce tüketilmesini sağlar. Böylece stok çıkışları giriş tarihlerine göre gerçekleştirilir.

FIFO işlemi mevcut tasarımda ArrayList içerisindeki stok partilerinin giriş tarihine göre sıralanması ve en eski partiden başlayarak miktar düşülmesiyle uygulanır.

## Temel Sınıf Yapıları

### Product
Ürünlere ait temel bilgileri tutar.
- id
- productCode
- name
- category
- minimumStockLevel

### StockBatch
Depoya giren stok partilerinin bilgilerini tutar.
- batchId
- productId
- initialQuantity
- currentQuantity
- entryDate
- description

### StockManager
Stok işlemlerini yönetir.
- addBatch()
- getTotalStock()
- removeStock()
- getBatches()

### StockMovement
Stok giriş ve çıkış hareketlerinin bilgilerini tutmak için tasarlanmıştır.
- movementId
- productId
- movementType
- quantity
- movementDate
- description

#### UML Sınıf Diyagramı

```mermaid
classDiagram
    class Product {
        -int id
        -String productCode
        -String name
        -String category
        -int minimumStockLevel
    }

    class StockBatch {
        -int batchId
        -int productId
        -int initialQuantity
        -int currentQuantity
        -String entryDate
        -String description
    }

    class StockManager {
        -List~StockBatch~ batches
        +addBatch(StockBatch batch)
        +getTotalStock(int productId) int
        +removeStock(int productId, int quantity) boolean
        +getBatches() List
    }

    class StockMovement {
        -int movementId
        -int productId
        -String movementType
        -int quantity
        -String movementDate
        -String description
    }

    Product "1" --> "0..*" StockBatch
    Product "1" --> "0..*" StockMovement
    StockManager "1" --> "0..*" StockBatch
``` Sınıflar Arasındaki İlişkiler

- Bir Product birden fazla StockBatch kaydına sahip olabilir.
- Her StockBatch yalnızca bir Product ile ilişkilidir.
- StockManager birden fazla StockBatch nesnesini yönetir.
- StockMovement, ilgili ürünün stok giriş veya çıkış işlemini temsil eder.

| Ekip Üyesi | Görevi |
|---|---|
| Hüda Cuma | Ürün yönetimi |
| Meryem Alsaraj | Stok yönetimi ve FIFO işlemleri |
| Alperen Çetinkaya | Veritabanı yönetimi ve JDBC bağlantısı |
| Alaattin Yozğut | Kullanıcı arayüzü (Java Swing) |

