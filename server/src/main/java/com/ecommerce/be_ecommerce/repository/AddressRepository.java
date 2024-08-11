package com.ecommerce.be_ecommerce.repository;

import com.ecommerce.be_ecommerce.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
