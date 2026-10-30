package com.example.hexagonal.application.core.useCase;

import com.example.hexagonal.application.core.domain.Customer;

import com.example.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.example.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    @Autowired
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    @Autowired
    private final InsertCustomerOutputPort insertCustomerOutputPort;

    @Autowired
    private SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort,
                                 SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    public void insert(Customer customer, String zipCode) {
        var endereco = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(endereco);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());


    }
}
