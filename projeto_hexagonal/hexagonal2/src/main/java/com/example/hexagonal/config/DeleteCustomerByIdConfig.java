package com.example.hexagonal.config;

import com.example.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.example.hexagonal.application.core.useCase.DeleteCustomerByIdUseCase;
import com.example.hexagonal.application.core.useCase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(deleteCustomerByIdAdapter, findCustomerByIdUseCase);
    }
}
