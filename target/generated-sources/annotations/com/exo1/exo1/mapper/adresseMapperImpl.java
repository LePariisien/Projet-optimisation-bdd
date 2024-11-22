package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.adresseDto;
import com.exo1.exo1.entity.adresse;
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
public class adresseMapperImpl implements adresseMapper {

    @Override
    public adresseDto toDto(adresse adresse) {
        if ( adresse == null ) {
            return null;
        }

        adresseDto adresseDto = new adresseDto();

        adresseDto.setId( adresse.getId() );
        adresseDto.setNumero( adresse.getNumero() );
        adresseDto.setRue( adresse.getRue() );
        adresseDto.setVille( adresse.getVille() );
        adresseDto.setCodePostal( adresse.getCodePostal() );

        return adresseDto;
    }

    @Override
    public adresse toEntity(adresseDto adresseDto) {
        if ( adresseDto == null ) {
            return null;
        }

        adresse adresse = new adresse();

        adresse.setId( adresseDto.getId() );
        adresse.setNumero( adresseDto.getNumero() );
        adresse.setRue( adresseDto.getRue() );
        adresse.setVille( adresseDto.getVille() );
        adresse.setCodePostal( adresseDto.getCodePostal() );

        return adresse;
    }

    @Override
    public List<adresseDto> toDtos(List<adresse> adresses) {
        if ( adresses == null ) {
            return null;
        }

        List<adresseDto> list = new ArrayList<adresseDto>( adresses.size() );
        for ( adresse adresse : adresses ) {
            list.add( toDto( adresse ) );
        }

        return list;
    }
}
