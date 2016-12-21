package com.ttms.controller;

import com.ttms.entity.Play;
import com.ttms.service.PageService;
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
    @Autowired
    PageService pageService;

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


}
