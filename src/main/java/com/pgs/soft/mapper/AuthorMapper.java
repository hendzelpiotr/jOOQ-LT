package com.pgs.soft.mapper;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.tables.records.AuthorRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDTO convertToDTO(AuthorRecord authorRecord);

    AuthorRecord convertToEntity(AuthorDTO authorDTO);

    List<AuthorDTO> convertToDTOs(List<AuthorRecord> authorRecords);

    List<AuthorRecord> convertToEntities(List<AuthorDTO> authorDTOs);

}
