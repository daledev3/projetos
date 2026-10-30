package com.example.hexagonal.adapters.in.controllers.response;

import lombok.Data;

@Data
public class CustomerResponse {

    private String name;

    private AddressResponse address;

    private String cpf;

    private boolean isValidCpf;
}
