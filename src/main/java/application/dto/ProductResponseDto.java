package application.dto;

import application.entity.FruitEntity;
import application.entity.SupplierEntity;

public class ProductResponseDto {
    private SupplierEntity supplier;
    private FruitEntity fruit;
    private double price;
    private double weight;

    public ProductResponseDto(SupplierEntity supplier, FruitEntity fruit, double price, double weight) {
        this.supplier = supplier;
        this.fruit = fruit;
        this.price = price;
        this.weight = weight;
    }
}
