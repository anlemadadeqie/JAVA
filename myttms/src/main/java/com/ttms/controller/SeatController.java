package com.ttms.controller;

import com.ttms.entity.Seat;
import com.ttms.entity.Studio;
import com.ttms.service.SeatService;
import com.ttms.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 16-12-6.
 */
@Controller("SeatController")
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;
    @Autowired
    StudioService studioService;

    @RequestMapping("/seatshow")
    public ModelAndView seatShowPage(HttpServletRequest request){

        List<Studio> list = studioService.selectStudio();
        request.setAttribute("list", list);
        return new ModelAndView("/manager/task/Seat");

    }

    @RequestMapping("/seatsshow")
    public ModelAndView seatsShowPage(HttpServletRequest request){

        String studio_id = request.getParameter("studioid");
        int id = Integer.parseInt(studio_id);
        Studio studio = studioService.selectStudioByStudio_id(id);
        List<Studio> list = studioService.selectSpecialStudio(id);
        int[][] seat_statu = seatService.selectSeatByStudio_id(id);

//        int studio_row = studio.getStudio_row_count();
//        int studio_col = studio.getStudio_col_count();
//        int [][] seat_statu = new int[studio_row+1][studio_col+1];
//
//        for(int i = 0; i < studio_row; i++){
//            for(int j = 0; j < studio_col; j++){
//                seat_statu[i][j] = -2;
//            }
//        }
//
//        for(Seat seats : seat){
//
//            int i = seats.getSeat_row();
//            int j = seats.getSeat_column();
//            int k = seats.getSeat_status();
//            if(k == 0){
//                seat_statu[i][j] = 0;
//            }else if(k == 1){
//                seat_statu[i][j] = 1;
//            }else{
//                seat_statu[i][j] = -1;
//            }
//        }

        request.setAttribute("list", list);
        request.setAttribute("studio", studio);
        request.setAttribute("seat_statu", seat_statu);

        return new ModelAndView("/manager/task/Seats");
    }


    @RequestMapping("/changeseat")
    public ModelAndView changeSeatPage(HttpServletRequest request){

        String studio_name = request.getParameter("studioname");
        String row = request.getParameter("studiorow");
        int seat_row = Integer.parseInt(row);
        String col = request.getParameter("studiocol");
        int seat_column = Integer.parseInt(col);
        String status = request.getParameter("studiostatu");
        int seat_status = Integer.parseInt(status);

        String errors = seatService.changeSeat(studio_name, seat_row, seat_column, seat_status);
        request.setAttribute("errors", errors);

        return new ModelAndView("/manager/task/ChangeSeat");
    }

    @RequestMapping("/addseat")
    public ModelAndView addSeatPage(HttpServletRequest request){

        String studio_name = request.getParameter("studioname");
        String row = request.getParameter("studiorow");
        int seat_row = Integer.parseInt(row);
        String col = request.getParameter("studiocol");
        int seat_column = Integer.parseInt(col);
        String status = request.getParameter("studiostatu");
        int seat_status = Integer.parseInt(status);

        String errors = seatService.addSeat(studio_name, seat_row, seat_column, seat_status);
        request.setAttribute("errors", errors);

        return  new ModelAndView("/manager/task/AddSeat");

    }


    @RequestMapping("/delseat")
    public ModelAndView deleteSeatPage(HttpServletRequest request){

        String studio_name = request.getParameter("studioname");
        String row = request.getParameter("studiorow");
        int seat_row = Integer.parseInt(row);
        String col = request.getParameter("studiocol");
        int seat_column = Integer.parseInt(col);
        String errors = seatService.selectSeatByPosition(studio_name, seat_row, seat_column);
        request.setAttribute("errors", errors);

        return new ModelAndView("/manager/task/DeleteSeat");
    }
}
