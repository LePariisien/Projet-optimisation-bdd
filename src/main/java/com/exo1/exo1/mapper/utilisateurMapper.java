package com.exo1.exo1.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.exo1.exo1.dto.utilisateurDto;
import com.exo1.exo1.entity.utilisateur;

@Mapper(componentModel = "spring")
public interface utilisateurMapper {
    utilisateurDto toDto( utilisateur utilisateur );
    utilisateur toEntity(utilisateurDto utilisateurDto);
    List<utilisateurDto> toDtos(List<utilisateur> utilisateurs);
}