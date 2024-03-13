package com.example.jpademo.service;

import com.example.jpademo.dto.UserDto;
import com.example.jpademo.entity.UserEntity;


public interface UserService {
    UserDto getUserById(Long id);

    UserEntity createUser(UserEntity user);

    UserEntity updateUser(Long id, UserEntity userDetails);

    void deleteUser(Long id);
}
