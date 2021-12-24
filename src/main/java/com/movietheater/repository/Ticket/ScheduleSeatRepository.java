package com.movietheater.repository.Ticket;

import com.movietheater.entity.ScheduleSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleSeatRepository extends JpaRepository<ScheduleSeat, String> {
}
