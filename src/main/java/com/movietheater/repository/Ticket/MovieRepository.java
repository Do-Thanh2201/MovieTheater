package com.movietheater.repository.Ticket;

import com.movietheater.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {

    public Movie findMovieByMovieId(String movieId);
/*    @Query("SELECT new com.movietheater.dto.Ticket.Response.MovieInforResponse" +
            "(m.movieNameVN, m.movieNamEnglish,sd.dateName, sd.showDate, sc.scheduleTime)" +
            "from Movie m join m.schedules sc join m.showDates sd")
    public List<MovieInforResponse> getMovieInformationTime();*/

/*    @Query("select new com.movietheater.dto.Ticket.BookingTicketDto" +
            "()" +
            "from Movie m join m.showDates sd")
    public List<BookingTicketDto> getMovieInformationDate();*/
}
