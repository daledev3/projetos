package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
