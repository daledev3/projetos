package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;


    public void delete(String id) {
        customerRepository.deleteById(id);

    }
}
