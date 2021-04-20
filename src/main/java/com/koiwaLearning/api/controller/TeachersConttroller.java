package com.koiwaLearning.api.controller;

import com.koiwaLearning.api.domain.TeachersInfo;
import com.koiwaLearning.api.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
        model.addAttribute("teacherList",teachersService.getTeachersInfo());
        model.addAttribute("title", "教师");
        return new ModelAndView("teachers/teachersInfoSelect","teacherModel",model);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public TeachersInfo searchTeacher(@RequestParam("tid") String tid) {
    	System.out.println(teachersService.searchTeacher(tid).getTid());
    	return teachersService.searchTeacher(tid);
    }
    
    /**
     * 获取创建表单页面
     */
    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public ModelAndView createForm(Model model) {
    	System.out.println(111);
    	model.addAttribute("title", "Creat");
        model.addAttribute("teacher",new TeachersInfo());
        System.out.println(222);
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
    
    
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView updateTeachersInfo(@RequestBody @RequestParam("tname") String tname) {
    	System.out.println(tname);
        teachersService.updateTeachers(tname);
        //重定向到查询页面
        return new ModelAndView("redirect:/teachers/getTeachersInfo");
    } 
    
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ModelAndView deleteTeacher(@RequestBody @RequestParam("tid") String tid) {
    	System.out.println(tid);
    	teachersService.deleteTeachers(tid);
    	return new ModelAndView("redirect:/teachers/getTeachersInfo");    
    }

}
