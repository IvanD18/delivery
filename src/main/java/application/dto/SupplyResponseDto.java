package application.dto;

import java.util.Date;
import java.util.List;

public class SupplyResponseDto {
    private List<ProductResponseDto> products;
    private double price;
    private double weight;
    private Date date;

    public SupplyResponseDto() {
    }

    public SupplyResponseDto(List<ProductResponseDto> products, double price, double weight, Date date) {
        this.products = products;
        this.price = price;
        this.weight = weight;
        this.date = date;
    }
}
