package com.example.hexagonal.adapters.out;

import com.example.hexagonal.adapters.in.controllers.mapper.CustomerMapper;
import com.example.hexagonal.adapters.out.repository.CustomerRepository;
import com.example.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.example.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerEntityMapper customerEntityMapper;


    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }


}
