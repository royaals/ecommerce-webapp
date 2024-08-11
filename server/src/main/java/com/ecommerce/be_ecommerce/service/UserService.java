package com.ecommerce.be_ecommerce.service;

import com.ecommerce.be_ecommerce.exception.UserException;
import com.ecommerce.be_ecommerce.model.User;

public interface UserService {
    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;
}
