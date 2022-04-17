package application.mapper;

import application.dto.ProductResponseDto;
import application.entity.FruitEntity;
import org.mapstruct.Mappings;

public interface FruitMapper {
    ProductResponseDto entityToFruitResponseDto(FruitEntity entity);
    @Mappings({
    })
    FruitEntity dtoToFruitEntity(ProductResponseDto dto);
}