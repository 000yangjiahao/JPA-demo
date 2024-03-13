package com.example.jpademo.controller;

import com.example.jpademo.dto.RoomDto;
import com.example.jpademo.entity.RoomEntity;
import com.example.jpademo.service.impl.RoomServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Resource
    RoomServiceImpl roomServiceImpl;
    @Resource
    ModelMapper modelMapper;

    @PostMapping
    public void createRooms(@RequestBody RoomDto roomDto){
        RoomEntity roomEntity = modelMapper.map(roomDto, RoomEntity.class);
        roomServiceImpl.creatRoom(roomEntity);
    }

    @GetMapping("/{id}")
    public RoomDto getRoomById(@PathVariable Long id){
        RoomDto roomById = roomServiceImpl.getRoomById(id);
        return  roomById;
    }

    @PutMapping("/update")
    public  void  updateRoom (@RequestBody RoomDto roomDto){
        RoomEntity roomEntity = modelMapper.map(roomDto, RoomEntity.class);
        roomServiceImpl.updateRoom(roomEntity);
    }

    @DeleteMapping("/{id}")
    public  void   deleteRoom(@PathVariable Long id){
        roomServiceImpl.deleteRoom(id);
    }
}
