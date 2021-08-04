package com.example.ApiRestTest.User;

import com.example.ApiRestTest.exceptions.NewUserRegisterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NewUserService {

    @Autowired
    NewUserRepository repository;



    public NewUser registerNewUser(NewUserRequest request) throws NewUserRegisterException {

        Optional<NewUser> cpfEquals = repository.findByCpf(request.getCpf());
        Optional<NewUser> emailEquals = repository.findByEmail(request.getEmail());

        if(cpfEquals.isPresent() && emailEquals.isPresent()) {
            throw new NewUserRegisterException(HttpStatus.BAD_REQUEST, "Desculpe, já existe um usuário com o mesmo cpf e o mesmo e-mail.");
        } else if(cpfEquals.isPresent()) {
            throw new NewUserRegisterException(HttpStatus.BAD_REQUEST, "Desculpe, já existe um usuário com o mesmo cpf");
        } else if(emailEquals.isPresent()) {
            throw new NewUserRegisterException(HttpStatus.BAD_REQUEST, "Desculpe, já existe um usuário com o mesmo email");
        }

        NewUser user = request.toModel();
        repository.save(user);

        return user;
    }

}
