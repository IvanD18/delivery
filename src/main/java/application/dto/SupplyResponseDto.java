package application.dto;

import application.entity.HistoryEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SupplyResponseDto {
    private List<ProductResponseDto> products;
    private double price;
    private double weight;
    private Date date;


    public List<ProductResponseDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductResponseDto> products) {
        this.products = products;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public SupplyResponseDto(HistoryEntity historyEntity) {
        this.products = historyEntity.getProducts().stream().map(ProductResponseDto::new).collect(Collectors.toList());
        this.price = historyEntity.getPrice();
        this.weight = historyEntity.getWeight();
        this.date = historyEntity.getDate();
    }

    public SupplyResponseDto(List<ProductResponseDto> products, double price, double weight, Date date) {
        this.products = products;
        this.price = price;
        this.weight = weight;
        this.date = date;
    }
}
