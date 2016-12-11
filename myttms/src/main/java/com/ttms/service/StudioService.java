package com.ttms.service;

import com.ttms.entity.Studio;

import java.util.List;

/**
 * Created by hjh on 16-12-5.
 */
public interface StudioService {

    public void insertStudio(Studio studio);
    public void deleteStudio(int studio_id);
    public void updateStudio(Studio studio);

    public Studio selectStudioByStudio_id(int studio_id);
    public Studio selectStudioByStudio_name(String studio_name);
    public List<Studio> selectStudioByStudio_flag(int studio_flag);
    public List<Studio> selectStudio();
    public String addStudio(String studio_name, String studio_row_count, String studio_col_count,
                          String studio_flag, String studio_introduction);
    public String updateStudio(String studio_name, String studio_row_count, String studio_col_count,
                          String studio_flag, String studio_introduction);

    public List<Studio> selectSpecialStudio(int studio_id);


}
