package com.example.hexagonal.application.ports.in;

import com.example.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
