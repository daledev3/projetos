package com.example.hexagonal.adapters.out;

import com.example.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutputPort {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void send(String cpf) {
    kafkaTemplate.send("tp-cpf-valiation", cpf);
    }
}
