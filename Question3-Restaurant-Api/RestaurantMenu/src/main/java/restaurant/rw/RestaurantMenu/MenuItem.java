package restaurant.rw.RestaurantMenu;

public class MenuItem {
    Long id;
    String name;
    String description;
    Double price;
    String category;
    Boolean available;

    public MenuItem(Long id, String name, String description, Double price, String category,boolean available){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category =category;
        this.available = available;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public Boolean getAvailable(){
        return available;
    }
    public void setAvailable(Boolean available){
        this.available = available;
    }

}

