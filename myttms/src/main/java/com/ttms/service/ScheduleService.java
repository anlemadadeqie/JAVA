package com.ttms.service;

import com.ttms.entity.Schedule;
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
    public String addSchedule(String studio_name, String play_name, String sched_time, String sched_ticket_price);
    public String updateSchedule(String sched_id, String studio_name, String play_name, String sched_time, String sched_ticket_price);


}
