package com.x.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.x.dto.PostDTO;
import com.x.dto.UserDTO;
import com.x.entity.Post;
import com.x.entity.User;
import org.modelmapper.ModelMapper;

public class DtoToEntity {

    public static User convertUserDtoToUser(UserDTO userDTO){
       ModelMapper modelMapper = new ModelMapper();
       return modelMapper.map(userDTO, User.class);
    }

    public static Post convertPostDtoToPost(PostDTO postDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(postDTO, Post.class);
    }

}
