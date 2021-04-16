package com.koiwaLearning.api.controller;

import com.koiwaLearning.api.domain.StudentsInfo;
import com.koiwaLearning.api.service.StudentsService;

import io.micrometer.core.instrument.search.Search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    private StudentsService studentsService;

    /**
     * 查询学生
     */
    @RequestMapping(value = "/getStudentsInfo", method = RequestMethod.GET)
    public ModelAndView getStudentsInfo(Model model) {
        model.addAttribute("studentList",studentsService.getStudentsInfo());
        model.addAttribute("title", "学生信息");
        return new ModelAndView("students/studentsInfoSelect","studentModel",model);
    }
    
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public StudentsInfo Search(@RequestParam("sid") String sid) {
		StudentsInfo student = studentsService.search(sid);
    	System.out.println(student.getName());
		return student;
    }

    /**
     * 获取创建表单页面
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView createForm(Model model) {
        model.addAttribute("student",new StudentsInfo());
        model.addAttribute("title", "创建学生");
        return new ModelAndView("students/studentsInfoInsert","studentModel",model);
    }

    /**
     * 新增学生
     */
    @RequestMapping(value = "/insertStudent", method = RequestMethod.POST)
    public ModelAndView insertStudentsInfo(StudentsInfo studentsInfo) {
        studentsService.insertStudents(studentsInfo);
        //重定向到查询页面
        return new ModelAndView("redirect:/students/getStudentsInfo");
    }


}
