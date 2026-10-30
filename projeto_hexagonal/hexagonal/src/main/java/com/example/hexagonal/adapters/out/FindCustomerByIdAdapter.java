package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.in.controllers.mapper.CustomerMapper;
import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.example.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }


}
