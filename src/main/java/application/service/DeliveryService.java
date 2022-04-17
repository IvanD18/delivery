package application.service;

import application.entity.FruitEntity;
import application.utils.Utils;
import application.entity.HistoryEntity;
import application.entity.ProductEntity;
import application.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.FruitRepository;
import application.repository.HistoryRepository;
import application.repository.SupplierRepository;

import java.util.*;

@Service
@Transactional
public class DeliveryService {
    private final FruitRepository fruitRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final HistoryRepository supplyRepository;

    public DeliveryService(FruitRepository fruitRepository, ProductRepository productRepository, SupplierRepository supplierRepository, HistoryRepository supplyRepository) {
        this.fruitRepository = fruitRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.supplyRepository = supplyRepository;
    }

    public HistoryEntity calculateSupply(Map<String, String> fruits, Date date) {
        List<ProductEntity> productEntities = new ArrayList<>();
        fruits.forEach((name, type) -> {
            List<ProductEntity> productsByFruitNameAndFruitType = productRepository.findProductEntitiesByFruitFruitNameAndFruitFruitType(name, type);
            Optional<ProductEntity> product = productsByFruitNameAndFruitType
                    .stream()
                    .filter(productEntity -> productEntity.getStartTimestamp().before(date) && productEntity.getEndTimestamp().after(date))
                    .findFirst();
            product.ifPresent(productEntities::add);
        });
        return new HistoryEntity(Utils.getCounter(), productEntities, calculateOverallPrice(productEntities), calculateOverallWeight(productEntities), date);
    }

    public double calculateOverallPrice(List<ProductEntity> products) {
        double overallPrice = 0;
        for (ProductEntity product : products) {
            overallPrice += product.getPrice();
        }
        return overallPrice;
    }

    public double calculateOverallWeight(List<ProductEntity> products) {
        double overallWeight = 0;
        for (ProductEntity product : products) {
            overallWeight += product.getWeight();
        }
        return overallWeight;
    }

    public HistoryEntity addToHistory(HistoryEntity historyEntity) {
        return supplyRepository.save(historyEntity);
    }
}
