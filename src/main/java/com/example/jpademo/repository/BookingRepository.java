package com.example.jpademo.repository;

import com.example.jpademo.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity,Long> {
}
