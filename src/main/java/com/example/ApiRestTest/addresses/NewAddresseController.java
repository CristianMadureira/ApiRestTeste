package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NewAddresseController {

    @Autowired
    NewAddresseRepository repository;

    @Autowired
    NewUserRepository userRepository;

    @PostMapping("/addresses")
    public ResponseEntity<NewAddresseResponse> registerNewAddresses(@RequestBody @Valid NewAddresseRequest request, UriComponentsBuilder uriBuilder){
        NewAddresse addresse = request.toModel(userRepository);
        repository.save(addresse);

        URI uri = uriBuilder.path("/addresses/{id}").buildAndExpand(addresse.getId()).toUri();
        return ResponseEntity.created(uri).body(new NewAddresseResponse(addresse));
    }
}
