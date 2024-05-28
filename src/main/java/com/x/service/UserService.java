package com.x.service;

import com.x.dto.UserDTO;
import com.x.entity.User;

import java.util.List;

public interface UserService {
    void createUser(UserDTO userDTO);

    List<User> getAllUser();

}
