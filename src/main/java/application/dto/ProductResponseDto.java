package application.dto;

import application.entity.FruitEntity;
import application.entity.ProductEntity;
import application.entity.SupplierEntity;

import java.util.Date;

public class ProductResponseDto {
    private SupplierEntity supplier;
    private FruitEntity fruit;
    private double price;
    private double weight;
    private Date start;
    private Date end;

    public ProductResponseDto(SupplierEntity supplier, FruitEntity fruit, double price, double weight, Date start, Date end) {
        this.supplier = supplier;
        this.fruit = fruit;
        this.price = price;
        this.weight = weight;
        this.start = start;
        this.end = end;
    }

    public ProductResponseDto(ProductEntity productEntity) {
        this.supplier = productEntity.getSupplier();
        this.fruit = productEntity.getFruit();
        this.price = productEntity.getPrice();
        this.weight = productEntity.getWeight();
        this.start = productEntity.getStartTimestamp();
        this.end = productEntity.getEndTimestamp();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    public FruitEntity getFruit() {
        return fruit;
    }

    public void setFruit(FruitEntity fruit) {
        this.fruit = fruit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
