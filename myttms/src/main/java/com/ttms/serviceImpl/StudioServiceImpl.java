package com.ttms.serviceImpl;

import com.ttms.dao.StudioDAO;
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
            errors = "增加成功！";

        }

        return errors;

    }

    @Override
    public String updateStudio(String studio_name, String studio_row_count, String studio_col_count, String studio_flag, String studio_introduction) {

        String errors = "";
        Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
        if(studio == null){

            errors = "该影厅不存在";

        }else{

            int studio_id = studio.getStudio_id();
            int flag = Integer.parseInt(studio_flag);
            int row = Integer.parseInt(studio_row_count);
            int col = Integer.parseInt(studio_col_count);
            Studio studio1 = new Studio();
            studio1.setStudio_id(studio_id);
            studio1.setStudio_name(studio_name);
            studio1.setStudio_row_count(row);
            studio1.setStudio_col_count(col);
            studio1.setStudio_flag(flag);
            studio1.setStudio_introduction(studio_introduction);
            studioDAO.updateStudio(studio1);
            errors = "更新成功！";

        }

        return errors;

    }

    @Override
    public List<Studio> selectSpecialStudio(int studio_id) {

        List<Studio> list = null;
        list = studioDAO.selectSpecialStudio(studio_id);
        return list;
    }
}
