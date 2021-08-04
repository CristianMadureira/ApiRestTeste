package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUserRepository;
import com.example.ApiRestTest.exceptions.NewAddresseRegisterException;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    NewAddresseService service;



    @PostMapping("/addresses")
    public ResponseEntity<NewAddresseResponse> registerNewAddresses(@RequestBody @Valid NewAddresseRequest request, UriComponentsBuilder uriBuilder) throws NewAddresseRegisterException{

       NewAddresse addresse = service.registerAddresse(request);

        URI uri = uriBuilder.path("/addresses/{id}").buildAndExpand(addresse.getId()).toUri();
        return ResponseEntity.created(uri).body(new NewAddresseResponse(addresse));
    }
}
