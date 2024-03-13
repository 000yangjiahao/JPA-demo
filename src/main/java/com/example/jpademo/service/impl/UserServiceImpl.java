package com.example.jpademo.service.impl;

import com.example.jpademo.dto.UserDto;
import com.example.jpademo.entity.UserEntity;
import com.example.jpademo.repository.UserRepository;
import com.example.jpademo.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserRepository userRepository;

    @Resource
    ModelMapper modelMapper;

    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity =userRepository.findById(id).get();
        UserDto userDto=modelMapper.map(userEntity,UserDto.class);
        return userDto;
    }


    @Override
    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity updateUser(Long id, UserEntity userDetails) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity user = optionalUser.get();
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
