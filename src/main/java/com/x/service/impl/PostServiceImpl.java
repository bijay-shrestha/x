package com.x.service.impl;

import com.x.dto.PostDTO;
import com.x.entity.Post;
import com.x.entity.User;
import com.x.repository.PostRepository;
import com.x.repository.UserRepository;
import com.x.service.PostService;
import com.x.util.DtoToEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        Optional<User> user = userRepository.findById(UUID.fromString(userId));
        user.ifPresentOrElse(u -> {
            Post post = DtoToEntity.convertPostDtoToPost(postDTO);
            post.setStatus('A');
            post.setCreatedDate(new Date());
            post.setUser(u);
            postRepository.save(post);
        }, () -> System.out.println("User not found"));


    }

    @Override
    public List<Post> findPostsByUserId(String userId) {
        return postRepository.findByUserId(UUID.fromString(userId));
    }
}
