package com.movietheater.controller.Ticket;

import com.movietheater.common.MessageResponse;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.BookingTicketManageResponse;
import com.movietheater.service.Ticket.TicketSellingManageService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manage/ticketselling")
public class TicketSellingManageController {
    private final TicketSellingManageService ticketSellingManageService;

    public TicketSellingManageController(TicketSellingManageService ticketSellingManageService) {
        this.ticketSellingManageService = ticketSellingManageService;
    }

    // Search by InvoiceID
    @GetMapping("/search/invoiceid/{invoiceId}")
    public List<BookingTicketManageResponse> getByInvoiceId(@PathVariable("invoiceId") String id)
    {
        return ticketSellingManageService.getInforByInvoiceId(id);
    }

    // Search by AccountId
    @GetMapping("/search/accountid/{accountId}")
    public List<BookingTicketManageResponse> getByAccountId(@PathVariable("accountId") String id)
    {
        return ticketSellingManageService.getInforByAccountId(id);
    }

    // Xac nhan va luu thong tin hoa don
    @PostMapping("/addInvoice")
    public ResponseEntity<MessageResponse> addInvoice(@RequestBody ConfirmBookingRequest confirmBookingRequest)
    {
        return new ResponseEntity<>(ticketSellingManageService.confirmBooking(confirmBookingRequest), HttpStatus.CREATED);
    }
    //
}
