package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.typeDeSoireeDto;
import com.exo1.exo1.entity.typeDeSoiree;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-22T09:21:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.3 (Eclipse Adoptium)"
)
@Component
public class typeDeSoireeMapperImpl implements typeDeSoireeMapper {

    @Override
    public typeDeSoireeDto toDto(typeDeSoiree typeDeSoiree) {
        if ( typeDeSoiree == null ) {
            return null;
        }

        typeDeSoireeDto typeDeSoireeDto = new typeDeSoireeDto();

        typeDeSoireeDto.setId( typeDeSoiree.getId() );
        typeDeSoireeDto.setNom( typeDeSoiree.getNom() );

        return typeDeSoireeDto;
    }

    @Override
    public typeDeSoiree toEntity(typeDeSoireeDto typeDeSoireeDto) {
        if ( typeDeSoireeDto == null ) {
            return null;
        }

        typeDeSoiree typeDeSoiree = new typeDeSoiree();

        typeDeSoiree.setId( typeDeSoireeDto.getId() );
        typeDeSoiree.setNom( typeDeSoireeDto.getNom() );

        return typeDeSoiree;
    }

    @Override
    public List<typeDeSoireeDto> toDtos(List<typeDeSoiree> typesDeSoiree) {
        if ( typesDeSoiree == null ) {
            return null;
        }

        List<typeDeSoireeDto> list = new ArrayList<typeDeSoireeDto>( typesDeSoiree.size() );
        for ( typeDeSoiree typeDeSoiree : typesDeSoiree ) {
            list.add( toDto( typeDeSoiree ) );
        }

        return list;
    }
}
