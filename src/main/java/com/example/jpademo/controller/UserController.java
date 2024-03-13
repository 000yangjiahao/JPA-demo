package com.example.jpademo.controller;

import com.example.jpademo.dto.UserDto;
import com.example.jpademo.entity.UserEntity;
import com.example.jpademo.service.UserService;
import com.example.jpademo.service.impl.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Resource
    UserServiceImpl userServiceImpl;

    @Resource
    ModelMapper modelMapper;

    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
        UserEntity user = modelMapper.map(userDto, UserEntity.class);
        userServiceImpl.createUser(user);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userServiceImpl.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userServiceImpl.deleteUser(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable Long id, @RequestBody UserDto userDetails) {
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
        userServiceImpl.updateUser(id, userEntity);
    }

    @GetMapping("info/{roomId}")
    public ResponseEntity<Object> meetingRoomInfo(){
        Map<String,Object> response =new HashMap();
        return  ResponseEntity.ok(response);
    }
}
