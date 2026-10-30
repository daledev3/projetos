package com.example.hexagonal.adapters.in.controllers;

import com.example.hexagonal.adapters.in.controllers.mapper.CustomerMapper;
import com.example.hexagonal.adapters.in.controllers.request.CustomerRequest;
import com.example.hexagonal.adapters.in.controllers.response.CustomerResponse;
import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.DeleteByIdInputPort;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    DeleteByIdInputPort deleteByIdInputPort;

    @Autowired
    CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert (@RequestBody CustomerRequest customerRequest) {
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> find(@PathVariable String id) {
        var customer = findCustomerByIdInputPort.find(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

      @PutMapping("/{id}")
      public ResponseEntity<Void> update(@PathVariable String id , @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        deleteByIdInputPort.delete(id);
        return ResponseEntity.noContent().build();
    }
}
