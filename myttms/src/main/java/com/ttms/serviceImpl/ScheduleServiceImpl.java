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

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public String addSchedule(String studio_id, String play_id, String sched_time, String sched_ticket_price) {

        String errors = "该影厅不存在!";
        Play play = null;
        int stu_id = Integer.parseInt(studio_id);
        Studio studio = studioDAO.selectStudioByStudio_id(stu_id);
        if(studio != null){

            int pla_id = Integer.parseInt(play_id);
            play = playDAO.selectPlayByPlay_id(pla_id);

            if(play == null){

                errors = "该影片不存在！";
            }else{

                long time = 0;
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                        time = format.parse(sched_time).getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                List<Schedule> lists = scheduleDAO.selectScheduleByStudio_id(stu_id);
                for(Schedule list:lists){
                    int play_ids = list.getPlay_id();
                    String sched_times = list.getSched_time();
                    int play_lengths = playDAO.selectPlayByPlay_id(play_ids).getPlay_length();
                    long time1 = 0;
                    long time2 = 0;
                    try {
                        time1 = format.parse(sched_times).getTime();
                        time2 = time1+play_lengths*60*1000;
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(time >= time1 && time <= time2){

                        errors = "该影厅该时间段已有安排！";
                        return errors;
                    }

                }
                double sched_price = Double.parseDouble(sched_ticket_price);
                Schedule schedule = new Schedule();
                schedule.setStudio_id(stu_id);
                schedule.setPlay_id(pla_id);
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


        int id = Integer.parseInt(sched_id);
        Schedule schedule1 = scheduleDAO.selectScheduleBySched_id(id);
        int stu_id = schedule1.getStudio_id();
        int pla_id = schedule1.getPlay_id();
        String sche_time = schedule1.getSched_time();
        double price = schedule1.getSched_ticket_price();

        Schedule schedule = new Schedule();
        schedule.setSched_id(id);

        if(studio_name == null || studio_name.trim().length() <= 0){

            schedule.setStudio_id(stu_id);

        }else {

            Studio studio = studioDAO.selectStudioByStudio_name(studio_name);
            if (studio != null) {
                int studio_id = studio.getStudio_id();
                schedule.setSched_id(studio_id);
            } else {
                errors = "该影厅不存在！";
                return errors;
            }
        }

        if(play_name == null || play_name.trim().length() <= 0) {

            schedule.setPlay_id(pla_id);

        }else {

            Play play = playDAO.selectPlayByPlay_name(play_name);
            if (play != null) {
                int play_id = play.getPlay_id();
                schedule.setPlay_id(play_id);
            } else {
                errors = "该影片不存在！";
                return errors;
            }
        }

        if(sched_time == null || sched_time.trim().length() <= 0) {

            schedule.setSched_time(sche_time);

        }else {

            long time = 0;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                time = format.parse(sched_time).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            List<Schedule> lists = scheduleDAO.selectScheduleBySpecialStudio_id(stu_id, id);
            for (Schedule list : lists) {

                int play_ids = list.getPlay_id();
                String sched_times = list.getSched_time();
                int play_lengths = playDAO.selectPlayByPlay_id(play_ids).getPlay_length();
                long time1 = 0;
                long time2 = 0;
                try {
                    time1 = format.parse(sched_times).getTime();
                    time2 = time1 + play_lengths * 60 * 1000;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (time >= time1 && time <= time2) {

                    errors = "该影厅该时间段已有安排！";
                    return errors;
                }

            }
        }

        if(sched_ticket_price == null || sched_ticket_price.trim().length() <= 0) {

            schedule.setSched_ticket_price(price);
        }else {
            double sched_price = Double.parseDouble(sched_ticket_price);
            schedule.setSched_ticket_price(sched_price);
        }

        scheduleDAO.updateSchedule(schedule);
        errors = "更新成功！";

        return  errors;

    }


    @Override
    public ScheduleDetail selectOneSchedule(int sched_id) {

        ScheduleDetail scheduleDetail = scheduleDetailDAO.selectOneScheduleDetail(sched_id);
        return scheduleDetail;
    }

}

