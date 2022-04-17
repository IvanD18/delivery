package application.service;

import application.dto.SupplyResponseDto;
import application.entity.ProductEntity;
import application.mapper.ProductMapper;
import application.mapper.SupplyMapper;
import application.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import application.repository.FruitRepository;
import application.repository.HistoryRepository;
import application.repository.SupplierRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class DeliveryService {
    private final FruitRepository fruitRepository;
    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final HistoryRepository supplyRepository;
    private final ProductMapper mapper;
    private final SupplyMapper supplyMapper;

    public DeliveryService(ProductRepository productRepository, FruitRepository fruitRepository, SupplierRepository supplierRepository, HistoryRepository supplyRepository, ProductMapper mapper, SupplyMapper supplyMapper) {
        this.fruitRepository = fruitRepository;
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
        this.supplyRepository = supplyRepository;
        this.mapper = mapper;
        this.supplyMapper = supplyMapper;
    }

    public SupplyResponseDto calculateSupply(Map<String, String> fruits, Date date) {
        List<ProductEntity> productEntities = new ArrayList<>();
        fruits.forEach((name, type) -> {
            List<ProductEntity> productsByFruitNameAndFruitType = productRepository.findProductEntitiesByFruit_FruitNameAndFruit_FruitType(name, type);
            Optional<ProductEntity> product = productsByFruitNameAndFruitType
                    .stream()
                    .filter(productEntity -> productEntity.getStartTimestamp().before(date) && productEntity.getEndTimestamp().after(date))
                    .findFirst();
            product.ifPresent(productEntities::add);
        });
        return new SupplyResponseDto(productEntities.stream().map(mapper::entityToProductResponseDto)
                .collect(Collectors.toList()), calculateOverallPrice(productEntities), calculateOverallWeight(productEntities), date);
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
    public void addToHistory(SupplyResponseDto supplyResponseDto){
        supplyRepository.save(supplyMapper.dtoToHistoryEntity(supplyResponseDto));
    }
}
