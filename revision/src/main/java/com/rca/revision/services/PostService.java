package com.rca.revision.services;

import com.rca.revision.models.Post;
import com.rca.revision.repos.PostRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepo repository;

    public PostService(PostRepo postRepo){
        this.repository = postRepo;
    }

    public Post createPost(Post post){return repository.save(post);}

    public List<Post> getAllPosts(){
        return repository.findAll();
    }

    public Optional<Post> getPost(UUID id){
        return repository.findById(id);
    }

    public Optional<Post> updatePost(Post post, UUID id){
        return repository.findById(id).map(updatedPost -> {
            updatedPost.setTitle(post.getTitle());
            updatedPost.setDescription(post.getDescription());


            return repository.save(updatedPost);
        });
    }

    public String deletePost(UUID id){
        repository.deleteById(id);
        return "Post deleted";
    }
}
