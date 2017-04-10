package ru.arssam.mvctest.controller;

import org.springframework.web.bind.annotation.*;
import ru.arssam.mvctest.model.User;
import ru.arssam.mvctest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class UserController {
    private UserService userService;
    private int pageSize = 5;
    private Integer offset;
    private Integer lastPageNumber;

    @Autowired
    @Qualifier(value = "userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)

    public String listUsers(@RequestAttribute(value = "page", required = false) Integer page, Model model){
        if (page == null) page = 1;
        offset = (page - 1) * pageSize;
        lastPageNumber = userService.count() / pageSize;
        if (userService.count() % pageSize != 0) lastPageNumber++;

        model.addAttribute("user", new User());
        model.addAttribute("lastPage", lastPageNumber);
        model.addAttribute("listUsers", userService.listUsers(offset, pageSize));

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
        model.addAttribute("users", userService.getUsersByName(user.getName()));

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
        model.addAttribute("listUsers", userService.listUsers(0, pageSize));

        return "users";
    }
}
