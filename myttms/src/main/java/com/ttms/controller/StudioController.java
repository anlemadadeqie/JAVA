package com.ttms.controller;

import com.ttms.entity.Studio;
import com.ttms.service.PageService;
import com.ttms.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by hjh on 16-12-5.
 */
@Controller("StudioController")
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioService studioService;
    @Autowired
    PageService pageService;

    @RequestMapping("/showstudio")
    public ModelAndView showStudioPage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showStudioByPage(request, pageNow);
        return new ModelAndView("/manager/knowledge/Studio");

    }

    @RequestMapping("/addstudioshow")
    public ModelAndView addStudioShowPage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showStudioByPage(request, pageNow);
        return new ModelAndView("/manager/knowledge/AddStudioShow");

    }


    @RequestMapping("/addstudio")
    public ModelAndView addStudioPage(HttpServletRequest request){

        String studio_name = request.getParameter("studioname");
        String studio_row_count = request.getParameter("studiorow");
        String studio_col_count = request.getParameter("studiocol");
        String studio_flag = request.getParameter("studiostatu");
        String studio_introduction = request.getParameter("studiointro");
        String errors = studioService.addStudio(studio_name, studio_row_count, studio_col_count, studio_flag, studio_introduction);
        request.setAttribute("errors", errors);

        return new ModelAndView("/manager/knowledge/AddStudio");

    }

    @RequestMapping("/updatestudio")
    public ModelAndView updateStudioPage(HttpServletRequest request){

        String studio_id = request.getParameter("id");
        String studio_name = request.getParameter("studioname");
        String studio_row_count = request.getParameter("studiorow");
        String studio_col_count = request.getParameter("studiocol");
        String studio_flag = request.getParameter("studiostatu");
        String studio_introduction = request.getParameter("studiointro");
        String errors = studioService.updateStudio(studio_id, studio_name, studio_row_count, studio_col_count, studio_flag, studio_introduction);

        return addStudioShowPage(request);
    }



    @RequestMapping("/delstudioshow")
    public ModelAndView delStudioShowPage(HttpServletRequest request){

        String pageNow = request.getParameter("pageNow");
        pageService.showStudioByPage(request, pageNow);

        return new ModelAndView("/manager/knowledge/DelStudioShow");

    }

    @RequestMapping("/delstudio")
    public ModelAndView delStudioPage(HttpServletRequest request){

        String[] checkbox = request.getParameterValues("type");
        if(checkbox != null) {
            for (int i = 0; i < checkbox.length; i++) {
                String id = checkbox[i];
                int studio_id = Integer.parseInt(id);
                studioService.deleteStudio(studio_id);
            }
        }

        return delStudioShowPage(request);
    }

    @RequestMapping("/editstudio")
    public ModelAndView editStudio(HttpServletRequest request){

        String id = request.getParameter("id");
        int studio_id = Integer.parseInt(id);
        Studio studio = studioService.selectStudioByStudio_id(studio_id);
        request.setAttribute("studio", studio);
        return new ModelAndView("/manager/knowledge/UpdateStudio");

    }
}
