package com.ecommerce.be_ecommerce.repository;

import com.ecommerce.be_ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);


}
