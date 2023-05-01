package com.example.instazoo.service;

import com.example.instazoo.entity.Usr;
import com.example.instazoo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username){
        Usr usr = userRepository.findUsrByEmail(username)
                .orElseThrow(()->new UsernameNotFoundException("Username not found with usrname: " + username));
        return build(usr);
    }

    public Usr loadUserById(Long id){
        return userRepository.findUsrById(id).orElse(null);
    }

    public static Usr build(Usr usr){
        List<GrantedAuthority> authorities = usr.getRole().stream()
                .map(role->new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
        return new Usr(usr.getId(), usr.getUsername(), usr.getEmail(), usr.getPassword(), authorities);
    }
}
