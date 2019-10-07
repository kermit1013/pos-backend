package com.pointofsales.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "stock")
public class Stock extends BaseModel  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stock_id;

    @NotBlank
    private String name;

    private String category;

    private float capacity;

    private String unit;

    private Integer maximum_quantity;

    public Stock() {
    }
    public Long getStock_id() {
        return stock_id;
    }

    public void setStock_id(Long stock_id) {
        this.stock_id = stock_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getMaximum_quantity() {
        return maximum_quantity;
    }

    public void setMaximum_quantity(Integer maximum_quantity) {
        this.maximum_quantity = maximum_quantity;
    }


    @Override
    public String toString() {
        return "Stock{" +
                "stock_id=" + stock_id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", capacity='" + capacity + '\'' +
                ", unit='" + unit + '\'' +
                ", maximum_quantity='" + maximum_quantity + '\'' +
                '}';
    }
}
