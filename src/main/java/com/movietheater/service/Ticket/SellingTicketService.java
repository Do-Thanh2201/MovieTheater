package com.movietheater.service.Ticket;

import com.movietheater.common.MessageResponse;
import com.movietheater.common.TicketDao.BookingTicketDao;
import com.movietheater.common.TicketMap.TicketMap;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.MemberResponse;
import com.movietheater.dto.Ticket.Response.MovieInforResponse;
import com.movietheater.dto.Ticket.Model.SeatInforModel;
import com.movietheater.repository.Ticket.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellingTicketService {
    private final MovieRepository movieRepository;
    private final TicketMap ticketMap;
    private final SeatRepository seatRepository;

    private final BookingTicketDao bookingTicketDao;
    private final InvoiceRepository invoiceRepository;
    private final MemberRepository memberRepository;
    private final AccountRepository accountRepository;

    @Autowired

    public SellingTicketService
            (MovieRepository movieRepository, TicketMap ticketMap,
             SeatRepository seatRepository,
             BookingTicketDao bookingTicketDao, InvoiceRepository invoiceRepository,
             MemberRepository memberRepository, AccountRepository accountRepository) {
        this.movieRepository = movieRepository;
        this.ticketMap = ticketMap;
        this.seatRepository = seatRepository;
        this.bookingTicketDao = bookingTicketDao;
        this.invoiceRepository = invoiceRepository;
        this.accountRepository = accountRepository;
        this.memberRepository = memberRepository;
    }




    // Get Information time to Book ticket
    public List<MovieInforResponse> getInforTimeToBook()
    {
/*        List<MovieInforResponse> movieInforResponse = new ArrayList<>();

        movieInforResponse = movieRepository.findAll()
                .stream().map(bookingTicketMap::toMovieInfor)
                .collect(Collectors.toList());
        return movieInforResponse;*/

        return movieRepository.findAll()
                .stream().map(ticketMap::toMovieInfor)
                .collect(Collectors.toList());
    }

    // Get Information Seat to Book Ticket
    public List <SeatInforModel> getInforSeatToBook(MovieInforResponse movieInforResponse)
    {

        return seatRepository.findSeatByCinemaRoom_CinemaRoomId
                        (bookingTicketDao.getCinemaRoomId(movieInforResponse.getMovieId()))
                .stream().map(ticketMap::toSeatInfor)
                .collect(Collectors.toList());
    }

    //Kiem tra tai khoan khach hang
    public List<MemberResponse> checkMember(int id)
    {
        return memberRepository.findById(id)
                .stream()
                .map(ticketMap::toMemberResponse)
                .collect(Collectors.toList());
    }
    // Confirm Booking Ticket, Save invoice in database
    public MessageResponse confirmBooking(ConfirmBookingRequest confirmBookingRequest)
    {
        invoiceRepository.save(ticketMap.toInvoice(confirmBookingRequest));
        return new MessageResponse("Successful");
    }

}
