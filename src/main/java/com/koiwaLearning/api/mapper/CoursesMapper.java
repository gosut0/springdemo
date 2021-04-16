package com.koiwaLearning.api.mapper;

import com.koiwaLearning.api.domain.CoursesInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesMapper {
    // 查询
    List<CoursesInfo> getCoursesInfo();

    // 追加
    int insertCourses(CoursesInfo courses);

    // 更新
    int updateCourses(CoursesInfo courses);

    // 削除
    int deleteCourses(String cid);
}
