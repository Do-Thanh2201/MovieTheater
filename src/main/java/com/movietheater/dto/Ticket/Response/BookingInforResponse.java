package com.movietheater.dto.Ticket.Response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BookingInforResponse {

    private Date bookingDate;
    private  int totalMoney;
    private int accountId;
    private String scheduleSeatId;

}
