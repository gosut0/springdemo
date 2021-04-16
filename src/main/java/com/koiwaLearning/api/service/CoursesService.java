package com.koiwaLearning.api.service;

import com.koiwaLearning.api.domain.CoursesInfo;
import com.koiwaLearning.api.mapper.CoursesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {

    @Autowired
    private CoursesMapper coursesMapper;

    public List<CoursesInfo> getCoursesInfo() {
        return coursesMapper.getCoursesInfo();
    }

    // 追加
    public int insertCourses(CoursesInfo course) {
        return coursesMapper.insertCourses(course);
    }

    // 更新
    public int updateCourses(CoursesInfo course) {
        return coursesMapper.updateCourses(course);
    }
    // 削除
    public int deleteCourses(String cid) {
        return coursesMapper.deleteCourses(cid);
    }
}
