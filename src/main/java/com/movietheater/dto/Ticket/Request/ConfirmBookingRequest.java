package com.movietheater.dto.Ticket.Request;

import com.movietheater.dto.Ticket.Model.AccountModel;
import com.movietheater.dto.Ticket.Model.ScheduleModel;
import com.movietheater.dto.Ticket.Response.MemberResponse;
import com.movietheater.dto.Ticket.Model.SeatInforModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ConfirmBookingRequest {

    private Date bookingDate;
    private  int totalMoney;
    private String accountId;
    private SeatInforModel seatInforModel;
    private MemberResponse memberResponse;
    private ScheduleModel scheduleModel;
    public ConfirmBookingRequest
            (Date bookingDate, int totalMoney, String accountId, SeatInforModel seatInforModel,
             MemberResponse memberResponse, ScheduleModel scheduleModel) {
        this.bookingDate = bookingDate;
        this.totalMoney = totalMoney;
        this.accountId = accountId;
        this.seatInforModel = seatInforModel;
        this.memberResponse = memberResponse;
        this.scheduleModel = scheduleModel;
    }
}
