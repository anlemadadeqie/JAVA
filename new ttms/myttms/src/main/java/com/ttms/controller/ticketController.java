package com.ttms.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.ttms.entity.*;
import com.ttms.service.*;
import com.ttms.serviceImpl.SaleItemServiceImpl;
import org.codehaus.jackson.map.util.JSONPObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by hacker on 17-5-31.
 */


@Controller("TicketController")
@RequestMapping("/ticket")
public class ticketController {


    @Autowired
    SeatService seatService;
    @Autowired
    StudioService studioService;
    @Autowired
    PlayService playService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    TicketService ticketService;
    @Autowired
    SaleService saleService;
    @Autowired
    SaleItemService saleItemService;
    @Autowired
    User_saleService user_saleService;

    @RequestMapping("/Seat")
    public ModelAndView seatShowPage(HttpServletRequest request) {

//            Sale sale = new Sale();
//            sale.setEmp_id(12);
//            sale.setSale_time("2016-1-1");
//            saleService.insertSale(sale);
//
//             Ticket ticket = new Ticket();
//
//             ticket.setSched_id(1);
//             ticket.setSeat_id(11);
//             ticket.setTicket_price(111);
//             ticket.setTicket_locked_time("2016-10-10");
//             ticket.setTicket_status(1);
//
//             ticketService.insertTicket(ticket);
//
        List<Studio> list = studioService.selectStudio();
        List<Play> playList = playService.selectPlay();
        List<Schedule> scheduleList = scheduleService.selectSchedule();

        request.setAttribute("list", list);
        request.setAttribute("play", playList);
        request.setAttribute("schedule", scheduleList);
        return new ModelAndView("/manager/ticket/Seat");

    }

    @RequestMapping("/lockTicket")
    public ModelAndView lockTicket(HttpServletRequest request) {


        String data = request.getParameter("data");
        JSONObject object = new JSONObject(data);
        System.out.println(object);
        int row = object.getInt("row");
        System.out.println("aaa"+row);
        int col = object.getInt("col");
        System.out.println("ahshshdh"+col);
        int studio_id = object.getInt("studio");
        System.out.println(studio_id+"studio_id");
        int sched_id = object.getInt("sched");
        System.out.println(sched_id+"sched_id");
        int action = object.getInt("flag");
        System.out.println(action+"action");
        Studio name = studioService.selectStudioByStudio_id(studio_id);
        Seat seat = seatService.selectSeatByPosition2(name.getStudio_name(),row,col);
        Schedule schedule = scheduleService.selectScheduleBySched_id(sched_id);
        System.out.println("flas " + action);
        int ticket_id;
        Ticket ticket = new Ticket();
        ticket.setSched_id(sched_id);
        ticket.setSeat_id(seat.getSeat_id());
        System.out.println("seat_id"+seat.getSeat_id()+"schedule_id"+sched_id);
        ticket = ticketService.SearchTicket2(ticket);

        if (ticket == null) {

            System.out.println("start");
            int flag;
            Ticket ticket1 = new Ticket();
            ticket1.setSched_id(sched_id);
            ticket1.setSeat_id(seat.getSeat_id());
            ticket1.setTicket_status(0);
            ticket1.setTicket_price(schedule.getSched_ticket_price());
            ticketService.insertTicket(ticket1);
            System.out.println("b"+ticket1);
            flag = ticketService.lockTicket(ticket1);
            request.setAttribute("flag",flag);

        } else {
            int status;

            if (action == 0) {
                System.out.print("AAAidAAA" + ticket.getSeat_id());
                ticketService.unlockTicket(ticket);
                return new ModelAndView("");
                //  return -2;
            }
            if (ticket.getTicket_status()==0) {
                int flags;
                flags = ticketService.lockTicket(ticket);
                request.setAttribute("flag",flags);
            } else {
                // return
            }
        }

        return new ModelAndView("");

    }

