package com.example.instazoo.facade;

import com.example.instazoo.dto.PostDTO;
import com.example.instazoo.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostFacade {
    public PostDTO postToPostDTO(Post post){
        PostDTO postDTO = new PostDTO();
        postDTO.setUsername(post.getUsr().getUsername());
        postDTO.setId(post.getId());
        postDTO.setCaption(post.getCaption());
        postDTO.setLikes(post.getLikes());
        postDTO.setUsersLiked(post.getLikedUsers());
        postDTO.setLocation(post.getLocation());
        postDTO.setTitle(post.getTitle());

        return postDTO;
    }
}
