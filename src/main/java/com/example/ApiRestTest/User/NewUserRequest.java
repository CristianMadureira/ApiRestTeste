package com.example.ApiRestTest.User;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class NewUserRequest {

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


    public NewUser toModel() {
        return new NewUser(this.name, this.email, this.cpf, this.dateBirth);
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
}
