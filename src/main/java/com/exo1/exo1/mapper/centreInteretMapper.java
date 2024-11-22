package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.centreInteretDto;
import com.exo1.exo1.entity.centreInteret;

@Mapper(componentModel = "spring")
public interface centreInteretMapper {
    centreInteretDto toDto(centreInteret centreInteret);
    centreInteret toEntity(centreInteretDto centreInteretDto);
    List<centreInteretDto> toDtos(List<centreInteret> centresInteret);
}
