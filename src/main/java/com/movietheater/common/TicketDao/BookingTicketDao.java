package com.movietheater.common.TicketDao;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Movie;
import com.movietheater.repository.Ticket.CinemaRoomRepository;
import com.movietheater.repository.Ticket.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookingTicketDao {
    private final CinemaRoomRepository cinemaRoomRepository;
    private final MovieRepository movieRepository;
    @Autowired
    public BookingTicketDao(CinemaRoomRepository cinemaRoomRepository, MovieRepository movieRepository) {
        this.cinemaRoomRepository = cinemaRoomRepository;
        this.movieRepository = movieRepository;
    }

    private int roomid;
    public int getCinemaRoomId(String movieid)
    {
        Movie movies = movieRepository.findMovieByMovieId(movieid);
        CinemaRoom cinemaRooms =cinemaRoomRepository.findCinemaRoomByMovies
                (movies);
        roomid = cinemaRooms.getCinemaRoomId();
        return this.roomid;
    }

}
