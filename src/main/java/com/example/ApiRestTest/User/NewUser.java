package com.example.ApiRestTest.User;

import com.example.ApiRestTest.addresses.NewAddresse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//        O primeiro passo deve ser a
//        construção de um cadastro de usuários, sendo obrigatório
//        dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e
//        CPF devem ser únicos.

@Entity
public class NewUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @Column(name = "email", unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "cpf", unique = true)
    @CPF
    @NotBlank
    private String cpf;

    @NotNull
    @Past
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dateBirth;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<NewAddresse> adresses = new ArrayList<>();

    public NewUser() {

    }

    public NewUser(String name, String email, String cpf, Date dateBirth) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.dateBirth = dateBirth;
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

    public List<NewAddresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<NewAddresse> adresses) {
        this.adresses = adresses;
    }
}
