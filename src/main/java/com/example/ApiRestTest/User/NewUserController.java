package com.example.ApiRestTest.User;

import com.example.ApiRestTest.exceptions.NewUserRegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class NewUserController {

    @Autowired
    NewUserService service;

    @Autowired
    NewUserRepository repository;

    @PostMapping("/users")
    public ResponseEntity<NewUserResponse> registerNewUser(@RequestBody @Valid NewUserRequest request, UriComponentsBuilder uriBuilder) throws NewUserRegisterException{

        NewUser user = service.registerNewUser(request);

        URI uri= uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new NewUserResponse(user));

    }

    @GetMapping("/users/{userId}")
    public NewUserResponse getUserWithAdresse(@PathVariable Long userId) throws NewUserRegisterException{
        Optional<NewUser> user = repository.findById(userId);

        if(user.isPresent()) {
            return new NewUserResponse(user.get());
        } else {
            throw new NewUserRegisterException(HttpStatus.BAD_REQUEST, "Desculpe não encontramos um usuário com este id.");
        }



    }

}
