package com.example.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private  Long id ;

    private RoomDto room;

    private UserDto organizer;

    private List<UserDto> participants;

    private Integer startTime;

    private Integer endTime;

}
