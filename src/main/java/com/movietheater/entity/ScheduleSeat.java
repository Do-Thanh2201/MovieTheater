package com.movietheater.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ScheduleSeat {
    @Id
    private String scheduleSeatId;


    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    @OneToOne(mappedBy = "scheduleSeat")
    private Invoice invoice;

}
