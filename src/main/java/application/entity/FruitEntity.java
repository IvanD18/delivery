package application.entity;

import javax.persistence.*;

@Entity
@Table(name = "fruit",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class FruitEntity {
    private long fruitId;
    private String fruitType;
    private String fruitName;

    public FruitEntity(long fruitId, String fruitType, String fruitName) {
        this.fruitId = fruitId;
        this.fruitType = fruitType;
        this.fruitName = fruitName;
    }

    public FruitEntity() {
    }

    @Column(name = "NAME")
    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }



    @Id
    @Column(name = "ID")
    public Long getFruitId() {
        return fruitId;
    }

    public void setFruitId(long fruitId) {
        this.fruitId = fruitId;
    }

    @Column(name = "TYPE")
    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

}
