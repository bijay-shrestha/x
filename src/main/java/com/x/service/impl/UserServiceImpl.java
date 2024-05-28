package com.x.service.impl;

import com.x.dto.UserDTO;
import com.x.entity.User;
import com.x.repository.UserRepository;
import com.x.service.UserService;
import com.x.util.DtoToEntity;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.x.util.DtoToEntity.convertUserDtoToUser;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {
        User user = convertUserDtoToUser(userDTO);
        user.setStatus('A');
        user.setCreatedDate(new Date());
        userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
       return userRepository.findAll();
    }
}
