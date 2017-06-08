package com.ttms.service;

import com.ttms.entity.Seat;
import com.ttms.entity.Studio;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-6.
 */
public interface SeatService {


    public void updateSeatStatus(Seat seat);
    public int[][] selectSeatByStudio_id(int studio_id);
    public Seat selectSeatBySeat_id(Seat seat);
    public Seat  selectSeatByPosition2(String studio_name, int seat_row, int seat_column);
    public String  selectSeatByPosition(String studio_name, int seat_row, int seat_column);
    public String changeSeat(String studio_name, int seat_row, int seat_column, int seat_status);
//    public String addSeat(String studio_name, int seat_row, int seat_column, int seat_status);


}
