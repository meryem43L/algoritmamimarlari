public class Product {
    private int id;
    private String productCode;
    private String name;
    private String category;
    private int minStockLevel;

   //yapıcı metotlar
    public Product(int id, String productCode, String name, String category, int minStockLevel) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.category = category;
        this.minStockLevel = minStockLevel;
    }

   //set ve get metotlar
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }
    public void setMinStockLevel(int minStockLevel) {
        this.minStockLevel = minStockLevel;
    }

   
}
