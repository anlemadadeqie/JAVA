package com.ttms.service;

import com.ttms.entity.*;
import com.ttms.entity.ScheduleDetail;

import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */

public interface ScheduleService {


    public void insertSchedule(Schedule schedule);
    public void deleteSchedule(int sched_id);
    public void updateSchedule(Schedule schedule);

    public Schedule selectScheduleBySched_id(int sched_id);
    public List<Schedule> selectSchedule();
    public List<ScheduleDetail> selectScheduleDetail();
    public String addSchedule(String studio_id, String play_id, String sched_time, String sched_ticket_price);
    public String updateSchedule(String sched_id, String studio_name, String play_name, String sched_time, String sched_ticket_price);
    public ScheduleDetail selectOneSchedule(int sched_id);

    public Studio searchbyscid(Schedule sche);
    public Play   searchforplay(Schedule sche);

    public List<Schedule> selectScheduleByPlay_id(int play_id);
}
