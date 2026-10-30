package com.example.hexagonal.application.core.domain;

public class Customer {

    public Customer(String id, String name, Address address, String cpf, boolean validCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.validCpf = validCpf;
    }

    public Customer() {
        this.validCpf = false;
    }

    private String id;

    private String name;

    private Address address;

    private String cpf;

    private boolean validCpf;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public boolean isValidCpf() {
        return validCpf;
    }

    public void setValidCpf(boolean validCpf) {
        this.validCpf = validCpf;
    }
}
