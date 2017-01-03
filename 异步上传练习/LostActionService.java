package com.web.service;

import com.web.entity.Lostmess;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

/**
 * Created by shiyi on 2016/12/19.
 */
public interface LostActionService {

    //获取寻人启事数
    public int getLostMessCount();

    //获取寻人信息
    public List getLostMess(int start, int num);

    public Lostmess getLostMessById(int id);

    public Lostmess getLostMessByName(String name);


    public ServletFileUpload getFileData();


    public String uploadLostMess(List<FileItem> uploaditems, String path);

    public boolean addLostMess(String name, int sex, int height, String birthady, String native_place,
                               int blood_type, String lost_place, String lost_date, String picture_list,
                               String feature, int find_type, String other_message, int user_id);
}
