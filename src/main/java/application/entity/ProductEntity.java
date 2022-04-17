package application.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class ProductEntity{
    private long productId;
    private SupplierEntity supplier;
    private FruitEntity fruit;
    private double price;
    private double weight;
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTimestamp;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTimestamp;


    public ProductEntity(long productId, SupplierEntity supplier, FruitEntity fruit, double price, double weight, Date startTimestamp, Date endTimestamp) {
        this.productId = productId;
        this.supplier = supplier;
        this.fruit = fruit;
        this.price = price;
        this.weight = weight;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }

    public ProductEntity() {
    }

    @Column(name = "WEIGHT")
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @OneToOne
    public FruitEntity getFruit() {
        return fruit;
    }

    public void setFruit(FruitEntity fruit) {
        this.fruit = fruit;
    }

    @Id
    @Column(name = "ID")
    public Long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Column(name = "START_TIMESTAMP")
    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    @Column(name = "END_TIMESTAMP")
    public Date getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(Date endTimestamp) {
        this.endTimestamp = endTimestamp;
    }


    @ManyToOne
    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    @Column(name = "PRICE")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
