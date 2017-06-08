package com.ttms.serviceImpl;

import com.ttms.dao.PlayDAO;
import com.ttms.entity.Play;
import com.ttms.service.PlayService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.List;

/**
 * Created by hjh on 16-12-8.
 */
@Service("PlayServiceImpl")
public class PlayServiceImpl implements PlayService {

    @Autowired
    PlayDAO playDAO;

    @Override
    public void insertPlay(Play play) {

        playDAO.insertPlay(play);
    }

    @Override
    public void deletePlay(int play_id) {

        playDAO.deletePlay(play_id);
    }

    @Override
    public void updatePlay(Play play) {

        playDAO.updatePlay(play);
    }

    @Override
    public Play selectPlayByPlay_id(int play_id) {

        Play play = null;
        play = playDAO.selectPlayByPlay_id(play_id);
        return play;
    }

    @Override
    public List<Play> selectPlay() {

        List<Play> list = null;
        list = playDAO.selectPlay();
        return list;
    }

    @Override
    public String addPlay(HttpServletRequest request) {
        String paramName = "";
        String paramValue = "";
        String errors = "";
        Play play = new Play();

        //创建对象
        DiskFileItemFactory dff = new DiskFileItemFactory();
        //指定在内存中缓存数据的大小
        dff.setSizeThreshold(1024000);
        //创建上传对象
        ServletFileUpload sfu = new ServletFileUpload(dff);
        //指定单个上传文件的最大尺寸
        sfu.setFileSizeMax(1024*1024*2);

        try{
            List<FileItem> uploaditems = sfu.parseRequest(request);

            for(FileItem fileItem : uploaditems){

                paramName = fileItem.getFieldName();


                if(fileItem.isFormField()){

                    paramValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");


                    if("play_name".equals(paramName)){
                        Play play1 = playDAO.selectPlayByPlay_name(paramValue);
                        if(play1 != null){

                            errors = "该影片已经存在！";
                            return  errors;
                        }
                        play.setPlay_name(paramValue);
                    }


                    if("play_type".equals(paramName)){

                        play.setPlay_type(paramValue);
                    }

                    if("play_lang".equals(paramName)){

                        play.setPlay_lang(paramValue);
                    }

                    if("play_introduction".equals(paramName))
                        play.setPlay_introduction(paramValue);

                    if("play_length".equals(paramName)){
                        String length = paramValue;
                        int play_length = Integer.parseInt(length);
                        play.setPlay_length(play_length);
                    }

                    if("play_price".equals(paramName)){

                        String price = paramValue;
                        double play_ticket_price = Double.parseDouble(price);
                        play.setPlay_ticket_price(play_ticket_price);
                    }

                    if("play_status".equals(paramName)){
                        String status = paramValue;
                        int play_status = Integer.parseInt(status);
                        play.setPlay_status(play_status);
                    }

                    if("play_actor".equals(paramName)){
                        String actor = paramValue;
                        play.setPlay_actor(actor);
                    }

                    if("play_up_time".equals(paramName)){
                        String uptime = paramValue;
                        play.setPlay_up_time(uptime);
                    }
                    if("play_down_time".equals(paramName)){
                        String downtime = paramValue;
                        play.setPlay_down_time(downtime);
                    }
                    if("play_orign".equals(paramName)){
                        String orign = paramValue;
                        play.setPlay_orign(orign);

                    }
                    if("play_director".equals(paramName)){
                        String director = paramValue;
                        play.setPlay_director(director);
                    }
                }else{

                    Long size = fileItem.getSize();
                    String fileName = fileItem.getName();
                    String load = request.getServletContext().getRealPath("/");
                    load += "statics/picture/";
                    System.out.println(load);
                    File file = new File(load+fileName);
                    fileItem.write(file);
                    play.setPlay_image("/picture/"+fileName);
                }

            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        playDAO.insertPlay(play);
        errors = "添加成功！";
        return errors;
    }

    @Override
    public String updatePlay(HttpServletRequest request) {
        String paramName = "";
        String paramValue = "";
        String errors = "";
        Play play = new Play();


        //创建对象
        DiskFileItemFactory dff = new DiskFileItemFactory();
        //指定在内存中缓存数据的大小
        dff.setSizeThreshold(1024000);
        //创建上传对象
        ServletFileUpload sfu = new ServletFileUpload(dff);
        //指定单个上传文件的最大尺寸
        sfu.setFileSizeMax(1024*1024*2);

        System.out.println("wsx");
        try {
            List<FileItem> uploaditems = sfu.parseRequest(request);

            String id = request.getParameter("id");
            int play_id = Integer.parseInt(id);
            Play play2 = playDAO.selectPlayByPlay_id(play_id);
            play.setPlay_id(play_id);

            for (FileItem fileItem : uploaditems) {

                paramName = fileItem.getFieldName();


                if (fileItem.isFormField()) {

                    paramValue = new String(fileItem.getString().getBytes("ISO-8859-1"), "UTF-8");

                    if ("play_name".equals(paramName)) {


                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String name = play2.getPlay_name();
                            play.setPlay_name(name);
                        } else {

                            Play play1 = playDAO.selectPlayByPlay_name(paramValue);
                            if (play1 == null) {

                                errors = "该影片不存在！";
                                return errors;
                            }
                            play.setPlay_name(paramValue);
                        }
                    }


                    if ("play_type".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String type = play2.getPlay_type();
                            play.setPlay_type(type);
                        } else {

                            play.setPlay_type(paramValue);
                        }
                    }

                    if ("play_lang".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String lang = play2.getPlay_lang();
                            play.setPlay_lang(lang);
                        } else {
                            play.setPlay_lang(paramValue);
                        }
                    }

                    if ("play_introduction".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String introduction = play2.getPlay_introduction();
                            play.setPlay_introduction(introduction);
                        } else {
                            play.setPlay_introduction(paramValue);
                        }
                    }


                    if ("play_length".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            int length = play2.getPlay_length();
                            play.setPlay_length(length);

                        } else {

                            int play_length = Integer.parseInt(paramValue);
                            play.setPlay_length(play_length);

                        }
                    }

                    if ("play_price".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            double price = play2.getPlay_ticket_price();
                            play.setPlay_ticket_price(price);
                        } else {

                            double play_ticket_price = Double.parseDouble(paramValue);
                            play.setPlay_ticket_price(play_ticket_price);

                        }


                    }

