package application.repository;

import application.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
    List<ProductEntity> findProductEntitiesByFruit_FruitNameAndFruit_FruitType(String fruitName, String fruitType);

}
