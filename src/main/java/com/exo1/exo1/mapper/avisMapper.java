package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.avisDto;
import com.exo1.exo1.entity.avis;

@Mapper(componentModel = "spring")
public interface avisMapper {
    avisDto toDto(avis avis);
    avis toEntity(avisDto avisDto);
    List<avisDto> toDtos(List<avis> avis);
}
