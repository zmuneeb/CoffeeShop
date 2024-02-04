package com.example.demo.domain;

import com.example.demo.validators.ValidDeletePart;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 *
 *
 *
 *
 */
@Entity
@ValidDeletePart
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="part_type",discriminatorType = DiscriminatorType.INTEGER)
@Table(name="Parts")
public abstract class Part implements Serializable {
    private static final Logger LOGGER = Logger.getLogger(Part.class.getName());
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @Min(value = 0, message = "Price value must be positive")
    double price;
    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @Min(value = 0, message = "Inventory cannot be below zero")
    private int minInv;

    @Min(value = 0, message = "Inventory cannot be below zero")
    private int maxInv;

    @ManyToMany
    @JoinTable(name="product_part", joinColumns = @JoinColumn(name="part_id"),
            inverseJoinColumns=@JoinColumn(name="product_id"))
    Set<Product> products= new HashSet<>();

    public Part() {
    }

    public Part(String name, double price, int maxInv, int inv) {
        this.name = name;
        this.price = price;
        this.maxInv = maxInv;
        this.inv = inv;
    }

    public Part(long id, String name, double price, int maxInv, int inv) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.maxInv = maxInv;
        this.inv = inv;
    }
    public Part(String name, double price, long id, int minInv, int maxInv, int inv) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.minInv = minInv;
        this.maxInv = maxInv;
        this.inv = inv;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }
    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }

    public int getInv() {
        return inv;
    }
    private void validateMin() {
        if (inv < minInv) {
            throw new IllegalArgumentException("Error: Inventory for part is less than the minimum allowed.");
        }
    }

    private void validateMax() {
        if (inv > maxInv) {
            throw new IllegalArgumentException("Error: Inventory for part is greater than the maximum allowed.");
        }
    }
    public void setInv(int inv) {
        LOGGER.info("Setting inv to: " + inv);
        LOGGER.info("Current maxInv is: " + maxInv);
        this.inv = inv;
    }
    public void validateInventory() {
        LOGGER.info("Validating inventory. Current maxInv is: " + maxInv);
        validateMin();
        validateMax();
    }
    public int getMinInv() {
        return minInv;
    }

    public int getMaxInv() {
        return maxInv;
    }
    public boolean isInvValid() {
        return inv >= minInv && inv <= maxInv;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Part part = (Part) o;

        return id == part.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
