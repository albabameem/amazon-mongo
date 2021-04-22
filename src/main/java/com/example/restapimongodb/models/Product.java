package com.example.restapimongodb.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Product
{
    @Id
    private String id;
    private String title;
    private String description;
    private String image;
    private Integer category;
    private Integer inventory;
    private boolean bestseller;
    private boolean hero;
    private Double price;

    public Product() {
    }

    public Product(String id, String title, String description, String image, Integer inventory, boolean bestseller, boolean hero, Double price, Integer category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.image = image;
        this.inventory = inventory;
        this.category = category;
        this.bestseller = bestseller;
        this.hero = hero;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public boolean isBestseller() {
        return bestseller;
    }

    public void setBestseller(boolean bestseller) {
        this.bestseller = bestseller;
    }

    public boolean isHero() {
        return hero;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", inventory=" + inventory +
                ", bestseller=" + bestseller +
                ", hero=" + hero +
                ", price=" + price +
                '}';
    }
}
