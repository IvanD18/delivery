package application.entity;


import javax.persistence.*;

@Entity
@Table(name = "supplier",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "ID" }) })
public class SupplierEntity {
    private long supplierId;
    private String supplierName;

    public SupplierEntity(int supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public SupplierEntity() {
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    @Id
    @Column(name = "ID")
    public Long getSupplierId() {
        return supplierId;
    }

    @Column(name = "SUPPLIER_NAME")
    public String getSupplierName() {
        return supplierName;
    }



}
