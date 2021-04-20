package com.koiwaLearning.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.koiwaLearning.api.domain.TeachersInfo;
import com.koiwaLearning.api.mapper.TeachersMapper;

@Service
public class TeachersService {

    @Autowired
    private TeachersMapper teachersMapper;

    public List<TeachersInfo> getTeachersInfo() {
        return teachersMapper.getTeachersInfo();
    }
    
    public TeachersInfo searchTeacher(String tid) {
		return teachersMapper.searchTeacher(tid);
	}

    // 追加
    public int insertTeachers(TeachersInfo teachers) {
        return teachersMapper.insertTeachers(teachers);
    }

    // 更新
    public int updateTeachers(String teachers) {
        return teachersMapper.updateTeachers(teachers);
    }
    // 削除
    public int deleteTeachers(String tno) {
        return teachersMapper.deleteTeachers(tno);
    }


}
