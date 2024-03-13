package com.example.jpademo.convert;

import com.example.jpademo.dto.BookingDto;
import com.example.jpademo.dto.RoomDto;
import com.example.jpademo.dto.UserDto;
import com.example.jpademo.entity.BookingEntity;
import com.example.jpademo.service.impl.BookingServiceImpl;
import com.example.jpademo.service.impl.RoomServiceImpl;
import com.example.jpademo.service.impl.UserServiceImpl;
import com.example.jpademo.tool.StringToArray;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class BookingEnToBookingDto {

    @Resource
    UserServiceImpl userServiceImpl;
    @Resource
    RoomServiceImpl roomServiceImpl;
    @Resource
    StringToArray stringToArray;

    public BookingDto convert(BookingEntity bookingEntity){
        UserDto organizer = userServiceImpl.getUserById(bookingEntity.getOrganizerId());

        List<Long> participantsList = stringToArray.convert(bookingEntity.getParticipants());
        List<UserDto> participants = new ArrayList<>();
        for (Long aLong : participantsList) {
            UserDto userById = userServiceImpl.getUserById(aLong);
            participants.add(userById);
        }

        RoomDto roomById = roomServiceImpl.getRoomById(bookingEntity.getRoomId());

        BookingDto bookingDto = new BookingDto(bookingEntity.getId(), roomById, organizer,
                participants, bookingEntity.getStartTime(),
                bookingEntity.getEndTime());
        return bookingDto;
    }
}
