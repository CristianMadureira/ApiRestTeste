package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class NewAddresseController {

    @Autowired
    NewAddresseRepository repository;

    @Autowired
    NewUserRepository userRepository;

    @PostMapping("/addresses")
    public NewAddresseResponse registerNewAddresses(@RequestBody @Valid NewAddresseRequest request){
        NewAddresse addresse = request.toModel(userRepository);
        repository.save(addresse);
        return new NewAddresseResponse(addresse);
    }
}
