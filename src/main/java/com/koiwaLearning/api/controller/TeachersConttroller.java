package com.koiwaLearning.api.controller;

import com.koiwaLearning.api.domain.TeachersInfo;
import com.koiwaLearning.api.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/teachers")
public class TeachersConttroller {

    @Autowired
    private TeachersService teachersService;

    /**
     * 查询
     */
    @RequestMapping(value = "/getTeachersInfo", method = RequestMethod.GET)
    public ModelAndView getTeachersInfo(Model model) {
    	System.out.println(11111);
        model.addAttribute("teacherList",teachersService.getTeachersInfo());
        model.addAttribute("title", "教师");
        System.out.println("查询成功：" + teachersService.getTeachersInfo().size());
        System.out.println("查询成功：" + teachersService.getTeachersInfo().toString());
        return new ModelAndView("teachers/teachersInfoSelect","teacherModel",model);
    }

    /**
     * 获取创建表单页面
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView createForm(Model model) {
        model.addAttribute("teacher",new TeachersInfo());
        model.addAttribute("title", "Creat");
        return new ModelAndView("teachers/teachersInfoInsert","teacherModel",model);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/insertTeacher", method = RequestMethod.POST)
    public ModelAndView insertTeachersInfo(TeachersInfo teachersInfo) {
        teachersService.insertTeachers(teachersInfo);
        //重定向到查询页面
        return new ModelAndView("redirect:/teachers/getTeachersInfo");
    }


}
