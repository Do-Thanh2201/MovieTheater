package com.movietheater.repository.Ticket;

import com.movietheater.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    public List<Seat> findSeatByCinemaRoom_CinemaRoomId(int roomid);
}
