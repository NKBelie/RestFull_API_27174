package restaurant.rw.E_CommerceProduct;

public class Product {
    Long productId;
    String name;
    String description;
    Double price;
    String category;
    int stockQuantity;
    String brand;

    public Product(Long productId, String name, String description, Double price, String category, int stockQuantity, String brand) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
        this.brand = brand;
    }
    
    public Long getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Double getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public int getStockQuantity() {
        return stockQuantity;
    }
    public String getBrand() {
        return brand;
    }
    
    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", stockQuantity=" + stockQuantity +
                ", brand='" + brand + '\'' +
                '}';
    }

}