                    if ("play_actor".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String actor = play2.getPlay_actor();
                            play.setPlay_actor(actor);

                        } else {

                            String actor = paramValue;
                            play.setPlay_actor(actor);
                        }
                    }
                    if ("play_up_time".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String status = play2.getPlay_up_time();
                            play.setPlay_up_time(status);
                        } else {

                            String uptime = paramValue;
                            play.setPlay_up_time(uptime);
                        }
                    }
                    if ("play_down_time".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String down = play2.getPlay_down_time();
                            play.setPlay_down_time(down);
                        } else {

                            String down = paramValue;
                            play.setPlay_down_time(down);
                        }
                    }
                    if ("play_orign".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String playOrign = play2.getPlay_orign();
                            play.setPlay_orign(playOrign);
                        } else {

                            String playOrign = paramValue;
                            play.setPlay_orign(playOrign);
                        }
                    }
                    if ("play_director".equals(paramName)) {

                        if (paramValue == null || paramValue.trim().length() <= 0) {

                            String director = play2.getPlay_director();
                            System.out.print(director);
                            play.setPlay_director(director);
                        } else {

                            String director = paramValue;
                            play.setPlay_director(director);
                        }
                    }

                } else {

                    Long size = fileItem.getSize();
                    String fileName = fileItem.getName();
                    if (fileName == null || fileName.trim().length() <= 0) {

                        String image = play2.getPlay_image();
                        play.setPlay_image(image);
                    } else {
                        String load = request.getServletContext().getRealPath("/");
                        load += "statics/picture/";
                        File file = new File(load + fileName);
                        fileItem.write(file);
                        play.setPlay_image("/picture/" + fileName);
                    }

                }
            }
        }catch (FileUploadException e) {
            e.printStackTrace();
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        playDAO.updatePlay(play);
        errors = "更新成功！";
        return errors;
    }

}
