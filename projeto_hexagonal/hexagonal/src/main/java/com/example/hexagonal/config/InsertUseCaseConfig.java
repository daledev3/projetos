package com.example.hexagonal.config;

import com.example.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.example.hexagonal.adapters.out.InsertCustomerAdapter;
import com.example.hexagonal.application.core.useCase.InsertCustomerUseCase;
import com.example.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertUseCaseConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase (
            InsertCustomerAdapter insertCustomerAdapter,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationOutputPort);
    }
}
