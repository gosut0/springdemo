package com.koiwaLearning.api.controller;

import com.koiwaLearning.api.service.ScoresService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/other")
public class ScoresController {

    @Autowired
    private ScoresService scoresService;

    /**
     * 查询课程
     */
    @RequestMapping(value = "/scores", method = RequestMethod.GET)
    public ModelAndView getScoresInfo(Model model) {
        model.addAttribute("scoreList",scoresService.getScoresInfo());
        model.addAttribute("title", "分数");
        System.out.println(":::::::"+scoresService.getScoresInfo().size());
        return new ModelAndView("other/other2","scoreModel",model);
    }
}
