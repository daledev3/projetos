package com.example.hexagonal.adapters.in.consumer;

import com.example.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.example.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.example.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "dale")
    public void receive (CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }
}
