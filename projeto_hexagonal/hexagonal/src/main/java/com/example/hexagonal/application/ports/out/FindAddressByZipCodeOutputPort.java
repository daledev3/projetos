package com.example.hexagonal.application.ports.out;

import com.example.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {

    Address find(String zipCode);
}
