package com.app.categories.infrastructure;

public class CategoryDto {
    private Integer id;
    private String name;

    // Empty constructor
    public CategoryDto() {
    }

    // Constructor with parameters
    public CategoryDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // toString() method
    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
