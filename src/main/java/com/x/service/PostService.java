package com.x.service;

import com.x.dto.PostDTO;
import com.x.entity.Post;

import java.util.List;

public interface PostService {
    void createPost(PostDTO postDTO, String userId);

    List<Post> findPostsByUserId(String userId);
}
