package com.koiwaLearning.api.controller;

//import com.koiwaLearning.api.domain.CoursesInfo;
import com.koiwaLearning.api.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/other")
public class CoursesController {

    @Autowired
    private CoursesService coursesService;

    /**
     * 查询课程
     */
    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCoursesInfo(Model model) {
        model.addAttribute("courseList",coursesService.getCoursesInfo());
        model.addAttribute("title", "课程信息");
        model.addAttribute("syb", "0");
        System.out.println(""+coursesService.getCoursesInfo().toString());
        return new ModelAndView("other/other","courseModel",model);
    }
}
