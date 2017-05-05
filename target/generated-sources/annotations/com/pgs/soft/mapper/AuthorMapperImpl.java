package com.pgs.soft.mapper;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.tables.records.AuthorRecord;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2017-05-05T15:47:06+0200",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDTO convertToDTO(AuthorRecord authorRecord) {
        if ( authorRecord == null ) {
            return null;
        }

        AuthorDTO authorDTO = new AuthorDTO();

        authorDTO.setId( authorRecord.getId() );
        authorDTO.setFirstName( authorRecord.getFirstName() );
        authorDTO.setLastName( authorRecord.getLastName() );
        authorDTO.setDateOfBirth( authorRecord.getDateOfBirth() );
        authorDTO.setAddress( authorRecord.getAddress() );

        return authorDTO;
    }

    @Override
    public AuthorRecord convertToEntity(AuthorDTO authorDTO) {
        if ( authorDTO == null ) {
            return null;
        }

        AuthorRecord authorRecord = new AuthorRecord();

        authorRecord.setId( authorDTO.getId() );
        authorRecord.setFirstName( authorDTO.getFirstName() );
        authorRecord.setLastName( authorDTO.getLastName() );
        authorRecord.setDateOfBirth( authorDTO.getDateOfBirth() );
        authorRecord.setAddress( authorDTO.getAddress() );

        return authorRecord;
    }

    @Override
    public List<AuthorDTO> convertToDTOs(List<AuthorRecord> authorRecords) {
        if ( authorRecords == null ) {
            return null;
        }

        List<AuthorDTO> list = new ArrayList<AuthorDTO>();
        for ( AuthorRecord authorRecord : authorRecords ) {
            list.add( convertToDTO( authorRecord ) );
        }

        return list;
    }

    @Override
    public List<AuthorRecord> convertToEntities(List<AuthorDTO> authorDTOs) {
        if ( authorDTOs == null ) {
            return null;
        }

        List<AuthorRecord> list = new ArrayList<AuthorRecord>();
        for ( AuthorDTO authorDTO : authorDTOs ) {
            list.add( convertToEntity( authorDTO ) );
        }

        return list;
    }
}
