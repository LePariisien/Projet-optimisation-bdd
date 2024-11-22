package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.centreInteretDto;
import com.exo1.exo1.entity.centreInteret;
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
public class centreInteretMapperImpl implements centreInteretMapper {

    @Override
    public centreInteretDto toDto(centreInteret centreInteret) {
        if ( centreInteret == null ) {
            return null;
        }

        centreInteretDto centreInteretDto = new centreInteretDto();

        centreInteretDto.setId( centreInteret.getId() );
        centreInteretDto.setTitre( centreInteret.getTitre() );
        centreInteretDto.setDescription( centreInteret.getDescription() );

        return centreInteretDto;
    }

    @Override
    public centreInteret toEntity(centreInteretDto centreInteretDto) {
        if ( centreInteretDto == null ) {
            return null;
        }

        centreInteret centreInteret = new centreInteret();

        centreInteret.setId( centreInteretDto.getId() );
        centreInteret.setTitre( centreInteretDto.getTitre() );
        centreInteret.setDescription( centreInteretDto.getDescription() );

        return centreInteret;
    }

    @Override
    public List<centreInteretDto> toDtos(List<centreInteret> centresInteret) {
        if ( centresInteret == null ) {
            return null;
        }

        List<centreInteretDto> list = new ArrayList<centreInteretDto>( centresInteret.size() );
        for ( centreInteret centreInteret : centresInteret ) {
            list.add( toDto( centreInteret ) );
        }

        return list;
    }
}
