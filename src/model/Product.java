package model;

public class Product {
    private int id;
    private String productCode;
    private String name;
    private String category;
    private int minStockLevel;

    
    public Product(int id, String productCode, String name, String category, int minStockLevel) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.category = category;
        this.minStockLevel = minStockLevel;
    }

    
    public String toCsvLine() {
        return id + "," + productCode + "," + name + "," + category + "," + minStockLevel;
    }

    
    public static Product fromCsvLine(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 5) {
            return new Product(
                Integer.parseInt(parts[0].trim()),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim(),
                Integer.parseInt(parts[4].trim())
            );
        }
        return null;
    }

    
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getMinStockLevel() { return minStockLevel; }
    public void setMinStockLevel(int minStockLevel) { this.minStockLevel = minStockLevel; }

    @Override
    public String toString() {
        return "[" + productCode + "] " + name + " (" + category + ") - Min Stok: " + minStockLevel;
    }
}