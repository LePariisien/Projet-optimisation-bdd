package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.typeDeSoireeDto;
import com.exo1.exo1.entity.typeDeSoiree;

@Mapper(componentModel = "spring")
public interface typeDeSoireeMapper {
    typeDeSoireeDto toDto(typeDeSoiree typeDeSoiree);
    typeDeSoiree toEntity(typeDeSoireeDto typeDeSoireeDto);
    List<typeDeSoireeDto> toDtos(List<typeDeSoiree> typesDeSoiree);
}
