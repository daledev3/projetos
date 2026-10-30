package com.example.hexagonal.application.core.useCase;

import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    @Autowired
    private FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer find(String id) {
    return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
