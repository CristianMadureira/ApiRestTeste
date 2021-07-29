package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUserResponse;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NewAddresseResponse {


    private long id;
    private String street;
    private int number;
    private String complement;
    private String district;
    private String city;
    private String state;
    private String cep;
    private String userName;

    @Deprecated
    public NewAddresseResponse() {

    }

    public NewAddresseResponse(NewAddresse addresse) {
        this.id = addresse.getId();
        this.street = addresse.getStreet();
        this.number = addresse.getNumber();
        this.complement = addresse.getComplement();
        this.district = addresse.getDistrict();
        this.city = addresse.getCity();
        this.state = addresse.getState();
        this.cep = addresse.getCep();
        this.userName = addresse.getUser().getName();
    }

    public long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCep() {
        return cep;
    }
}
