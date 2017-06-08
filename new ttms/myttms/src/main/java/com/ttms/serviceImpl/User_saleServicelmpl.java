package com.ttms.serviceImpl;

import com.ttms.dao.SaleDAO;
import com.ttms.entity.User_sale;
import com.ttms.service.SaleService;
import com.ttms.service.User_saleService;

import java.util.ArrayList;
import java.util.List;
import com.ttms.entity.*;
import com.ttms.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hacker on 17-6-8.
 */
@Service("User_saleServiceImpl")
public class User_saleServicelmpl  implements User_saleService{
    @Autowired
    SaleDAO  saleDAO;
    @Autowired
    SaleitemDAO saleitemDAO;
    @Autowired
    StudioDAO   studioDAO;
    @Autowired
    TicketDAO  ticketDAO;
    @Autowired
    PlayDAO    playDAO;
    @Autowired
    ScheduleDAO scheduleDAO;


    @Override
    public List<User_sale> selectUser_sale(User_sale user_sale) {

           List<Sale> sale = saleDAO.selectSaleByUser_id(user_sale);   // 根据用户ID 查询 所有订单
 //       System.out.println("saled::::::"+sale.size());
           List<User_sale> user_sales = new ArrayList<User_sale>();      //返回值
           int count = sale.size();                                      //用户订单数

           for(int i = 0 ;i < count ;i++){

               Sale_item sale_item;                                        //查询所有相关内容
               Studio  studio = new Studio();
               Play    play = new Play();
               Ticket  ticket = new Ticket();
               Schedule sche = new Schedule();
               Seat    seat = new Seat();

                 sale_item = saleDAO.Searchbysaleid(sale.get(i));



   //             System.out.println("sss"+sale_item.getTicket_id());
                 ticket    = saleitemDAO.Searchbysaleitemid(sale_item);
               System.out.println("ticket_id:"+ticket.getTicket_id());
                 sche      = ticketDAO.searchbyidforsche(ticket);
               seat      = ticketDAO.serchforseat(ticket);
               studio    = scheduleDAO.searchbyscid(sche);
               play      = scheduleDAO.searchforplay(sche);




               User_sale temp_sale = new User_sale();
               //给临时变量赋值
               temp_sale.setUser_id(sale.get(i).getEmp_id());
     //          System.out.println(play.getPlay_name()+"FFDFDFD"+sale.get(i).getSale_ID()+"FDFDFDFD"+seat.getSeat_column());

               temp_sale.setPlay_name(play.getPlay_name());
               temp_sale.setSale_id(sale.get(i).getSale_ID());
               temp_sale.setCol(seat.getSeat_column());
               temp_sale.setRow(seat.getSeat_row());
               temp_sale.setSced_time(sche.getSched_time());
               temp_sale.setStudio_name(studio.getStudio_name());
               temp_sale.setPrices(sche.getSched_ticket_price());
               user_sales.add(temp_sale);
               //添加进返回数据集合
      //         System.out.println("查询的saleid" + "seatid:" + seat.getSeat_column()+"   "+seat.getSeat_row());

           }
           return user_sales;

    }
}
