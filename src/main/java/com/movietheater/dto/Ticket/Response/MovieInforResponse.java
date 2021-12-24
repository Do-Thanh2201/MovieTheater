package com.movietheater.dto.Ticket.Response;


import com.movietheater.dto.Ticket.Model.ScheduleModel;
import com.movietheater.dto.Ticket.Model.ShowdateModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MovieInforResponse {
    private  String movieId;

    // (Movie.Class)
    private String movieNameVN;
    // (Movie.Class)
    private String movieNamEnglish;

    private List<ShowdateModel> showDates;
    private List<ScheduleModel> schedules;
/*
    // Thu (ShowDate.class)
    private String dateName;
    // Ngay (ShowDate.class)
    private Date showDate;

    // Gio (Schedule.Class)
    private String scheduleTime;
*/

/*    public MovieInforResponse(String dateName, Date showDate)
    {
        this.dateName = dateName;
        this.showDate = showDate;
    }*/

/*    public MovieInforResponse(String movieNameVN, String movieNamEnglish, String scheduleTime) {
        this.movieNameVN = movieNameVN;
        this.movieNamEnglish = movieNamEnglish;
        this.scheduleTime = scheduleTime;
    }

    public MovieInforResponse(String movieNameVN, String movieNamEnglish, String dateName, Date showDate, String scheduleTime) {
        this.movieNameVN = movieNameVN;
        this.movieNamEnglish = movieNamEnglish;
        this.dateName = dateName;
        this.showDate = showDate;
        this.scheduleTime = scheduleTime;
    }*/

}
