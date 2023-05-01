package com.example.instazoo.repository;

import com.example.instazoo.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {
    Optional<Usr> findUsrByUsername(String username);

    Optional<Usr> findUsrByEmail(String email);

    Optional<Usr> findUsrById(Long id);

}
