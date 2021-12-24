package com.movietheater.controller.Ticket;

import com.movietheater.common.MessageResponse;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.MovieInforResponse;
import com.movietheater.dto.Ticket.Model.SeatInforModel;
import com.movietheater.service.Ticket.BookingTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Ticket")
public class BookingTicketController {
    private final BookingTicketService bookingTicketService;

    public BookingTicketController(BookingTicketService bookingTicketService) {
        this.bookingTicketService = bookingTicketService;
    }

    // Nhan danh sach phim va thoi gian
    @GetMapping("/getInfor/time")
    public List<MovieInforResponse> getInfor()
    {
        return bookingTicketService.getInforTimeToBook();
    }
    // Nhan danh sach ghe
    @GetMapping("/getInfor/seat")
    public List<SeatInforModel> getSeatInfor(@RequestBody MovieInforResponse movieInforResponse)
    {
        return bookingTicketService.getInforSeatToBook(movieInforResponse);
    }
    // Xac nhan va luu thong tin hoa don
    @PostMapping("/addInvoice")
    public ResponseEntity<MessageResponse> addInvoice(@RequestBody ConfirmBookingRequest confirmBookingRequest)
    {
        return new ResponseEntity<>(bookingTicketService.confirmBooking(confirmBookingRequest), HttpStatus.CREATED);
    }



}
