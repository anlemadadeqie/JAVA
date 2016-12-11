package com.ttms.serviceImpl;

import com.ttms.dao.PlayDAO;
import com.ttms.dao.ScheduleDAO;
import com.ttms.dao.ScheduleDetailDAO;
import com.ttms.dao.StudioDAO;
import com.ttms.entity.Play;
import com.ttms.entity.Schedule;
import com.ttms.entity.ScheduleDetail;
import com.ttms.entity.Studio;
import com.ttms.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Service("ScheduleServiceImpl")
public class ScheduleServiceImpl implements ScheduleService {


    @Autowired
    ScheduleDAO scheduleDAO;
    @Autowired
    ScheduleDetailDAO scheduleDetailDAO;
    @Autowired
    StudioDAO studioDAO;
    @Autowired
    PlayDAO playDAO;

    @Override
    public void insertSchedule(Schedule schedule) {

        scheduleDAO.insertSchedule(schedule);
    }

    @Override
    public void deleteSchedule(int sched_id) {

        scheduleDAO.deleteSchedule(sched_id);

    }

    @Override
    public void updateSchedule(Schedule schedule) {

        scheduleDAO.updateSchedule(schedule);

    }

    @Override
    public Schedule selectScheduleBySched_id(int sched_id) {

        Schedule schedule = null;
        schedule = scheduleDAO.selectScheduleBySched_id(sched_id);
        return schedule;
    }

    @Override
    public List<Schedule> selectSchedule() {

        List<Schedule> list = null;
        list = scheduleDAO.selectSchedule();
        return list;
    }

    @Override
    public List<ScheduleDetail> selectScheduleDetail() {

        List<ScheduleDetail> list = null;
        list = scheduleDetailDAO.selectScheduleDetail();
        return list;
    }

    @Override
    public String addSchedule(String studio_name, String play_name, String sched_time, String sched_ticket_price) {

        String errors = "该影厅不存在!";
        Studio studio = null;
        Play play = null;
        studio = studioDAO.selectStudioByStudio_name(studio_name);
        int studio_id = studio.getStudio_id();
        if(studio != null){

            play = playDAO.selectPlayByPlay_name(play_name);
            if(play == null){

                errors = "该影片不存在！";
            }else{

                int play_id = play.getPlay_id();
                double sched_price = Double.parseDouble(sched_ticket_price);
                Schedule schedule = new Schedule();
                schedule.setStudio_id(studio_id);
                schedule.setPlay_id(play_id);
                schedule.setSched_time(sched_time);
                schedule.setSched_ticket_price(sched_price);
                scheduleDAO.insertSchedule(schedule);
                errors = "添加成功！";
            }
        }
        return  errors;
    }

    @Override
    public String updateSchedule(String sched_id, String studio_name, String play_name, String sched_time, String sched_ticket_price) {

        String errors = "该影厅不存在！";
        Studio studio = null;
        Play play = null;
        studio = studioDAO.selectStudioByStudio_name(studio_name);
        int studio_id = studio.getStudio_id();
        if(studio != null){

            play = playDAO.selectPlayByPlay_name(play_name);
            if(play == null){

                errors = "该影片不存在！";
            }else{

                int play_id = play.getPlay_id();
                double sched_price = Double.parseDouble(sched_ticket_price);
                int id = Integer.parseInt(sched_id);
                Schedule schedule = new Schedule();
                schedule.setSched_id(id);
                schedule.setStudio_id(studio_id);
                schedule.setPlay_id(play_id);
                schedule.setSched_time(sched_time);
                schedule.setSched_ticket_price(sched_price);
                scheduleDAO.updateSchedule(schedule);
                errors = "更新成功！";
            }
        }
        return  errors;

        }

    }

