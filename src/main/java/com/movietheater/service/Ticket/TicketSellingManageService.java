package com.movietheater.service.Ticket;


import com.movietheater.common.MessageResponse;
import com.movietheater.common.TicketMap.BookingTicketManageMap;

import com.movietheater.common.TicketMap.TicketMap;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.BookingTicketManageResponse;
import com.movietheater.repository.Ticket.AccountRepository;
import com.movietheater.repository.Ticket.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketSellingManageService {
    private final BookingTicketManageMap bookingTicketManageMap;
    private final TicketMap ticketMap;
    private final InvoiceRepository invoiceRepository;
    private final AccountRepository accountRepository;
    @Autowired

    public TicketSellingManageService
            (BookingTicketManageMap bookingTicketManageMap, InvoiceRepository invoiceRepository,
             AccountRepository accountRepository, TicketMap ticketMap) {

        this.bookingTicketManageMap = bookingTicketManageMap;
        this.invoiceRepository = invoiceRepository;
        this.accountRepository=accountRepository;
        this.ticketMap = ticketMap;
    }
    //Tim theo InvoiceId
    public List<BookingTicketManageResponse> getInforByInvoiceId(String invoiceId)
    {
        return invoiceRepository.findById(invoiceId)
                .stream().map
                        (bookingTicketManageMap::InvoiceTo)
                .collect(Collectors.toList());
    }
    // Tim theo AccountId
    public List<BookingTicketManageResponse> getInforByAccountId(String accountId)
    {


        return accountRepository.findById(accountId)
                .stream().map
                        (bookingTicketManageMap::AccountTo)
                .collect(Collectors.toList());
    }
    // Confirm Booking Ticket, Save invoice in database
    public MessageResponse confirmBooking(ConfirmBookingRequest confirmBookingRequest)
    {
        invoiceRepository.save(ticketMap.toInvoice(confirmBookingRequest));
        return new MessageResponse("Successful");
    }
    //

}
