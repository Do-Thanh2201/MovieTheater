package com.movietheater.dto.Ticket.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class MemberResponse {
    private  String memberId;
    private int Score;
    private  String identityCard;
    private String fullName;
    private  String phone;

}
