package com.x.controller;

import com.x.dto.PostDTO;
import com.x.entity.Post;
import com.x.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO, @RequestParam(value = "userId") String userId){
        postService.createPost(postDTO, userId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPostsByUserId(@RequestParam(value = "userId") String userId){
        return new ResponseEntity<>(postService.findPostsByUserId(userId), HttpStatus.OK);
    }
}
