package com.ttms.serviceImpl;

import com.ttms.dao.SeatDAO;
import com.ttms.dao.StudioDAO;
import com.ttms.entity.Seat;
import com.ttms.entity.Studio;
import com.ttms.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hjh on 16-12-5.
 */
@Service("StudioServiceImpl")
public class StudioServiceImpl implements StudioService {


    @Autowired
    StudioDAO studioDAO;
    @Autowired
    SeatDAO seatDAO;

    @Override
    public void insertStudio(Studio studio) {

        studioDAO.insertStudio(studio);

    }

    @Override
    public void deleteStudio(int studio_id) {

        studioDAO.deleteStudio(studio_id);

    }

    @Override
    public void updateStudio(Studio studio) {

        studioDAO.updateStudio(studio);

    }

    @Override
    public Studio selectStudioByStudio_id(int studio_id) {

        Studio studio = null;
        studio = studioDAO.selectStudioByStudio_id(studio_id);
        return studio;
    }

    @Override
    public Studio selectStudioByStudio_name(String studio_name) {

        Studio studio = null;
        studio = studioDAO.selectStudioByStudio_name(studio_name);
        return studio;
    }

    @Override
    public List<Studio> selectStudioByStudio_flag(int studio_flag) {

        List<Studio> list = null;
        list = studioDAO.selectStudioByStudio_flag(studio_flag);
        return list;
    }

    @Override
    public List<Studio> selectStudio() {

        List<Studio> list = null;
        list = studioDAO.selectStudio();
        return list;
    }

    @Override
    public String addStudio(String studio_name, String studio_row_count, String studio_col_count, String studio_flag, String studio_introduction) {

        String errors = "";
        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
        if(studio != null){

            errors = "该影厅已存在";

        }else{

            int flag = Integer.parseInt(studio_flag);
            int row = Integer.parseInt(studio_row_count);
            int col = Integer.parseInt(studio_col_count);
            Studio studio1 = new Studio();
            studio1.setStudio_name(studio_name);
            studio1.setStudio_row_count(row);
            studio1.setStudio_col_count(col);
            studio1.setStudio_flag(flag);
            studio1.setStudio_introduction(studio_introduction);
            studioDAO.insertStudio(studio1);
            int studio_id = studio1.getStudio_id();
            Seat seat = null;
            for(int i = 1; i <= row; i++){
                for(int j = 1; j <= col; j++){

                    seat = new Seat();
                    seat.setStudio_id(studio_id);
                    seat.setSeat_row(i);
                    seat.setSeat_column(j);
                    seat.setSeat_status(0);
                    seatDAO.insertSeat(seat);

                }
            }

            errors = "增加成功！";

        }

        return errors;

    }

    @Override
    public String updateStudio(String studio_id, String studio_name, String studio_row_count, String studio_col_count, String studio_flag, String studio_introduction) {

        String errors = "更新失败！";
        int id = Integer.parseInt(studio_id);
        Studio studio1 = studioDAO.selectStudioByStudio_id(id);
        String name = studio1.getStudio_name();
        int rows = studio1.getStudio_row_count();
        int cols = studio1.getStudio_col_count();
        String introductions = studio1.getStudio_introduction();
        int flag = studio1.getStudio_flag();

        Studio studio = new Studio();
        studio.setStudio_id(id);

        if(studio_name != null && studio_name.trim().length() > 0) {
            studio1 = studioDAO.selectStudioByStudio_name(studio_name);
            if (studio == null) {

                errors = "该影厅不存在";

            } else {

                studio.setStudio_name(studio_name);

            }
        }else {

            studio.setStudio_name(name);
        }

        if(studio_row_count == null || studio_row_count.trim().length() <= 0) {

            studio.setStudio_row_count(rows);
        }else {

            int row_count = Integer.parseInt(studio_row_count);
            studio.setStudio_row_count(row_count);
        }


        if(studio_col_count == null || studio_col_count.trim().length() <= 0) {

            studio.setStudio_col_count(cols);
        }else {

            int col_count = Integer.parseInt(studio_col_count);
            studio.setStudio_col_count(col_count);
        }

        if(studio_introduction == null || studio_introduction.trim().length() <= 0) {

            studio.setStudio_introduction(introductions);
        }else {

            studio.setStudio_introduction(studio_introduction);
        }

        if(studio_flag == null || studio_flag.trim().length() <= 0) {

            studio.setStudio_flag(flag);
        }else {

            int flags = Integer.parseInt(studio_flag);
            studio.setStudio_flag(flags);
        }

        studioDAO.updateStudio(studio);
        studio1 = studioDAO.selectStudioByStudio_id(id);
        int row = studio1.getStudio_row_count();
        int col = studio1.getStudio_col_count();
        seatDAO.deleteAllSeat();
        Seat seat = null;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){

                    seat = new Seat();
                    seat.setStudio_id(id);
                    seat.setSeat_row(i);
                    seat.setSeat_column(j);
                    seat.setSeat_status(0);
                    seatDAO.insertSeat(seat);

                }
            }


        errors = "更新成功！";
        return errors;

    }


    @Override
    public List<Studio> selectSpecialStudio(int studio_id) {

        List<Studio> list = null;
        list = studioDAO.selectSpecialStudio(studio_id);
        return list;
    }
}
