package com.example.AddProductService.Model;

import jakarta.persistence.*;

@Entity // Defines this class as an entity to be managed by JPA:
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    private int id; // Set private for encapsulation
    private String name;
    private Double price;
    private String description;

    // Getter methods
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
