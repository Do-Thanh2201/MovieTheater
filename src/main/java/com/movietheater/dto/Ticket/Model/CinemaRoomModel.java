package com.movietheater.dto.Ticket.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CinemaRoomModel {
    private int cinemaroomID;
    private int seat_quality;
    private int ticketId;
}