    @RequestMapping("/Saleitem")
    public ModelAndView Salewithsomething(HttpServletRequest request) {

        HashMap<String,Integer> map = new HashMap<String, Integer>();
        String datas = request.getParameter("data");
        JSONObject object = new JSONObject(datas);
        String data = object.getString("orders");
        System.out.println(data);
        int studio_id = object.getInt("studio");
        int sched_id = object.getInt("sched");
        String[] positoion = data.split("\\|");
        for(int i=0; i<positoion.length; i++) {

            if (map.containsKey(positoion[i])) {

                int j = map.get(positoion[i]);
                j++;
                map.put(positoion[i], j);

            }else{

                map.put(positoion[i], 1);
            }
        }


        for(Map.Entry<String, Integer>  entry : map.entrySet()) {

            if (entry.getValue() % 2 == 0) {

                continue;

            } else {

                String letter1 = entry.getKey();
                String[] letter = letter1.split(",");
                int row = Integer.parseInt(letter[0]);
                int col = Integer.parseInt(letter[1]);
                System.out.println("rowaaaaaa"+row);
                System.out.println("colaaaaa"+col);
                Studio name = studioService.selectStudioByStudio_id(studio_id);
                Seat seat = seatService.selectSeatByPosition2(name.getStudio_name(), row, col);

                int ticket_id;

                Sale_item saleItem = new Sale_item();
                Ticket ticket = new Ticket();
                Sale_item sale_item = new Sale_item();
                ticket.setSeat_id(seat.getSeat_id());
                ticket.setSched_id(sched_id);
                ticket = ticketService.SearchTicket(ticket);
                System.out.println("sale");

                sale_item = saleItemService.SearchSaleItem(ticket);
                if (sale_item == null) {          //  false

                    Sale sale = new Sale();

                    sale.setEmp_id((Integer)(request.getSession().getAttribute("names")));
                    sale.setSale_payment(ticket.getTicket_price());
                    sale.setSale_status(1);


                    saleService.insertSale(sale);

                    Sale_item sale_item1 = new Sale_item();
                    sale_item1.setSale_ID(sale.getSale_ID());
                    sale_item1.setTicket_id(ticket.getTicket_id());

                    saleItemService.insertSaleItem(sale_item1);


                } else {

                    Sale sale = new Sale();
                    Ticket ticketn = new Ticket();



                    sale = saleItemService.selectSale_IDBySale_item_id(sale_item);

                    sale.setEmp_id((Integer)request.getSession().getAttribute("names"));
                    sale.setSale_status(1);

                    ticketn    = saleItemService.Searchbysaleitemid(sale_item);

                    ticketn.setTicket_status(1);

                    //                saleService.updateUser(sale);
                    System.out.println("sale_id"+sale.getEmp_id()+":  "+sale.getSale_status());
                    saleService.updateStatus(sale);
                    ticketService.updateTicketStatus(ticketn);
                }


            }
        }
            return new ModelAndView("");


    }

    @RequestMapping("/backticket")
    public ModelAndView backticket(HttpServletRequest request) {

        Sale sale = new Sale();
        Ticket ticket = new Ticket();
        Seat seat;
        Sale_item sale_item  = new Sale_item();



        sale.setSale_ID((Integer.parseInt(request.getParameter("sale"))));
        sale.setSale_status(0);
        sale.setEmp_id(0);

        sale_item = saleService.Searchbysaleid(sale);

        ticket    = saleItemService.Searchbysaleitemid(sale_item);

        ticket.setTicket_status(0);

        saleService.updateStatus(sale);

        ticketService.updateTicketStatus(ticket);
        seat      = ticketService.serchforseat(ticket);
        seat.setSeat_status(0);
        seatService.updateSeatStatus(seat);


        List<User_sale>  user_sales;
        User_sale user_sale  = new User_sale();
        user_sale.setUser_id((Integer) request.getSession().getAttribute("names"));
        user_sales = user_saleService.selectUser_sale(user_sale);

        request.setAttribute("ticketdetail", user_sales);
     return new ModelAndView("/ordinary/order");
   //     return new ModelAndView("");
    }

