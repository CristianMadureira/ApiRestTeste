package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUserRepository;
import com.example.ApiRestTest.exceptions.NewAddresseRegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class NewAddresseService {

    @Autowired
    NewAddresseRepository repository;

    @Autowired
    NewUserRepository userRepository;

    @Autowired
    ViaCepClient viaCepClient;

    public NewAddresse registerAddresse( NewAddresseRequest request) throws NewAddresseRegisterException {
        String cep = request.getCep();

        if(!cep.matches("^[ ]*[0-9]{5}-?[0-9]{3}[ ]*$"))
            throw new NewAddresseRegisterException(HttpStatus.BAD_REQUEST, "O cep informado é inválido.");

        AddresseViaCep addresseViaCep = viaCepClient.serchAddresseByCep(cep.replaceAll("[- ]", ""));

        if(addresseViaCep.isError()) {
            throw new NewAddresseRegisterException(HttpStatus.BAD_REQUEST, "Desculpe, cep inválido");
        }

        NewAddresse addresse = request.toModel(userRepository);
        repository.save(addresse);
        return addresse;
    }
}
