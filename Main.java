import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame pencere = new JFrame("Depo Stok Yönetim Sistemi");
            pencere.setSize(1000, 650);
            pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pencere.setLocationRelativeTo(null);
            pencere.setLayout(new BorderLayout());

            // Sol menü
            JPanel menu = new JPanel();
            menu.setBackground(new Color(1, 60, 100));
            menu.setPreferredSize(new Dimension(200, 650));
            menu.setLayout(new GridLayout(7, 1, 5, 5));

            JLabel logo = new JLabel("  DEPO YÖNETİMİ");
            logo.setForeground(Color.ORANGE);
            logo.setFont(new Font("Arial", Font.BOLD, 17));
            menu.add(logo);

            menu.add(menuButonu("Ana Sayfa"));
            menu.add(menuButonu("Ürünler"));
            menu.add(menuButonu("Stok Girişi"));
            menu.add(menuButonu("Stok Çıkışı"));
            menu.add(menuButonu("Stok Hareketleri"));
            menu.add(menuButonu("Raporlar"));

            // Ana içerik
            JPanel icerik = new JPanel(new BorderLayout(15, 15));
            icerik.setBackground(new Color(245, 247, 250));
            icerik.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            JLabel baslik = new JLabel("Depo Stok Yönetimi");
            baslik.setFont(new Font("Arial", Font.BOLD, 26));
            icerik.add(baslik, BorderLayout.NORTH);

            // Üst özet kartları
            JPanel kartlar = new JPanel(new GridLayout(1, 3, 12, 12));
            kartlar.setOpaque(false);

            kartlar.add(ozetKarti("Ürün Çeşidi", "0"));
            kartlar.add(ozetKarti("Toplam Stok", "0"));
            kartlar.add(ozetKarti("Kritik Stok", "0"));

            // Ürün tablosu
            String[] sutunlar = {
                "Ürün Kodu", "Ürün Adı", "Kategori", "Miktar"
            };

            DefaultTableModel model =
                new DefaultTableModel(sutunlar, 0) {
                    @Override
                    public boolean isCellEditable(int satir, int sutun) {
                        return false;
                    }
                };

            JTable tablo = new JTable(model);
            tablo.setRowHeight(30);
            tablo.setFont(new Font("Arial", Font.PLAIN, 14));
            tablo.getTableHeader().setFont(
                new Font("Arial", Font.BOLD, 14)
            );

            JScrollPane kaydirma = new JScrollPane(tablo);

            JPanel ortaAlan = new JPanel(new BorderLayout(10, 15));
            ortaAlan.setOpaque(false);
            ortaAlan.add(kartlar, BorderLayout.NORTH);
            ortaAlan.add(kaydirma, BorderLayout.CENTER);

            // Arama alanı
            JPanel aramaPaneli = new JPanel(new FlowLayout(FlowLayout.LEFT));
            aramaPaneli.setOpaque(false);

            JTextField arama = new JTextField(20);
            JButton araButonu = new JButton("Ara");
            JButton ekleButonu = new JButton("Ürün Ekle");

            aramaPaneli.add(new JLabel("Ürün ara:"));
            aramaPaneli.add(arama);
            aramaPaneli.add(araButonu);
            aramaPaneli.add(ekleButonu);

            JPanel merkez = new JPanel(new BorderLayout(10, 15));
            merkez.setOpaque(false);
            merkez.add(aramaPaneli, BorderLayout.NORTH);
            merkez.add(ortaAlan, BorderLayout.CENTER);

            icerik.add(merkez, BorderLayout.CENTER);

            pencere.add(menu, BorderLayout.WEST);
            pencere.add(icerik, BorderLayout.CENTER);

            pencere.setVisible(true);
        });
    }

    private static JButton menuButonu(String metin) {
        JButton buton = new JButton(metin);
        buton.setForeground(Color.WHITE);
        buton.setBackground(new Color(178, 1, 84));
        buton.setFocusPainted(false);
        return buton;
    }

    private static JPanel ozetKarti(String baslik, String deger) {
        JPanel kart = new JPanel(new GridLayout(2, 1, 5, 5));
        kart.setBackground(Color.WHITE);
        kart.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 225, 232)),
            BorderFactory.createEmptyBorder(12, 12, 12, 12)
        ));

        JLabel baslikEtiketi = new JLabel(baslik);
        baslikEtiketi.setForeground(new Color(90, 100, 115));

        JLabel degerEtiketi = new JLabel(deger);
        degerEtiketi.setFont(new Font("Arial", Font.BOLD, 24));

        kart.add(baslikEtiketi);
        kart.add(degerEtiketi);

        return kart;
    }
}