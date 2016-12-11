package com.ttms.controller;

import com.ttms.entity.Schedule;
import com.ttms.entity.ScheduleDetail;
import com.ttms.entity.Studio;
import com.ttms.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-10.
 */
@Controller("ScheduleController")
@RequestMapping("/schedule")
public class ScheduleController {


    @Autowired
    ScheduleService scheduleService;


    @RequestMapping("/showsched")
    public ModelAndView showSchedPage(HttpServletRequest request){

        List<ScheduleDetail> list = null;
        list = scheduleService.selectScheduleDetail();
        request.setAttribute("list", list);

        return new ModelAndView("/manager/schedule/Schedule");



    }

    @RequestMapping("/addschedshow")
    public ModelAndView addStudioShowPage(HttpServletRequest request){

        List<ScheduleDetail> list = null;
        list = scheduleService.selectScheduleDetail();
        request.setAttribute("list", list);

        return new ModelAndView("/manager/schedule/AddScheduleShow");

    }


    @RequestMapping("/addsched")
    public ModelAndView addStudioPage(HttpServletRequest request){

        String studio_name = request.getParameter("studioname");
        String play_name = request.getParameter("playname");
        String sched_time = request.getParameter("schedtime");
        String sched_ticket_price = request.getParameter("sched_ticket_price");
        String errors = scheduleService.addSchedule(studio_name, play_name, sched_time, sched_ticket_price);
        request.setAttribute("errors", errors);
        return new ModelAndView("/manager/knowledge/AddStudio");

    }

    @RequestMapping("/updatesched")
    public ModelAndView updateStudioPage(HttpServletRequest request){

        String sched_id = request.getParameter("id");
        String studio_name = request.getParameter("studioname");
        String play_name = request.getParameter("playname");
        String sched_time = request.getParameter("schedtime");
        String sched_ticket_price = request.getParameter("sched_ticket_price");
        String errors = scheduleService.updateSchedule(sched_id, studio_name, play_name, sched_time, sched_ticket_price);
        request.setAttribute("errors", errors);

        return new ModelAndView("/manager/knowledge/UpdateStudio");
    }


    @RequestMapping("/delschedshow")
    public ModelAndView delStudioShowPage(HttpServletRequest request){

        List<ScheduleDetail> list = null;
        list = scheduleService.selectScheduleDetail();
        request.setAttribute("list", list);

        return new ModelAndView("/manager/schedule/DelScheduleShow");

    }

    @RequestMapping("/delsched")
    public ModelAndView delSchedPage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int sched_id = Integer.parseInt(id);
                scheduleService.deleteSchedule(sched_id);
            }
        }
        return new ModelAndView("/manager/schedule/DelScheduleShow");
    }



}
