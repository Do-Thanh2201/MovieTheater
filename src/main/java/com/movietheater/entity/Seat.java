package com.movietheater.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int seatId;
    private  String seatColumn;
    private  int seatRow;
    private int seatStatus;
    private int seatType;

    @ManyToOne
    @JoinColumn(name = "cinemaRoom_id")
    @JsonIgnoreProperties("seats")
    private CinemaRoom cinemaRoom;

    @OneToMany(mappedBy = "seat")
    private Set<ScheduleSeat> scheduleSeats =new HashSet<>();


}
