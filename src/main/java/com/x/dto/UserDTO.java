package com.x.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserDTO implements Serializable {
    private String name;
    private Date dob;
    private String username;
    private String password;
}
