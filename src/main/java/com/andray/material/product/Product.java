package com.andray.material.product;

import com.andray.material.category.Category;

import javax.persistence.*;
/**
 * The Product is the entity as it is annotated with the @Entity annotation.
 * This class contain the various entity variable, which name is similar with the entity variable in the database table.
 * id is made as a primary key by annotating with the @Id annotation and its value is auto generated.
 * Setter and getter method is generated for all the variables. and the default and parameterized constructor is created.
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private int price;
    @ManyToOne
    private Category category;

    public Product() {

    }

    public Product(String name, String description, int price,Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = new Category(categoryId,"","");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
