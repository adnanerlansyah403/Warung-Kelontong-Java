package entity;

public class Product {

    private String name;
    private Integer price;
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStock() {
        return quantity;
    }

    public void setStock(Integer quantity) {
        this.quantity = quantity;
    }


    public Product(String name, Integer price, Integer quantity) {
        this.name = name;
        this.price= price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price + " (Stok: " + quantity + ")";
    }


}