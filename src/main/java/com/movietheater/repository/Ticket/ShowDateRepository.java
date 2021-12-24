package com.movietheater.repository.Ticket;

import com.movietheater.entity.ShowDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowDateRepository extends JpaRepository<ShowDate, Integer> {
}
