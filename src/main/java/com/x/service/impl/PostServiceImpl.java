package com.x.service.impl;

import com.x.dto.PostDTO;
import com.x.entity.Post;
import com.x.entity.User;
import com.x.exception.ApiExceptionHandler;
import com.x.exception.ApiRequestException;
import com.x.repository.PostRepository;
import com.x.repository.UserRepository;
import com.x.service.PostService;
import com.x.util.DtoToEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createPost(PostDTO postDTO, String userId) {
        Optional<User> user = Optional.ofNullable(
                userRepository.findById(UUID.fromString(userId))
                        .orElseThrow(() -> new ApiRequestException("user not found.")));
        Post post = DtoToEntity.convertPostDtoToPost(postDTO);
        post.setStatus('A');
        post.setCreatedDate(new Date());
        post.setUser(user.get());
        postRepository.save(post);

    }

    @Override
    public List<Post> findPostsByUserId(String userId) {
        Optional<User> user = Optional.ofNullable(userRepository.findById(UUID.fromString(userId)).orElseThrow(() ->
                new ApiRequestException("User not found.")));
        if(user.isPresent()){
             return postRepository.findByUserId(UUID.fromString(userId));
        }
        return new ArrayList<Post>();
    }
}
