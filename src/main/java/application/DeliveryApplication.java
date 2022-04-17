package application;

import application.entity.FruitEntity;
import application.entity.ProductEntity;
import application.entity.SupplierEntity;
import application.repository.FruitRepository;
import application.repository.HistoryRepository;
import application.repository.ProductRepository;
import application.repository.SupplierRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;
import java.util.List;


@EnableJpaRepositories("application.repository")
@SpringBootApplication
public class DeliveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryApplication.class, args);
    }


    @Bean
    public CommandLineRunner runner(FruitRepository fruitRepository, HistoryRepository historyRepository,
                                    ProductRepository productRepository, SupplierRepository supplierRepository) {
        return args -> {
            //if(fruitRepository.getById(1L)==null)
            final FruitEntity first = (new FruitEntity(1, "first", "Apple"));
            final FruitEntity second = new FruitEntity(2, "second", "Apple");
            final FruitEntity third = (new FruitEntity(3, "first", "Pear"));
            final FruitEntity fourth = (new FruitEntity(4, "second", "Pear"));
            fruitRepository.saveAll(List.of(
                    first,
                    second,
                    third,
                    fourth
            ));
            final SupplierEntity supplierEntity1 = (new SupplierEntity(1, "Georg"));
            final SupplierEntity supplierEntity2 = (new SupplierEntity(2, "Petr"));
            supplierRepository.saveAll(List.of(
                    supplierEntity1,
                    supplierEntity2
            ));
            final ProductEntity productEntity1 = (new ProductEntity(1, supplierEntity1, first, 100, 0.1, new Date(1649756448),new Date(1650444048)));
            final ProductEntity productEntity2 = (new ProductEntity(2, supplierEntity2, third, 123, 0.3, new Date(1654850448),new Date(1660120848)));
            final ProductEntity productEntity3 = (new ProductEntity(3, supplierEntity2, second, 160, 0.25, new Date(1660120848),new Date(1662194448)));
            final ProductEntity productEntity4 = (new ProductEntity(4, supplierEntity1, first, 95, 0.08, new Date(1641199248),new Date(1648975248)));
            final ProductEntity productEntity5 = (new ProductEntity(5, supplierEntity2, fourth, 87, 0.4, new Date(1648197648),new Date(1651567248)));
            productRepository.saveAll(List.of(
                    productEntity1,
                    productEntity2,
                    productEntity3,
                    productEntity4,
                    productEntity5

            ));

        };

    }
}