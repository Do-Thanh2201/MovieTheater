package com.movietheater.repository.Ticket;

import com.movietheater.entity.CinemaRoom;
import com.movietheater.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CinemaRoomRepository extends JpaRepository<CinemaRoom, Integer> {

    public CinemaRoom findCinemaRoomByMovies(Movie movie);

}
