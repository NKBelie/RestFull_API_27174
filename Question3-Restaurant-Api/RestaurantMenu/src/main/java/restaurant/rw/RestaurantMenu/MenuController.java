package restaurant.rw.RestaurantMenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    
    List<MenuItem> menuItems = new ArrayList<>();

    public MenuController(){
        menuItems.add(new MenuItem(1L, "Spaghetti Carbonara", "Classic Italian pasta dish with eggs, cheese, pancetta, and pepper.", 12.99, "Main Course", true));
        menuItems.add(new MenuItem(2L, "Margherita Pizza", "Traditional pizza with tomato sauce, mozzarella cheese, and fresh basil.", 10.99, "Main Course", true));
        menuItems.add(new MenuItem(3L, "Caesar Salad", "Crisp romaine lettuce with Caesar dressing, croutons, and Parmesan cheese.", 8.99, "Appetizer", true));
        menuItems.add(new MenuItem(4L, "Tiramisu", "Classic Italian dessert made with layers of coffee-soaked ladyfingers and mascarpone cheese.", 6.99, "Dessert", true));
        menuItems.add(new MenuItem(5L, "Minestrone Soup", "Hearty vegetable soup with beans, pasta, and a tomato-based broth.", 7.99, "Appetizer", true));
        menuItems.add(new MenuItem(6L, "Grilled Salmon", "Fresh salmon fillet grilled to perfection with lemon butter sauce.", 15.99, "Main Course", false));
        menuItems.add(new MenuItem(7L, "Chocolate Lava Cake", "Decadent chocolate cake with a molten chocolate center.", 7.99, "Dessert", true));
        menuItems.add(new MenuItem(8L, "Garlic Bread", "Toasted bread topped with garlic butter and herbs.", 4.99, "Appetizer", true));
        menuItems.add(new MenuItem(9L, "Fish and Chips", "Battered cod served with crispy fries and tartar sauce.", 13.99, "Main Course", true));
        menuItems.add(new MenuItem(10L, "Cheesecake", "Creamy cheesecake with a graham cracker crust and strawberry topping.", 6.99, "Dessert", true));
    }

    @GetMapping
    public List<MenuItem> getAllMenuItems(){
        return menuItems;
    }
    @GetMapping("/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id){
        return menuItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
    }
    @GetMapping("/{category}")
    public MenuItem getMenuItemByCategory(@PathVariable String category){
        return menuItems.stream().filter(item -> item.getCategory().equals(category)).findFirst().orElse(null);
    }
    @GetMapping("/available")
    public MenuItem getMenuItemByAvailable(@PathVariable boolean available){
        return menuItems.stream().filter(item -> item.getAvailable().equals(available)).findFirst().orElse(null);
    }
    @GetMapping("/name")
    public MenuItem getMenuItemByName(@PathVariable String name){
        return menuItems.stream().filter(item ->item.getName().equals(name)).findFirst().orElse(null);
    }
    @PostMapping
    public MenuItem addMenuItem(@RequestBody MenuItem menuItem){
        menuItems.add(menuItem);
        return menuItem;
    }
    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable Long id, @RequestBody MenuItem updatedMenuItem){
        MenuItem menuItem = menuItems.stream().filter(item -> item.getId().equals(id)).findFirst().orElse(null);
        if(menuItem != null){
            menuItem.setName(updatedMenuItem.getName());
            menuItem.setDescription(updatedMenuItem.getDescription());
            menuItem.setPrice(updatedMenuItem.getPrice());
            menuItem.setCategory(updatedMenuItem.getCategory());
            menuItem.setAvailable(updatedMenuItem.getAvailable());
        }
        return menuItem;
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable Long id){
        menuItems.removeIf(item -> item.getId().equals(id));
    }
    
}
