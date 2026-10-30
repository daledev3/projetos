package com.example.hexagonal.config;

import com.example.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.example.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.example.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import com.example.hexagonal.application.core.useCase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter,
            FindCustomerByIdUseCase findCustomerByIdUseCase
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
