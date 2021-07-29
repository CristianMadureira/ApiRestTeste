package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUser;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
//        O segundo passo é criar um cadastro de endereços,
//        sendo obrigatório dados mínimos para cadastro como:
//        logradouro, número, complemento, bairro, cidade, estado e CEP,
//        associando este endereço ao usuário

@Entity
public class NewAddresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String street;

    @NotNull
    private int number;

    @NotBlank
    private String complement;

    @NotBlank
    private String district;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    private String cep;

    @NotNull
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private NewUser user;

    public NewAddresse(String street, int number, String complement, String district, String city, String state, String cep, NewUser user) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.cep = cep;
        this.user = user;
    }

    @Deprecated
    public NewAddresse() {

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

    public NewUser getUser() {
        return user;
    }

    public NewAddresseResponse toResponse() {
        return new NewAddresseResponse(this);
    }
}
