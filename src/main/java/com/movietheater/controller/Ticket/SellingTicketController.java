package com.movietheater.controller.Ticket;

import com.movietheater.common.MessageResponse;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.MemberResponse;
import com.movietheater.dto.Ticket.Response.MovieInforResponse;
import com.movietheater.dto.Ticket.Model.SeatInforModel;
import com.movietheater.service.Ticket.SellingTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/selling")
public class SellingTicketController {
    private final SellingTicketService sellingTicketService;

    public SellingTicketController(SellingTicketService sellingTicketService) {
        this.sellingTicketService = sellingTicketService;
    }
    // Nhan danh sach phim va thoi gian
    @GetMapping("/getInfor/time")
    public List<MovieInforResponse> getInfor()
    {
        return sellingTicketService.getInforTimeToBook();
    }
    // Nhan danh sach cho ngoi
    @GetMapping("/getInfor/seat")
    public List<SeatInforModel> getSeatInfor(@RequestBody MovieInforResponse movieInforResponse)
    {
        return sellingTicketService.getInforSeatToBook(movieInforResponse);
    }
    // Kiem tra tai khoan khach hang
    @GetMapping("/checkmember/{id}")
    public List<MemberResponse> checkMember(@PathVariable("id") int id)
    {
        return sellingTicketService.checkMember(id);
    }
    // Xac nhan va luu thong tin hoa don
    @PostMapping("/addInvoice")
    public ResponseEntity<MessageResponse> addInvoice(@RequestBody ConfirmBookingRequest confirmBookingRequest)
    {
        return new ResponseEntity<>(sellingTicketService.confirmBooking(confirmBookingRequest), HttpStatus.CREATED);
    }
}
