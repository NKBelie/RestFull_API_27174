package restaurant.rw.E_CommerceProduct;

import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/api/products")
public class ProductController {
    List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product(1L, "Laptop", "High performance laptop", 999.99, "Electronics", 10, "BrandA"));
        products.add(new Product(2L, "Smartphone", "Latest model smartphone", 699.99, "Electronics", 20, "BrandB"));
        products.add(new Product(3L, "Headphones", "Noise-cancelling headphones", 199.99, "Electronics", 15, "BrandC"));
        products.add(new Product(4L, "Coffee Maker", "Automatic coffee maker", 89.99, "Home Appliances", 30, "BrandD"));
        products.add(new Product(5L, "Running Shoes", "Comfortable running shoes", 59.99, "Footwear", 25, "BrandE"));
        products.add(new Product(6L, "Backpack", "Durable backpack", 39.99, "Accessories", 40, "BrandF"));
        products.add(new Product(7L, "Smartwatch", "Fitness tracking smartwatch", 149.99, "Electronics", 18, "BrandG"));
        products.add(new Product(8L, "Blender", "High-speed blender", 129.99, "Home Appliances", 22, "BrandH"));
        products.add(new Product(9L, "Gaming Console", "Next-gen gaming console", 499.99, "Electronics", 12, "BrandI"));
        products.add(new Product(10L, "Electric Kettle", "Fast boiling electric kettle", 29.99, "Home Appliances", 35, "BrandJ"));
    }
    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable Long id) {
        return products.stream().filter(p -> p.productId.equals(id)).findFirst().orElse(null);
    }
    @GetMapping("/category")
    public List<Product> getProductsByCategory(@RequestParam String category) {
        return products.stream().filter(p -> p.category.equalsIgnoreCase(category)).collect(Collectors.toList());
    }
    @GetMapping("/brand")
    public List<Product> getProductsByBrand(@RequestParam String brand) {
        return products.stream().filter(p -> p.brand.equalsIgnoreCase(brand)).collect(Collectors.toList());
    }
    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam String keyword) {
        return products.stream().filter(p -> p.name.toLowerCase().contains(keyword.toLowerCase()) || p.description.toLowerCase().contains(keyword.toLowerCase())).collect(Collectors.toList());
    }
    @GetMapping("/price-range")
    public List<Product> getProductsByPriceRange(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
        return products.stream().filter(p -> p.price >= minPrice && p.price <= maxPrice).collect(Collectors.toList());
    }
    @GetMapping("/in-stock")
    public List<Product> getInStockProducts() {
        return products.stream().filter(p -> p.stockQuantity > 0).collect(Collectors.toList());
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }
    @PutMapping("/{productId}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId.equals(id)) {
                products.set(i, updatedProduct);
                return updatedProduct;
            }
        }
        return null;
    }
    
    @PatchMapping("/{productId}")
    public Product updateStock(@PathVariable Long id, @RequestParam int newStockQuantity) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).productId.equals(id)) {
                products.get(i).setStockQuantity(newStockQuantity);
                return products.get(i);
            }
        }
        return null;
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable Long id) {
        boolean removed = products.removeIf(p -> p.productId.equals(id));
        if (removed) {
            return "Product deleted successfully";
        } else {
            return "Product not found";
        }
    }

}
