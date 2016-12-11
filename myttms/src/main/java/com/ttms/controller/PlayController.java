package com.ttms.controller;

import com.ttms.entity.Play;
import com.ttms.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-8.
 */
@Controller("PlayController")
@RequestMapping("/play")
public class PlayController{

    @Autowired
    PlayService playService;

    private static final long serialVersionUID = 1L;

    @RequestMapping("/showplay")
    public ModelAndView fileShowPage(HttpServletRequest request){

        List<Play> list = playService.selectPlay();
        request.setAttribute("list", list);
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

        List<Play> list = playService.selectPlay();
        request.setAttribute("list", list);
        return new ModelAndView("/manager/play/AddPlayShow");

    }

    @RequestMapping("/updateplay")
    public ModelAndView updateFilePage(HttpServletRequest request){

        String errors = playService.updatePlay(request);
        request.setAttribute("errors",errors);
        return  new ModelAndView("/manager/play/UpdatePlay");



    }


    @RequestMapping("/delplay")
    public ModelAndView delFilePage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        for(int i= 0; i < checkbox.length; i++){
            String id = checkbox[i];
            int play_id = Integer.parseInt(id);
            playService.deletePlay(play_id);
        }

        return delFileShowPage(request);



    }

    @RequestMapping("/delplayshow")
    public ModelAndView delFileShowPage(HttpServletRequest request){

        List<Play> list = playService.selectPlay();
        request.setAttribute("list", list);
        return new ModelAndView("/manager/play/DelPlayShow");

    }


}
