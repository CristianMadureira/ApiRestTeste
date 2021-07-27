package com.example.ApiRestTest.User;

import com.example.ApiRestTest.addresses.NewAddresse;
import com.example.ApiRestTest.addresses.NewAddresseResponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class NewUserResponse {

    private  long id;
    private String name;
    private String email;
    private String cpf;
    private Date dateBirth;
    private List<NewAddresseResponse> addresses = new ArrayList<NewAddresseResponse>();

    public NewUserResponse(NewUser user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.dateBirth = user.getDateBirth();
        this.addresses.addAll(user.getAdresses().stream().map(address -> address.toResponse()).collect(Collectors.toList()));
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public List<NewAddresseResponse> getAddresses() {
        return addresses;
    }
}
