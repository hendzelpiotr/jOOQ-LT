package com.pgs.soft.service;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.mapper.AuthorMapper;
import com.pgs.soft.repository.AuthorRepository;
import com.pgs.soft.tables.records.AuthorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public AuthorDTO findAuthorById(Integer id) {
        AuthorRecord author = authorRepository.findAuthorById(id);
        return AuthorMapper.INSTANCE.convertToDTO(author);
    }

    @Override
    public List<AuthorDTO> findAuthorsByFirstNameOrderByDateOfBirth(String firstName) {
        List<AuthorRecord> authors = authorRepository.findByFirstNameOrderByDateOfBirth(firstName);
        return AuthorMapper.INSTANCE.convertToDTOs(authors);
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<AuthorRecord> authors = authorRepository.findAll();
        return AuthorMapper.INSTANCE.convertToDTOs(authors);
    }

    @Override
    public AuthorDTO updateAuthor(Integer id, AuthorDTO authorDTO) {
        AuthorRecord authorRecord = AuthorMapper.INSTANCE.convertToEntity(authorDTO);
        AuthorRecord updatedAuthor = authorRepository.updateAuthor(id, authorRecord);
        return AuthorMapper.INSTANCE.convertToDTO(updatedAuthor);
    }

    @Override
    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        AuthorRecord authorRecord = AuthorMapper.INSTANCE.convertToEntity(authorDTO);
        AuthorRecord insertedAuthor = authorRepository.insertNewAuthor(authorRecord);
        return AuthorMapper.INSTANCE.convertToDTO(insertedAuthor);
    }

    @Override
    public void deleteById(Integer id) {
        authorRepository.deleteAuthor(id);
    }

}
