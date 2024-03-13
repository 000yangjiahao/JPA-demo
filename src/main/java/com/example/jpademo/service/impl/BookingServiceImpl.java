package com.example.jpademo.service.impl;

import com.example.jpademo.entity.BookingEntity;
import com.example.jpademo.repository.BookingRepository;
import com.example.jpademo.service.BookingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookingServiceImpl implements BookingService {

    @Resource
    BookingRepository bookingRepository;

    @Override
    public BookingEntity getBookingById(Long id) {
        return bookingRepository.findById(id).get();
    }

}
