package com.example.jpademo.service.impl;

import com.example.jpademo.dto.RoomDto;
import com.example.jpademo.entity.RoomEntity;
import com.example.jpademo.repository.RoomRepository;
import com.example.jpademo.service.RoomService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;


@Service
public class RoomServiceImpl implements RoomService {

    @Resource
    RoomRepository roomRepository;
    @Resource
    ModelMapper modelMapper;

    @Override
    public RoomDto getRoomById(Long id) {
        RoomEntity roomEntity = roomRepository.findById(id).get();
        RoomDto roomDto = modelMapper.map(roomEntity, RoomDto.class);
        return  roomDto;
    }

    @Override
    public void creatRoom(RoomEntity roomEntity) {
        roomRepository.save(roomEntity);
    }

    @Override
    public void updateRoom(RoomEntity roomDetail) {
        Optional<RoomEntity> room = roomRepository.findById(roomDetail.getId());
        if (room.isPresent()){
            RoomEntity roomEntity = room.get();
            roomEntity.setName(roomDetail.getName());
            roomRepository.save(roomEntity);
        }
    }

    @Override
    public void deleteRoom(Long id) {
        Optional<RoomEntity> room = roomRepository.findById(id);
        if (room.isPresent()){
            roomRepository.deleteById(id);
        }
    }
}
