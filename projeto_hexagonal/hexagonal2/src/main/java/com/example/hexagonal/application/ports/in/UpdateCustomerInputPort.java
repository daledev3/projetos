package com.example.hexagonal.application.ports.in;

import com.example.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update (Customer customer, String zipcode);
}
