package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.avisDto;
import com.exo1.exo1.entity.avis;
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
public class avisMapperImpl implements avisMapper {

    @Override
    public avisDto toDto(avis avis) {
        if ( avis == null ) {
            return null;
        }

        avisDto avisDto = new avisDto();

        avisDto.setId( avis.getId() );
        avisDto.setNote( avis.getNote() );
        avisDto.setCommentaire( avis.getCommentaire() );

        return avisDto;
    }

    @Override
    public avis toEntity(avisDto avisDto) {
        if ( avisDto == null ) {
            return null;
        }

        avis avis = new avis();

        avis.setId( avisDto.getId() );
        avis.setNote( avisDto.getNote() );
        avis.setCommentaire( avisDto.getCommentaire() );

        return avis;
    }

    @Override
    public List<avisDto> toDtos(List<avis> avis) {
        if ( avis == null ) {
            return null;
        }

        List<avisDto> list = new ArrayList<avisDto>( avis.size() );
        for ( avis avis1 : avis ) {
            list.add( toDto( avis1 ) );
        }

        return list;
    }
}
