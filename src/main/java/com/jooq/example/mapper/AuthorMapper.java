package com.jooq.example.mapper;

import com.jooq.example.dto.AuthorDTO;
import com.jooq.example.tables.records.AuthorRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
@Mapper(componentModel = "spring")
public interface AuthorMapper {

    String LOCAL_DATE_FORMAT = "dd.MM.yyyy";

    @Mapping(target = "dateOfBirth", dateFormat = LOCAL_DATE_FORMAT)
    AuthorDTO convertToDTO(AuthorRecord authorRecord);

    AuthorRecord convertToEntity(AuthorDTO authorDTO);

    List<AuthorDTO> convertToDTOs(List<AuthorRecord> authorRecords);

    List<AuthorRecord> convertToEntities(List<AuthorDTO> authorDTOs);

}
