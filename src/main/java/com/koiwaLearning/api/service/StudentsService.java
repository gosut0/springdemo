package com.koiwaLearning.api.service;

import com.koiwaLearning.api.domain.StudentsInfo;
import com.koiwaLearning.api.mapper.StudentsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsService {

    @Autowired
    private StudentsMapper studentsMapper;

    public List<StudentsInfo> getStudentsInfo() {
//    	System.out.print("server");
        return studentsMapper.getStudentsInfo();
    }

    // 追加
    public int insertStudents(StudentsInfo students) {
        return studentsMapper.insertStudents(students);
    }

    // 更新
    public int updateStudents(StudentsInfo students) {
        return studentsMapper.updateStudents(students);
    }
    // 削除
    public int deleteStudents(String sno) {
        return studentsMapper.deleteStudents(sno);
    }
}
