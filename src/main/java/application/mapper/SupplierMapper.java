package application.mapper;

import application.dto.SupplierResponseDto;
import application.entity.SupplierEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierResponseDto entityToSupplierResponseDto(SupplierEntity entity);
    @Mappings({
            @Mapping(target = "likes", constant = "0"),
            @Mapping(target = "removed", constant = "false")
    })
    SupplierEntity dtoToSupplierEntity(SupplierResponseDto dto);
}
