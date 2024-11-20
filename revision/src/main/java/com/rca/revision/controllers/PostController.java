package com.rca.revision.controllers;

import com.rca.revision.models.Post;
import com.rca.revision.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Post> createUser(@RequestBody Post post){
        return ResponseEntity.ok(service.createPost(post));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllUsers(){
        return ResponseEntity.ok(service.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getPost(@PathVariable UUID id){
        return ResponseEntity.ok(service.getPost(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Post>> updatePost(@RequestBody Post post,@PathVariable UUID id){
        return ResponseEntity.ok(service.updatePost(post,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable UUID id){
        return ResponseEntity.ok(service.deletePost(id));
    }
}
