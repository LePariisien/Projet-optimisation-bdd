package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.adresseDto;
import com.exo1.exo1.dto.utilisateurDto;
import com.exo1.exo1.entity.adresse;
import com.exo1.exo1.entity.utilisateur;
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
public class utilisateurMapperImpl implements utilisateurMapper {

    @Override
    public utilisateurDto toDto(utilisateur utilisateur) {
        if ( utilisateur == null ) {
            return null;
        }

        utilisateurDto utilisateurDto = new utilisateurDto();

        utilisateurDto.setId( utilisateur.getId() );
        utilisateurDto.setNom( utilisateur.getNom() );
        utilisateurDto.setPrenom( utilisateur.getPrenom() );
        utilisateurDto.setAge( utilisateur.getAge() );
        utilisateurDto.setVille( utilisateur.getVille() );
        utilisateurDto.setEmail( utilisateur.getEmail() );
        utilisateurDto.setMotDePasse( utilisateur.getMotDePasse() );
        utilisateurDto.setPreferenceSoiree( utilisateur.getPreferenceSoiree() );
        utilisateurDto.setAdresse( adresseToadresseDto( utilisateur.getAdresse() ) );

        return utilisateurDto;
    }

    @Override
    public utilisateur toEntity(utilisateurDto utilisateurDto) {
        if ( utilisateurDto == null ) {
            return null;
        }

        utilisateur utilisateur = new utilisateur();

        utilisateur.setId( utilisateurDto.getId() );
        utilisateur.setNom( utilisateurDto.getNom() );
        utilisateur.setPrenom( utilisateurDto.getPrenom() );
        utilisateur.setAge( utilisateurDto.getAge() );
        utilisateur.setVille( utilisateurDto.getVille() );
        utilisateur.setEmail( utilisateurDto.getEmail() );
        utilisateur.setMotDePasse( utilisateurDto.getMotDePasse() );
        utilisateur.setPreferenceSoiree( utilisateurDto.getPreferenceSoiree() );
        utilisateur.setAdresse( adresseDtoToadresse( utilisateurDto.getAdresse() ) );

        return utilisateur;
    }

    @Override
    public List<utilisateurDto> toDtos(List<utilisateur> utilisateurs) {
        if ( utilisateurs == null ) {
            return null;
        }

        List<utilisateurDto> list = new ArrayList<utilisateurDto>( utilisateurs.size() );
        for ( utilisateur utilisateur : utilisateurs ) {
            list.add( toDto( utilisateur ) );
        }

        return list;
    }

    protected adresseDto adresseToadresseDto(adresse adresse) {
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

    protected adresse adresseDtoToadresse(adresseDto adresseDto) {
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
}
