package com.ttms.controller;

import com.ttms.entity.Studio;
import com.ttms.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hjh on 16-12-5.
 */
@Controller("StudioController")
@RequestMapping("/studio")
public class StudioController {

    @Autowired
    StudioService studioService;

    @RequestMapping("/showstudio")
    public ModelAndView showStudioPage(HttpServletRequest request){

        List<Studio> list = null;
        list = studioService.selectStudio();
        request.setAttribute("list",list);

        return new ModelAndView("/manager/knowledge/Studio");

    }

    @RequestMapping("/addstudioshow")
    public ModelAndView addStudioShowPage(HttpServletRequest request){

        List<Studio> list = null;
        list  = studioService.selectStudio();
        request.setAttribute("list", list);

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
        String studio_name = request.getParameter("studioname");
        String studio_row_count = request.getParameter("studiorow");
        String studio_col_count = request.getParameter("studiocol");
        String studio_flag = request.getParameter("studiostatu");
        String studio_introduction = request.getParameter("studiointro");
        String errors = studioService.updateStudio(studio_name, studio_row_count, studio_col_count, studio_flag, studio_introduction);
        request.setAttribute("errors", errors);

        return new ModelAndView("/manager/knowledge/UpdateStudio");
    }



    @RequestMapping("/delstudioshow")
    public ModelAndView delStudioShowPage(HttpServletRequest request){

        List<Studio> list = null;
        list = studioService.selectStudio();
        request.setAttribute("list", list);

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
}
