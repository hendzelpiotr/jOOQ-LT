package com.jooq.example.service;

import com.jooq.example.dto.AuthorDTO;
import com.jooq.example.mapper.AuthorMapper;
import com.jooq.example.repository.AuthorRepository;
import com.jooq.example.tables.records.AuthorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by phendzel on 5/5/2017.
 */
@Service
@Transactional
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    public AuthorDTO findAuthorById(Integer id) {
        AuthorRecord author = authorRepository.findAuthorById(id);
        return authorMapper.convertToDTO(author);
    }

    public List<AuthorDTO> findAuthorsByFirstNameOrderByDateOfBirth(String firstName) {
        List<AuthorRecord> authors = authorRepository.findByFirstNameOrderByDateOfBirth(firstName);
        return authorMapper.convertToDTOs(authors);
    }

    public List<AuthorDTO> findAll() {
        List<AuthorRecord> authors = authorRepository.findAll();

        return authorMapper.convertToDTOs(authors);
    }

    public AuthorDTO updateAuthor(Integer id, AuthorDTO authorDTO) {
        AuthorRecord authorRecord = authorMapper.convertToEntity(authorDTO);

        AuthorRecord updatedAuthor = authorRepository.updateAuthor(id, authorRecord);

        return authorMapper.convertToDTO(updatedAuthor);
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        AuthorRecord authorRecord = authorMapper.convertToEntity(authorDTO);

        AuthorRecord insertedAuthor = authorRepository.insertNewAuthor(authorRecord);

        return authorMapper.convertToDTO(insertedAuthor);
    }

    public void deleteById(Integer id) {
        authorRepository.deleteAuthor(id);
    }

}
