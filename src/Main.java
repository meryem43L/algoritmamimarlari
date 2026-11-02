import java.util.ArrayList;
import java.util.List;
import io.FileManager;
import model.Product;
import model.StockMovement;
import datastructure.MovementHistory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEPO SİSTEMİ BASLATILIYOR ===");
        FileManager.initializeFiles();

        
        System.out.println("\n--- 1. Ürünler Kaydediliyor (Yeni Product Modeli) ---");
        List<Product> urunler = new ArrayList<>();
        urunler.add(new Product(1, "PRD-001", "Laptop", "Elektronik", 5));
        urunler.add(new Product(2, "PRD-002", "Kablosuz Mouse", "Elektronik", 10));
        urunler.add(new Product(3, "PRD-003", "Mekanik Klavye", "Elektronik", 8));

        FileManager.saveProducts(urunler);

        
        List<Product> okunanUrunler = FileManager.loadProducts();
        for (Product p : okunanUrunler) {
            System.out.println("Okunan Ürün: " + p);
        }

        
        System.out.println("\n--- 2. Stok Hareketleri Ekleniyor ---");
        StockMovement m1 = new StockMovement(1, 1, "GIRIS", 20, "2026-11-02 10:00", "Laptop stoku eklendi");
        StockMovement m2 = new StockMovement(2, 2, "GIRIS", 50, "2026-11-02 11:30", "Mouse stoku güncellendi");
        StockMovement m3 = new StockMovement(3, 1, "CIKIS", 3, "2026-11-02 14:00", "Satis yapildi");

        FileManager.logMovement(m1);
        FileManager.logMovement(m2);
        FileManager.logMovement(m3);

        MovementHistory history = FileManager.loadMovements();
        System.out.println("\nHareketler (En Yeniden En Eskiye):");
        for (StockMovement m : history.getMovementsNewestFirst()) {
            System.out.println(m);
        }

        
        System.out.println("\n--- 3. Son İşlemi Geri Al (Undo - Stack pop) ---");
        StockMovement geriAlinan = history.pop();
        System.out.println("Geri alinan: " + geriAlinan);
        System.out.println("Kalan hareket sayisi: " + history.getSize());
    }
}