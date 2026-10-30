package com.example.hexagonal.application.core.useCase;

import com.example.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.example.hexagonal.application.ports.in.DeleteByIdInputPort;
import com.example.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.example.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerByIdUseCase implements DeleteByIdInputPort {

    @Autowired
    FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(DeleteCustomerByIdAdapter deleteCustomerByIdAdapter, FindCustomerByIdUseCase findCustomerByIdUseCase) {
    }

    public void delete(String id) {
    findCustomerByIdInputPort.find(id);
    deleteCustomerByIdOutputPort.delete(id);
    }
}
