package application.mapper;

import application.dto.ProductResponseDto;
import application.dto.SupplyResponseDto;
import application.entity.HistoryEntity;

public interface SupplyMapper {
    ProductResponseDto entityToSupplyResponseDto(HistoryEntity entity);

    HistoryEntity dtoToHistoryEntity(SupplyResponseDto dto);
}