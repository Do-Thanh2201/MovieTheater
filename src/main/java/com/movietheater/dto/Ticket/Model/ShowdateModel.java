package com.movietheater.dto.Ticket.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ShowdateModel {
    private LocalDate showdate;
}
