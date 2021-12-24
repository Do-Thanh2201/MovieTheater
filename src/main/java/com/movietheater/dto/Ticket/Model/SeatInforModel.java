package com.movietheater.dto.Ticket.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
public class SeatInforModel {
    private int seatId;
    private  String seatColumn;
    private  int seatRow;
    private int seatStatus;

    private int seatQuantity;
    private int price;
}
