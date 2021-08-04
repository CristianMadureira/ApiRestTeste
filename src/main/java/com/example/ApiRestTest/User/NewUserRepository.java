package com.example.ApiRestTest.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewUserRepository extends JpaRepository<NewUser, Long> {

    public Optional<NewUser> findByCpf(String cpf);

    public Optional<NewUser> findByEmail(String email);
}
