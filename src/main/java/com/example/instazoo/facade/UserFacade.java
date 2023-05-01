package com.example.instazoo.facade;

import com.example.instazoo.dto.UserDTO;
import com.example.instazoo.entity.Usr;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {
    public UserDTO userToUserDTO(Usr usr) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(usr.getId());
        userDTO.setFirstname(usr.getName());
        userDTO.setLastname(usr.getLastname());
        userDTO.setUsername(usr.getUsername());
        userDTO.setBio(usr.getBio());
        return userDTO;
    }
}
