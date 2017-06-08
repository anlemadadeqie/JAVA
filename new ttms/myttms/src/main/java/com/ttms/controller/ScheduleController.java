package com.ttms.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.ttms.entity.Play;
import com.ttms.entity.Schedule;
import com.ttms.entity.ScheduleDetail;
import com.ttms.entity.Studio;
import com.ttms.service.PageService;
import com.ttms.service.PlayService;
import com.ttms.service.ScheduleService;
import com.ttms.service.StudioService;
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
    @Autowired
    PageService pageService;
    @Autowired
    StudioService studioService;
    @Autowired
    PlayService playService;


    @RequestMapping("/showsched")
    public ModelAndView showSchedPage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showScheduleByPage(request, pageNow);
        return new ModelAndView("/manager/schedule/Schedule");

    }

    @RequestMapping("/addschedshow")
    public ModelAndView addSchedShowPage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showScheduleByPage(request, pageNow);
        return new ModelAndView("/manager/schedule/AddScheduleShow");

    }


    @RequestMapping("/addsched")
    public ModelAndView addSchedPage(HttpServletRequest request){

        String studio_id = request.getParameter("studioid");
        System.out.println("studio_id"+studio_id);
        String play_id = request.getParameter("playid");
        String sched_time = request.getParameter("schedtime");
        String sched_ticket_price = request.getParameter("schedprice");
        String errors = scheduleService.addSchedule(studio_id, play_id, sched_time, sched_ticket_price);
        request.setAttribute("errors", errors);
        return new ModelAndView("/manager/schedule/AddSchedule2");

    }

    @RequestMapping("/updatesched")
    public ModelAndView updateSchedPage(HttpServletRequest request){

        String sched_id = request.getParameter("id");
        String studio_name = request.getParameter("studioname");
        String play_name = request.getParameter("playname");
        String sched_time = request.getParameter("schedtime");
        String sched_ticket_price = request.getParameter("schedprice");
        String errors = scheduleService.updateSchedule(sched_id, studio_name, play_name, sched_time, sched_ticket_price);
        request.setAttribute("errors", errors);
        return new ModelAndView("/manager/schedule/UpdateSchedule");
    }


    @RequestMapping("/delschedshow")
    public ModelAndView delSchedShowPage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showScheduleByPage(request, pageNow);
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
        return delSchedShowPage(request);
    }

    @RequestMapping("/toaddschedule")
    public ModelAndView toAddSchedulePage(HttpServletRequest request){

        List<Studio> studio = studioService.selectStudio();
        List<Play> play = playService.selectPlay();
        request.setAttribute("studio", studio);
        request.setAttribute("play", play);

        return new ModelAndView("/manager/schedule/AddSchedule");

    }


    @RequestMapping("/editsched")
    public ModelAndView editSchedPage(HttpServletRequest request){

        String id = request.getParameter("id");
        int sched_id = Integer.parseInt(id);
        ScheduleDetail scheduleDetail = scheduleService.selectOneSchedule(sched_id);
        request.setAttribute("scheduleDetail", scheduleDetail);

        return new ModelAndView("/manager/schedule/UpdateSchedule");
    }

}
