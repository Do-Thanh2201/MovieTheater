package com.movietheater.common.TicketMap;

import com.movietheater.dto.Ticket.Model.InvoiceModel;
import com.movietheater.dto.Ticket.Response.BookingTicketManageResponse;
import com.movietheater.entity.Account;
import com.movietheater.entity.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingTicketManageMap {

    public BookingTicketManageResponse InvoiceTo(Invoice invoice)
    {
        return new BookingTicketManageResponse(
                invoice.getInvoiceId(),
                invoice.getAccount().getMember().getMemberId(),
                invoice.getAccount().getFullName(),
                invoice.getAccount().getIdentityCard(),
                invoice.getAccount().getPhone(),
                invoice.getScheduleSeat().getMovie().getMovieNameVN(),
                invoice.getBookingDate(),
                invoice.getScheduleSeat().getSeat().getSeatColumn(),
                invoice.getScheduleSeat().getSeat().getSeatRow());
    }
    public BookingTicketManageResponse AccountTo(Account account)
    {
        List<InvoiceModel> invoiceModels=account.getInvoices()
                .stream().map(invoice->new InvoiceModel(
                        invoice.getInvoiceId(), invoice.getBookingDate(),
                        invoice.getScheduleSeat().getSeat().getSeatColumn(),
                        invoice.getScheduleSeat().getSeat().getSeatRow(),
                        invoice.getScheduleSeat().getMovie().getMovieNameVN()))
                .collect(Collectors.toList());
        return new BookingTicketManageResponse(
                account.getMember().getMemberId(),
                account.getFullName(),
                account.getIdentityCard(),
                account.getPhone(),
                invoiceModels
        );
    }
}





/* private  String invoiceId;
    private  String memberId;
    private String fullName;
    private  String identityCard;
    private  String phone;
    private String movieNameVN;
    private Date bookingDate;
    private  String seatColumn;
    private  int seatRow;*/