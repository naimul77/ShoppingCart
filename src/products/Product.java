package products;

public class Product {
    private int productID;
    private String productName;
    private String category;
    int purchaseLimit;
    private double price;
    private double length;
    private double width;
    private double height;

    public Product() {
        this(0, "", "");
    }

    public Product(int productID, String productName, String category) {
        this(productID, productName, category, 0, 0.0);
    }

    public Product(int productID, String productName, String category, int purchaseLimit) {
        this(productID, productName, category, purchaseLimit, 0.0);
    }

    public Product(int productID, String productName, String category, int purchaseLimit, double price) {
        this(productID, productName, category, purchaseLimit, price, 0.0, 0.0, 0.0);
    }
    public Product(int productID, String productName, String category, int purchaseLimit, double price, double lenth, double width, double height) {
        this.productID = productID;
        this.productName = productName;
        this.category = category;
        this.purchaseLimit = purchaseLimit;
        this.price = price;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPurchaseLimit() {
        return purchaseLimit;
    }

    public void setPurchaseLimit(int purchaseLimit) {
        this.purchaseLimit = purchaseLimit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void calculateShipmentCost() {

    }

    @Override
    public String toString() {
        return "\nProductID # " + this.productID + "\nProduct Name: " + this.productName + "\nProduct Category: " + this.category + "\nPurchase Limit: " + (this.purchaseLimit < 0 ? Integer.toString(this.purchaseLimit) : "no limit") + "\nPrice: " + this.price;
    }
}
