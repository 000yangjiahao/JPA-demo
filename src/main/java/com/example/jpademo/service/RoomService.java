package com.example.jpademo.service;

import com.example.jpademo.dto.RoomDto;
import com.example.jpademo.entity.RoomEntity;

public interface RoomService {

    RoomDto getRoomById(Long id);

    void creatRoom(RoomEntity roomEntity);

    void updateRoom(RoomEntity roomEntity);

    void deleteRoom(Long id);
}
