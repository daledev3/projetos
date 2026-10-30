package com.example.hexagonal.application.core.useCase;

import com.example.hexagonal.application.core.domain.Customer;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.example.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.example.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    @Autowired
    UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);


    }
}
