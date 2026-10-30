package com.example.hexagonal.application.ports.in;

import com.example.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipcode);
}
