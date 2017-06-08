package com.ttms.service;

import com.ttms.entity.Play;
import com.ttms.entity.Schedule;
import com.ttms.entity.Seat;
import com.ttms.entity.Ticket;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hacker on 17-6-1.
 */
public interface TicketService {
    public void insertTicket(Ticket ticket);

    public Ticket SearchTicket(Ticket ticket);

    public Ticket SearchTicket2(Ticket ticket);
    public int SearchTicketStatus(Ticket ticket);
    public int lockTicket(Ticket ticket);
    public int unlockTicket(Ticket ticket);
    //public void deletePlay(int play_id);
//    public void updatePlay(Play play);
//
//    public Play selectPlayByPlay_id(int play_id);
//    public List<Play> selectPlay();
//    public String addPlay(HttpServletRequest request);
//    public String updatePlay(HttpServletRequest request);
    public void   updateTicketStatus(Ticket ticket);
    public Schedule searchbyidforsche(Ticket ticket);
    public Seat serchforseat(Ticket ticket);
}
