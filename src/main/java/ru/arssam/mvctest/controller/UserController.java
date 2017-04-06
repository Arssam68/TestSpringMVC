package ru.arssam.mvctest.controller;

import ru.arssam.mvctest.model.User;
import ru.arssam.mvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    @Qualifier(value = "userService")
    public void setBookService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    public String listBooks(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.listUsers());

        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            userService.addUser(user);
        }else {
            userService.updateUser(user);
        }

        return "redirect:/users";
    }

    @RequestMapping(value = "/users/find", method = RequestMethod.POST)
    public String findUser(@ModelAttribute("user") User user, Model model){
        model.addAttribute("user", userService.getUserByName(user.getName()));

        return "userdata";
    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") int id){
        userService.removeUser(id);

        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("listUsers", userService.listUsers());

        return "users";
    }

    @RequestMapping("userdata/{id}")
    public String userData(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.getUserById(id));

        return "userdata";
    }
}
