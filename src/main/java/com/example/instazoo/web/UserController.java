package com.example.instazoo.web;

import com.example.instazoo.dto.UserDTO;
import com.example.instazoo.entity.Usr;
import com.example.instazoo.facade.UserFacade;
import com.example.instazoo.service.UserService;
import com.example.instazoo.validations.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("api/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserFacade userFacade;
    @Autowired
    private ResponseErrorValidation responseErrorValidation;


    @GetMapping("/")
    public ResponseEntity<UserDTO> getCurrentUser(Principal principal) {
        Usr usr = userService.getCurrentUser(principal);
        UserDTO userDTO = userFacade.userToUserDTO(usr);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable("userId") String userId) {
        Usr usr = userService.getUserById(Long.parseLong(userId));
        UserDTO userDTO = userFacade.userToUserDTO(usr);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserDTO userDTO, BindingResult bindingResult, Principal principal) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (ObjectUtils.isEmpty(errors)) return errors;

        Usr usr = userService.updateUser(userDTO, principal);
        UserDTO userUpdated = userFacade.userToUserDTO(usr);
        return new ResponseEntity<>(userUpdated, HttpStatus.OK);
    }
}
