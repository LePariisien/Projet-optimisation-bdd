package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.adresseDto;
import com.exo1.exo1.entity.adresse;

@Mapper(componentModel = "spring")
public interface adresseMapper {
    adresseDto toDto(adresse adresse);
    adresse toEntity(adresseDto adresseDto);
    List<adresseDto> toDtos(List<adresse> adresses);
}
