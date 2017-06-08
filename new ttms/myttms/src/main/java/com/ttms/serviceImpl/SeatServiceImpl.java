package com.ttms.serviceImpl;

import com.ttms.dao.SeatDAO;
import com.ttms.dao.StudioDAO;
import com.ttms.entity.Seat;
import com.ttms.entity.Studio;
import com.ttms.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hjh on 16-12-6.
 */
@Service("SeatServiceImpl")
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatDAO seatDAO;
    @Autowired
    StudioDAO studioDAO;


    @Override
    public void updateSeatStatus(Seat seat) {
        seatDAO.updateSeat(seat);
    }

    @Override
    public int[][] selectSeatByStudio_id(int studio_id) {

        List<Seat> list = null;
        list = seatDAO.selectSeatByStudio_id(studio_id);
        Studio studio = studioDAO.selectStudioByStudio_id(studio_id);

        System.out.println("hdjhkghkd");
        int studio_row = studio.getStudio_row_count();
        int studio_col = studio.getStudio_col_count();
        System.out.println("row"+studio_row);
        System.out.println("col"+studio_col);
        int[][] seat_statu = new int[studio_row + 1][studio_col + 1];

        for (int i = 0; i < studio_row+1; i++) {
            for (int j = 0; j < studio_col+1; j++) {
                seat_statu[i][j] = -2;
            }
        }

        if(list != null){

            for (Seat seats : list) {

                int i = seats.getSeat_row();
                int j = seats.getSeat_column();
                int k = seats.getSeat_status();
                if (k == 0) {
                    seat_statu[i][j] = 0;
                } else if (k == 1) {
                    seat_statu[i][j] = 1;
                } else {
                    seat_statu[i][j] = -1;
                }
            }
        }

        return seat_statu;
    }

    @Override
    public Seat selectSeatBySeat_id(Seat seat) {
        return seatDAO.selectSeatBySeat_id(seat);
    }

    @Override
    public String selectSeatByPosition(String studio_name, int seat_row, int seat_column) {

        String errors = "";
        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
        int studio_id = studio.getStudio_id();
        Seat seat = seatDAO.selectSeatByPosition(studio_id, seat_row, seat_column);
        if (seat == null) {

            errors = "该座位不存在！";

        } else {
            int seat_id = seat.getSeat_id();
            seatDAO.deleteSeat(seat_id);
            errors = "座位删除成功！";
        }

        return errors;

    }
    @Override
    public Seat  selectSeatByPosition2(String studio_name, int seat_row, int seat_column) {

        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
        int studio_id = studio.getStudio_id();
        Seat seat = seatDAO.selectSeatByPosition(studio_id, seat_row, seat_column);
        return seat;

    }

    @Override
    public String changeSeat(String studio_name, int seat_row, int seat_column, int seat_status) {

        String errors = "";
        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
        int studio_id = studio.getStudio_id();
        Seat seat = seatDAO.selectSeatByPosition(studio_id, seat_row, seat_column);
        Seat seat1 = null;
        if (seat == null) {

            errors = "该座位不存在";

        } else {

            int seat_id = seat.getSeat_id();
            seat1 = new Seat();
            seat1.setSeat_id(seat_id);
            seat1.setStudio_id(studio_id);
            seat1.setSeat_row(seat_row);
            seat1.setSeat_column(seat_column);
            seat1.setSeat_status(seat_status);
            seatDAO.updateSeat(seat1);
            errors = "修改成功！";
        }

        return errors;
    }

//    @Override
//    public String addSeat(String studio_name, int seat_row, int seat_column, int seat_status) {
//
//        String errors = "该影厅不存在";
//        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
//        if (studio != null) {
//
//            int row = studio.getStudio_row_count();
//            int col = studio.getStudio_col_count();
//            if (seat_row > row || seat_column > col) {
//
//                errors = "该座位位置不规范";
//
//            } else {
//
//                int studio_id = studio.getStudio_id();
//                Seat seat = seatDAO.selectSeatByPosition(studio_id, seat_row, seat_column);
//                Seat seat1 = null;
//                if (seat != null) {
//
//                    errors = "该座位已存在";
//
//                }
//
//                seat1 = new Seat();
//                seat1.setStudio_id(studio_id);
//                seat1.setSeat_row(seat_row);
//                seat1.setSeat_column(seat_column);
//                seat1.setSeat_status(seat_status);
//                seatDAO.insertSeat(seat1);
//                errors = "增加成功！";
//            }
//
//        }
//        return errors;
//    }
}


