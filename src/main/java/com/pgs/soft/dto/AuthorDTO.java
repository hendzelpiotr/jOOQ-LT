package com.pgs.soft.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

/**
 * Created by phendzel on 5/5/2017.
 */
@Getter
@Setter
public class AuthorDTO {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String address;

}
