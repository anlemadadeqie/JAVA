package com.ttms.serviceImpl;

import com.ttms.dao.*;
import com.ttms.entity.Schedule;
import com.ttms.entity.Seat;
import com.ttms.entity.Ticket;
import com.ttms.service.SeatService;
import com.ttms.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hacker on 17-6-1.
 */
@Service("TicketServiceImpl")
public class TicketServiceImpl implements TicketService {

    @Autowired
    TicketDAO ticketDAO;
    @Autowired
    SeatDAO seatDAO;
    @Autowired
    SeatService seatService;

    @Override
    public void insertTicket(Ticket ticket) {
        ticketDAO.insertTicket(ticket);
    }

    @Override
    public Ticket SearchTicket(Ticket ticket) {
        return ticketDAO.SearchTicket(ticket);
    }

    @Override
    public Ticket SearchTicket2(Ticket ticket) {
        return ticketDAO.SearchTicket2(ticket);
    }

    @Override
    public int SearchTicketStatus(Ticket ticket) {
        return ticketDAO.SearchTicketStatus(ticket);
    }

    @Override
    public int lockTicket(Ticket ticket) {

        int status = ticketDAO.SearchTicketStatus(ticket);
        if(status == 0){
            ticket.setTicket_status(1);
            Seat seat = new Seat();
            seat.setSeat_id(ticket.getSeat_id());
            seat = seatService.selectSeatBySeat_id(seat);
            seat.setSeat_status(1);
            System.out.println("dsdssdsdsd");
            seatDAO.updateSeat(seat);
            //System.out.println(ticket.getTicket_id());
            ticketDAO.updateTicketStatus(ticket);
        }else{
            return 0;   /*-1 预订失败*/
        }
        return 1;
    }

    @Override
    public int unlockTicket(Ticket ticket) {
        ticket.setTicket_status(0);
        Seat seat = new Seat();
        seat.setSeat_id(ticket.getSeat_id());
        System.out.println(seat.getSeat_id());
        Seat seat2 = seatDAO.selectSeatBySeat_id(seat);
        System.out.println("clo"+seat2.getSeat_column()+"row "+seat2.getSeat_row());
        seat2.setSeat_status(0);
        seatDAO.updateSeat(seat2);
        ticketDAO.updateTicketStatus(ticket);
        return 0;
    }

    @Override
    public void updateTicketStatus(Ticket ticket) {
        ticketDAO.updateTicketStatus(ticket);
    }

    @Override
    public Schedule searchbyidforsche(Ticket ticket) {
        return ticketDAO.searchbyidforsche(ticket);
    }

    @Override
    public Seat serchforseat(Ticket ticket) {
        return ticketDAO.serchforseat(ticket);
    }


}
