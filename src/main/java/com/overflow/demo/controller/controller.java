package com.overflow.demo.controller;

import com.overflow.demo.models.GetForm;
import com.overflow.demo.service.ManyToMService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class controller {
   private final ManyToMService manyToMService;

    public controller(ManyToMService manyToMService) {
        this.manyToMService = manyToMService;
    }
    @RequestMapping("questions/new")
    public String showFormQuestion(@ModelAttribute("getForm")GetForm getForm){
        return "new.jsp";
    }

    @RequestMapping(value = "questions/new" ,method = RequestMethod.POST)
    public String addQuestion(@Valid @ModelAttribute("getForm") GetForm getForm, BindingResult result){
        if (result.hasErrors()){
            return "new.jsp";
        }
        manyToMService.addTagsToQuestions(getForm.getQuestion(),getForm.tags());
        return "redirct:/new";


    }






}