    @RequestMapping("/searchbySale")
    public ModelAndView searchbySale(HttpServletRequest request) {

        System.out.println("dijici");
        List<User_sale>  user_sales;
        User_sale user_sale  = new User_sale();
        user_sale.setUser_id((Integer) request.getSession().getAttribute("names"));
        user_sales = user_saleService.selectUser_sale(user_sale);

        for (User_sale u :user_sales
             ) {
            System.out.println(u.getCol()+"    "+u.getRow());
        }


        request.setAttribute("ticketdetail", user_sales);
        return new ModelAndView("/ordinary/order");

    }



//       public ModelAndView generateSale(HttpServletRequest request ){
//
//            int sale_id;
//            int sale_item_id;
//            int ticket_id;
//            int seat_id = 1;
//            int sched_id = 2;
//            Ticket ticket = new Ticket();
//            ticket.setSched_id(sched_id);
//            ticket.setSeat_id(seat_id)  ;
//            ticket_id = ticketService.SearchTicket(ticket);
//            ticket.setTicket_id(ticket_id);
//            sale_id = saleService.SearchSale(ticket);
//            sale_item_id = saleItemService.SearchSaleItem(ticket);
//
//            Sale sale = new Sale();
//            sale.setSale_status(1);
//            if(sale_id == 0){
//
//                saleService.insertSale(sale);
//            }else{
//                saleService.updateSale(sale);
//            }
//s
//            if(sale_item_id == 0) {
//                Sale_item saleitem = new Sale_item();
//                saleitem.setSale_ID(sale.getSale_ID());
//                saleitem.setTicket_id(ticket_id);
//                saleItemService.insertSaleItem(saleitem);
//            }
//
//       }


//        @RequestMapping("/seatsshow")
//        public ModelAndView seatsShowPage(HttpServletRequest request){
//
//            String studio_id = request.getParameter("studioid");
//            int id = Integer.parseInt(studio_id);
//            Studio studio = studioService.selectStudioByStudio_id(id);
//            List<Studio> list = studioService.selectSpecialStudio(id);
//            int[][] seat_statu = seatService.selectSeatByStudio_id(id);
//
//            request.setAttribute("list", list);
//            request.setAttribute("studio", studio);
//            request.setAttribute("seat_statu", seat_statu);
//
//            return new ModelAndView("/manager/task/Seats");
//        }
//
//
//        @RequestMapping("/changeseat")
//        public ModelAndView changeSeatPage(HttpServletRequest request){
//
//            String studio_name = request.getParameter("studioname");
//            String row = request.getParameter("studiorow");
//            int seat_row = Integer.parseInt(row);
//            String col = request.getParameter("studiocol");
//            int seat_column = Integer.parseInt(col);
//            String status = request.getParameter("studiostatu");
//            int seat_status = Integer.parseInt(status);
//
//            String errors = seatService.changeSeat(studio_name, seat_row, seat_column, seat_status);
//            List<Studio> list = studioService.selectStudio();
//            request.setAttribute("list", list);
//            request.setAttribute("errors", errors);
//
//            return new ModelAndView("/manager/task/ChangeSeat");
//        }
//
////    @RequestMapping("/addseat")
////    public ModelAndView addSeatPage(HttpServletRequest request){
////
////        String studio_name = request.getParameter("studioname");
////        String row = request.getParameter("studiorow");
////        int seat_row = Integer.parseInt(row);
////        String col = request.getParameter("studiocol");
////        int seat_column = Integer.parseInt(col);
////        String status = request.getParameter("studiostatu");
////        int seat_status = Integer.parseInt(status);
////
////        String errors = seatService.addSeat(studio_name, seat_row, seat_column, seat_status);
////        List<Studio> list = studioService.selectStudio();
////        request.setAttribute("list", list);
////        request.setAttribute("errors", errors);
////
////        return  new ModelAndView("/manager/task/AddSeat");
////
////    }
//
////    @RequestMapping("/toaddseat")
////    public ModelAndView toAddSeatPage(HttpServletRequest request){
////
////        List<Studio> list = studioService.selectStudio();
////        request.setAttribute("list", list);
////        return new ModelAndView("/manager/task/AddSeat");
////    }
//
//        @RequestMapping("/tochangeseat")
//        public ModelAndView toChangeSeatPage(HttpServletRequest request){
//
//            List<Studio> list = studioService.selectStudio();
//            request.setAttribute("list", list);
//            return new ModelAndView("/manager/task/ChangeSeat");
//        }
//
//        @RequestMapping("/todelseat")
//        public ModelAndView toDelSeatPage(HttpServletRequest request){
//
//            List<Studio> list = studioService.selectStudio();
//            request.setAttribute("list", list);
//            return new ModelAndView("/manager/task/DeleteSeat");
//        }
//
//
//        @RequestMapping("/delseat")
//        public ModelAndView deleteSeatPage(HttpServletRequest request){
//
//            String studio_name = request.getParameter("studioname");
//            String row = request.getParameter("studiorow");
//            int seat_row = Integer.parseInt(row);
//            String col = request.getParameter("studiocol");
//            int seat_column = Integer.parseInt(col);
//            String errors = seatService.selectSeatByPosition(studio_name, seat_row, seat_column);
//            List<Studio> list = studioService.selectStudio();
//            request.setAttribute("list", list);
//            request.setAttribute("errors", errors);
//
//            return new ModelAndView("/manager/task/DeleteSeat");
    //       }
}
