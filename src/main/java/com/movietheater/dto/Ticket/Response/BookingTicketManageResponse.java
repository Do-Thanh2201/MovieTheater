package com.movietheater.dto.Ticket.Response;

import com.movietheater.dto.Ticket.Model.InvoiceModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class BookingTicketManageResponse {
    private String invoiceId;
    private String memberId;
    private String fullName;
    private String identityCard;
    private String phone;
    private String movieNameVN;
    private Date bookingDate;
    private String seatColumn;
    private  int seatRow;

    private List<InvoiceModel> invoiceModels;
    public BookingTicketManageResponse
            (String invoiceId, String memberId,
             String fullName, String identityCard,
             String phone, String movieNameVN,
             Date bookingDate, String seatColumn, int seatRow) {
        this.invoiceId = invoiceId;
        this.memberId = memberId;
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.phone = phone;
        this.movieNameVN = movieNameVN;
        this.bookingDate = bookingDate;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
    }

    public BookingTicketManageResponse
            (String memberId, String fullName,
             String identityCard, String phone,List<InvoiceModel> invoiceModels) {
        this.memberId = memberId;
        this.fullName = fullName;
        this.identityCard = identityCard;
        this.phone = phone;
        this.invoiceModels=invoiceModels;

    }
}
