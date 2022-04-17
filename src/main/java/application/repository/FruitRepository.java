package application.repository;

import application.entity.FruitEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface FruitRepository extends JpaRepository<FruitEntity, Long> {
    List<FruitEntity> findFruitEntitiesBySupplierSupplierName(String supplierName);

}
