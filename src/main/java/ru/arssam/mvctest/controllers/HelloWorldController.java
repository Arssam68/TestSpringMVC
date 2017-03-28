package ru.arssam.mvctest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.arssam.mvctest.User;

@Controller
public class HelloWorldController{
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView user() {
        return new ModelAndView("/user", "command", new User());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("mvc-dispatcher") User user,
                             ModelMap model) {
        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("speciality", user.getSpecialty());
        model.addAttribute("experience", user.getExperience());

        return "result";
    }
}
