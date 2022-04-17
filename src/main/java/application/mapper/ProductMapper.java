package application.mapper;

import application.dto.ProductResponseDto;
import application.entity.ProductEntity;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

public interface ProductMapper {
    ProductResponseDto entityToProductResponseDto(ProductEntity entity);
    @Mappings({
            @Mapping(target = "productId", constant = "0"),
            @Mapping(target = "startTimestamp", constant = "20012-12-12 12:12:12"),
            @Mapping(target = "startTimestamp", constant = "2012-12-12 12:12:12")
    })
    ProductEntity dtoToProductEntity(ProductResponseDto dto);
}