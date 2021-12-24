package com.movietheater.common.TicketMap;

import com.movietheater.dto.Ticket.Response.MemberResponse;
import com.movietheater.dto.Ticket.Model.ScheduleModel;
import com.movietheater.dto.Ticket.Model.SeatInforModel;
import com.movietheater.dto.Ticket.Model.ShowdateModel;
import com.movietheater.dto.Ticket.Request.ConfirmBookingRequest;
import com.movietheater.dto.Ticket.Response.MovieInforResponse;
import com.movietheater.entity.*;
import com.movietheater.repository.Ticket.AccountRepository;
import com.movietheater.repository.Ticket.InvoiceRepository;
import com.movietheater.repository.Ticket.ScheduleSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;

import java.util.stream.Collectors;

@Component
public class TicketMap {

    private final AccountRepository accountRepository;
    private final InvoiceRepository invoiceRepository;
    private final ScheduleSeatRepository scheduleSeatRepository;
    @Autowired

    public TicketMap(AccountRepository accountRepository,
                     InvoiceRepository invoiceRepository, ScheduleSeatRepository scheduleSeatRepository) {
        this.accountRepository = accountRepository;
        this.invoiceRepository = invoiceRepository;
        this.scheduleSeatRepository = scheduleSeatRepository;
    }




    public MovieInforResponse toMovieInfor(Movie movie)
    {

        List<ShowdateModel> showdateModelList = movie.getShowDates()
                .stream().map
                (showDate -> new ShowdateModel(showDate.getShowDate()))
                .collect(Collectors.toList());
        List<ScheduleModel> scheduleRespons = (List<ScheduleModel>) movie.getSchedules()
                .stream().map(schedule -> new ScheduleModel(schedule.getScheduleTime()))
                .collect(Collectors.toList());

        return new MovieInforResponse
                (movie.getMovieId(),
                        movie.getMovieNameVN(),
                        movie.getMovieNameEnglish(),
                        showdateModelList,
                        scheduleRespons);
    }
    public SeatInforModel toSeatInfor(Seat seat)
    {
        return new SeatInforModel
                (
                        seat.getSeatId(),
                        seat.getSeatColumn(),
                        seat.getSeatRow(),
                        seat.getSeatStatus(),
                        seat.getCinemaRoom().getSeatQuantity(),
                        seat.getCinemaRoom().getTicket().getPrice()
                );
    }
    public Invoice toInvoice(ConfirmBookingRequest confirmBookingRequest)
    {
        Invoice invoice = new Invoice();
        invoice.setBookingDate(confirmBookingRequest.getBookingDate());
        invoice.setTotalMoney(confirmBookingRequest.getTotalMoney());
        invoice.setStatus(1);
        // ?? Set Account???
        invoice.setAccount(saveAccount(confirmBookingRequest));
        // Set schedule
        invoice.setScheduleSeat(saveScheduleSeat(confirmBookingRequest));
        return invoice;
    }
    public Account saveAccount(ConfirmBookingRequest confirmBookingRequest)
    {
        Account account = accountRepository.findById(confirmBookingRequest.getAccountId())
                .orElseThrow(EntityNotFoundException::new);

        Account finalAccount = account;
        account.getInvoices().forEach(
                invoice1 -> {
                    invoice1.setAccount(finalAccount);
                    invoiceRepository.save(invoice1);
                }
        );
        return account;
    }
    public ScheduleSeat saveScheduleSeat(ConfirmBookingRequest confirmBookingRequest)
    {
        ScheduleSeat scheduleSeat = new ScheduleSeat();
        scheduleSeat.setSchedule(toSchedule(confirmBookingRequest.getScheduleModel()));
        return scheduleSeat;
    }
    public Schedule toSchedule(ScheduleModel scheduleModel)
    {
        Schedule schedule=new Schedule();
        schedule.setScheduleTime(scheduleModel.getScheduleTime());
        return schedule;
    }


   /* public void fixDup(Invoice invoice, ConfirmBookingRequest confirmBookingRequest){

        fixDup2(invoice, confirmBookingRequest);
    };

    public void fixDup2(Invoice invoice, ConfirmBookingRequest confirmBookingRequest) {

        Account account=accountRepository.save(invoice.getAccount());
        Account finalAccount = account;
        account.getInvoices().forEach(
                invoice1 -> {
                    invoice1.setAccount(finalAccount);
                    invoiceRepository.save(invoice1);
                }
        );
        ScheduleSeat scheduleSeat;
    }*/
    public MemberResponse toMemberResponse(Member member)
    {

        return new MemberResponse
                (member.getMemberId(),
                        member.getScore(),
                        member.getAccount().getIdentityCard(),
                        member.getAccount().getFullName(),
                        member.getAccount().getPhone());
    }

}
