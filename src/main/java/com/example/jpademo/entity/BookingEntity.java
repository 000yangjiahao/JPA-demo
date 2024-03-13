package com.example.jpademo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "bookings")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private  Long roomId;

    @Column
    private  Long organizerId;

    @Column
    private String participants;

    @Column
    private Integer startTime;

    @Column
    private  Integer endTime;

}
