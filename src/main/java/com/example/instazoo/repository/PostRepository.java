package com.example.instazoo.repository;

import com.example.instazoo.entity.Post;
import com.example.instazoo.entity.Usr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository {
    List<Post> findAllByUsrOrderByCreatedDateDesc(Usr usr);

    List<Post> findAllByOrderByCreatedDateDesc();

    Optional<Post> findPostByIdAndUsr(Long id, Usr usr);
}
