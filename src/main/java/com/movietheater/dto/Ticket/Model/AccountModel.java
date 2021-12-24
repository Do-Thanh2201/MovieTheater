package com.movietheater.dto.Ticket.Model;


import java.util.Date;

import java.util.List;

public class AccountModel {

    private  String accountId;

    private String fullName;
    private  String identityCard;
    private  String phone;
    // Invoice.Class
    private List<String> invoiceIdList;
    private List<Date> bookingDateList;
    // Movie.Class
    private List<String> movieNameVNList;
}
