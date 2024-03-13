package com.example.jpademo.controller;

import com.example.jpademo.convert.BookingEnToBookingDto;
import com.example.jpademo.dto.BookingDto;
import com.example.jpademo.dto.RoomDto;
import com.example.jpademo.dto.UserDto;
import com.example.jpademo.entity.BookingEntity;
import com.example.jpademo.service.impl.BookingServiceImpl;
import com.example.jpademo.service.impl.RoomServiceImpl;
import com.example.jpademo.service.impl.UserServiceImpl;
import com.example.jpademo.tool.StringToArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    @Resource
    BookingEnToBookingDto bookingEnToBookingDto;
    @Resource
    BookingServiceImpl bookingServiceImpl;

    @GetMapping("/{id}")
    public BookingDto getBookingById(@PathVariable Long id){

        BookingEntity bookingById = bookingServiceImpl.getBookingById(id);
        return bookingEnToBookingDto.convert(bookingById);
    }
}
