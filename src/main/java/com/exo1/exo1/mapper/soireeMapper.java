package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.soireeDto;
import com.exo1.exo1.entity.soiree;

@Mapper(componentModel = "spring")
public interface soireeMapper {
    soireeDto toDto( soiree soiree );
    soiree toEntity(soireeDto soireeDto);
    List<soireeDto> toDtos(List<soiree> utilisateurs);
}