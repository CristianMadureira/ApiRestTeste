package com.example.ApiRestTest.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewUserRepository extends JpaRepository<NewUser, Long> {
}
