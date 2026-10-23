public class StockBatch {
	
private int batchId;
private int productId;
private int initialQuantity;
private int currentQuantity;
private String entryDate;
private String description;

public StockBatch(int batchId, int productId, int initialQuantity, int currentQuantity, String entryDate, String description) {

       this.batchId = batchId;
       this.productId = productId;
       this.initialQuantity = initialQuantity;
       this.currentQuantity = currentQuantity;
       this.entryDate = entryDate;
       this.description = description;
}
public int getBatchId() {
     return batchId;
}
public int getProductId() {
	 return productId;
}
public int getInitialQuantity() {
	 return initialQuantity;
}
public int getCurrentQuantity() {
	 return currentQuantity;
}
public String getEntryDate() {
	 return entryDate;
}
public String getDescription() {
	 return description;
}

public void setCurrentQuantity(int currentQuantity) {
	 this.currentQuantity = currentQuantity;
}
}
