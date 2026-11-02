package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.StockMovement;
import datastructure.MovementHistory;

public class FileManager {

    
    public static final String DATA_DIR = "data";
    public static final String PRODUCTS_FILE = DATA_DIR + File.separator + "products.txt";
    public static final String BATCHES_FILE = DATA_DIR + File.separator + "batches.txt";
    public static final String MOVEMENTS_FILE = DATA_DIR + File.separator + "movements.txt";

   
    public static void initializeFiles() {
        try {
            File dir = new File(DATA_DIR);
            if (!dir.exists()) {
                dir.mkdirs(); 
            }

            createFileIfNotExists(PRODUCTS_FILE);
            createFileIfNotExists(BATCHES_FILE);
            createFileIfNotExists(MOVEMENTS_FILE);

        } catch (IOException e) {
            System.err.println("Dosya baslatma hatasi: " + e.getMessage());
        }
    }

    private static void createFileIfNotExists(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Olusturuldu: " + path);
        }
    }

    public static List<String> readLines(String filePath) {
        List<String> lines = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return lines;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line.trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Dosya okuma hatasi (" + filePath + "): " + e.getMessage());
        }

        return lines;
    }

    public static void writeLines(String filePath, List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Dosya yazma hatasi (" + filePath + "): " + e.getMessage());
        }
    }

    public static void appendLine(String filePath, String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Dosyaya satir ekleme hatasi (" + filePath + "): " + e.getMessage());
        }
    }

  
    public static void saveProducts(List<Product> products) {
        List<String> lines = new ArrayList<>();
        for (Product p : products) {
            lines.add(p.toCsvLine());
        }
        writeLines(PRODUCTS_FILE, lines);
    }

    public static List<Product> loadProducts() {
        List<Product> products = new ArrayList<>();
        List<String> lines = readLines(PRODUCTS_FILE);
        for (String line : lines) {
            Product p = Product.fromCsvLine(line);
            if (p != null) {
                products.add(p);
            }
        }
        return products;
    }

    
    public static void logMovement(StockMovement movement) {
        appendLine(MOVEMENTS_FILE, movement.toCsvLine());
    }

    public static MovementHistory loadMovements() {
        MovementHistory history = new MovementHistory();
        List<String> lines = readLines(MOVEMENTS_FILE);
        for (String line : lines) {
            StockMovement m = StockMovement.fromCsvLine(line);
            if (m != null) {
                history.push(m);
            }
        }
        return history;
    }
}