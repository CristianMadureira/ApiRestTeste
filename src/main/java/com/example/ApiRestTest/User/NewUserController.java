package com.example.ApiRestTest.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class NewUserController {

    @Autowired
    NewUserRepository repository;

    @PostMapping("/users")
    public NewUserResponse registerNewUser(@RequestBody @Valid NewUserRequest request, UriComponentsBuilder uriBuilder) {
        NewUser user = request.toModel();
        repository.save(user);

        URI uri= uriBuilder.path("/users{id}").buildAndExpand(user.getId()).toUri();
        return new NewUserResponse(user);
    }


}
