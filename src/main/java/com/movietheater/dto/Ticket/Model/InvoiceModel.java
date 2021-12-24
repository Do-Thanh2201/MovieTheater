package com.movietheater.dto.Ticket.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
public class InvoiceModel {
    private String invoiceId;
    private Date bookingDate;
    private String seatColumn;
    private int seatRow;
    private String movieNameVN;

    public InvoiceModel(String invoiceId, Date bookingDate, String seatColumn,
                        int seatRow, String movieNameVN) {
        this.invoiceId = invoiceId;
        this.bookingDate = bookingDate;
        this.seatColumn = seatColumn;
        this.seatRow = seatRow;
        this.movieNameVN = movieNameVN;
    }
}
