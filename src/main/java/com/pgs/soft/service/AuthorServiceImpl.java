package com.pgs.soft.service;

import com.pgs.soft.dto.AuthorDTO;
import com.pgs.soft.mapper.AuthorMapper;
import com.pgs.soft.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return AuthorMapper.INSTANCE.convertToDTO(authorRepository.findAuthorById(id));
    }

}
