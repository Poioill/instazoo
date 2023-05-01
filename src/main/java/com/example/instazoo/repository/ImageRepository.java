package com.example.instazoo.repository;

import com.example.instazoo.entity.ImageModel;
import com.example.instazoo.entity.Post;
import com.example.instazoo.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<ImageModel, Long> {
    Optional<ImageModel> findByUserId(Long userId);

    Optional<ImageModel> findByPostId(Long PostId);
}
