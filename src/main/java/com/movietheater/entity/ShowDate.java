package com.movietheater.entity;


import lombok.Data;

import javax.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class ShowDate {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int showDateId;
    private LocalDate showDate;
//    private String dateName;


//    @ManyToMany(mappedBy = "showDates", fetch = FetchType.EAGER
//    , cascade = CascadeType.ALL)
//    private Set<Movie> movies = new HashSet<>();

}
