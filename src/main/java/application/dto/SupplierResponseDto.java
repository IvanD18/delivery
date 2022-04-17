package application.dto;

import application.entity.FruitEntity;

import java.util.List;

public class SupplierResponseDto {
    List<FruitEntity> fruits;
    private long supplierId;
    private String supplierName;

    public SupplierResponseDto(List<FruitEntity> fruits, long supplierId, String supplierName) {
        this.fruits = fruits;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public SupplierResponseDto() {
    }


}
