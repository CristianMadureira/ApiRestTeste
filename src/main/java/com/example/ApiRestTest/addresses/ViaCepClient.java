package com.example.ApiRestTest.addresses;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viaCepClient")
public interface ViaCepClient {

    @GetMapping("{cep}/json")
    AddresseViaCep serchAddresseByCep(@PathVariable("cep") String cep) ;
}
