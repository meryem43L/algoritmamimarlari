package model;

public class StockMovement {
    private int movementId;
    private int productId;
    private String movementType; 
    private int quantity;
    private String date;
    private String description;

    public StockMovement(int movementId, int productId, String movementType, int quantity, String date, String description) {
        this.movementId = movementId;
        this.productId = productId;
        this.movementType = movementType;
        this.quantity = quantity;
        this.date = date;
        this.description = description;
    }

    public String toCsvLine() {
        return movementId + "," + productId + "," + movementType + "," + quantity + "," + date + "," + description;
    }

    public static StockMovement fromCsvLine(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 6) {
            return new StockMovement(
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim()),
                parts[2].trim(),
                Integer.parseInt(parts[3].trim()),
                parts[4].trim(),
                parts[5].trim()
            );
        }
        return null;
    }

    public int getMovementId() { return movementId; }
    public int getProductId() { return productId; }
    public String getMovementType() { return movementType; }
    public int getQuantity() { return quantity; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "[" + date + "] Urun ID: " + productId + " | " + movementType + " | Adet: " + quantity + " | " + description;
    }
}