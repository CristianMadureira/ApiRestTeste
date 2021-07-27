package com.example.ApiRestTest.addresses;

import com.example.ApiRestTest.User.NewUser;
import com.example.ApiRestTest.User.NewUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class NewAddresseRequest {

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
    private Long idUser;

    public  NewAddresse toModel(NewUserRepository repository) {
        Optional<NewUser> user = repository.findById(idUser);
        return new NewAddresse(this.street, this.number, this.complement, this.district, this.city, this.state, this.cep, user.get());
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

    public Long getIdUser() {
        return idUser;
    }
}
