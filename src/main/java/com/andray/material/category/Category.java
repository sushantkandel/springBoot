package com.andray.material.category;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Category is the entity as it is annotated with the @Entity annotation.
 * This class contain the various entity variable, which name is similar with the entity variable in the database table.
 * id is made as a primary key by annotating with the @Id annotation and its value is auto generated.
 */
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;


    public Category() {
    }

    /**
     * It is a parameterized constructor of Category.
     * @param id
     * @param name
     * @param description
     */
    public Category(Long id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * It is a getter method of parameter id.
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * It is a setter method for parameter id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * It is a getter method of parameter name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * It is a setter method for parameter name.
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * It is a getter method of parameter description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * It is a setter method for parameter description.
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
