package com.ttms.controller;

import com.ttms.entity.*;
import com.ttms.entity.Schedule;
import com.ttms.service.PageService;
import com.ttms.service.PlayService;
import com.ttms.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by hjh on 16-12-8.
 */
@Controller("PlayController")
@RequestMapping("/play")
public class PlayController{

    @Autowired
    PlayService playService;
    @Autowired
    PageService pageService;
    @Autowired
    ScheduleService scheduleService;

    private static final long serialVersionUID = 1L;


    @RequestMapping("/showplay")
    public ModelAndView fileShowPage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showPlayByPage(request, pageNow);
        return new ModelAndView("/manager/play/Play");

    }

    @RequestMapping("/addplay")
    public ModelAndView fileUpPage(HttpServletRequest request){

        String errors = playService.addPlay(request);
        request.setAttribute("errors",errors);
        return  new ModelAndView("/manager/play/AddPlay");
    }

    @RequestMapping("/addplayshow")
    public ModelAndView addFileShowPage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showPlayByPage(request, pageNow);
        return new ModelAndView("/manager/play/AddPlayShow");

    }

    @RequestMapping("/updateplay")
    public ModelAndView updateFilePage(HttpServletRequest request){

        String errors = playService.updatePlay(request);
        return  addFileShowPage(request);

    }

    @RequestMapping("/detailplay")
    public ModelAndView detailplay(HttpServletRequest request){

        Play plays;
        List<ScheduleDetail> scheduleDetailList = new ArrayList<ScheduleDetail>();
        ScheduleDetail scheduleDetail = new ScheduleDetail();
        String play_id = request.getParameter("play");
        int play = Integer.parseInt(play_id);
        plays = playService.selectPlayByPlay_id(play);
        List<Schedule> scheds = scheduleService.selectScheduleByPlay_id(play);
        for(int i=0;i<scheds.size();i++){

            Studio studio = scheduleService.searchbyscid(scheds.get(i));
            plays = scheduleService.searchforplay(scheds.get(i));
            scheduleDetail.setPlay_name(plays.getPlay_name());
            scheduleDetail.setSched_id(scheds.get(i).getSched_id());
            scheduleDetail.setSched_ticket_price(scheds.get(i).getSched_ticket_price());
            System.out.println("price"+scheds.get(i).getSched_ticket_price());
            scheduleDetail.setSched_time(scheds.get(i).getSched_time());
            scheduleDetail.setStudio_name(studio.getStudio_name()+"|"+studio.getStudio_id());
            scheduleDetailList.add(scheduleDetail);
        }
        request.setAttribute("scheduledetail",scheduleDetailList);
        request.setAttribute("play",plays);
        return new ModelAndView("/ordinary/detail");


    }
    @RequestMapping("/delplay")
    public ModelAndView delFilePage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int play_id = Integer.parseInt(id);
                playService.deletePlay(play_id);
            }
        }

        return delFileShowPage(request);



    }

    @RequestMapping("/delplayshow")
    public ModelAndView delFileShowPage(HttpServletRequest request){


        String pageNow = request.getParameter("pageNow");
        pageService.showPlayByPage(request, pageNow);
        return new ModelAndView("/manager/play/DelPlayShow");

    }

    @RequestMapping("/editplay")
    public ModelAndView editPlay(HttpServletRequest request){

        String id = request.getParameter("id");
        int play_id = Integer.parseInt(id);
        Play play = playService.selectPlayByPlay_id(play_id);
        request.setAttribute("play", play);
        System.out.println("aaaaaaaaaaaaa");

        return new ModelAndView("/manager/play/UpdatePlay");

    }

    @RequestMapping("/showAllPlay")
    public ModelAndView showAllPlay(HttpServletRequest request){
        List<Play> play = playService.selectPlay();
        request.setAttribute("plays",play);
        return new ModelAndView("show");
    }




}
