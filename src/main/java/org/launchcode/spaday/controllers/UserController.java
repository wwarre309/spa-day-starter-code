package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute(new User());
        return "/user/add";
    }
    @PostMapping("add")
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model, String verify ) {


        if (errors.hasErrors()) {
            model.addAttribute("title","Add User");
            return "/user/add";
        }
        if (user.getPassword().equals(verify)) {
            new User(user);
            return "user/index";
        } else {
            model.addAttribute("wrongPassword", "Your passwords must match");
            return "user/add";
        }


    }
}
