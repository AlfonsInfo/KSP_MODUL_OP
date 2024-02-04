package model;

import java.math.BigDecimal;

public class Product {
    private int id;
    private String name;
    private String type;
    private BigDecimal price;
    private Integer stock;

    public Product() {
    }

    public Product(int id, String name, String type, BigDecimal price, Integer stock) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    public Product(String name, String type, BigDecimal price, Integer stock) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.stock = stock;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", stock=" + stock + '}';
    }
 
    
    
    
    
}
