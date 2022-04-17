package application.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "history",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class HistoryEntity {
    private long historyId;
    private List<ProductEntity> products;
    private double price;
    private double weight;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;


    public HistoryEntity(long historyId, List<ProductEntity> products, double price, double weight, Date date) {
        this.historyId = historyId;
        this.products = products;
        this.price = price;
        this.weight = weight;
        this.date = date;
    }

    public HistoryEntity() {
    }

    @Id
    @Column(name = "ID")
    public long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(long historyId) {
        this.historyId = historyId;
    }

    @OneToMany
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "WEIGHT")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
