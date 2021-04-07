package by.tms.calculatorthymeleaf.controller;

import by.tms.calculatorthymeleaf.model.User;
import by.tms.calculatorthymeleaf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public ModelAndView getRegistrationPage(ModelAndView modelAndView) {
        modelAndView.addObject("userForm", new User());
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/registration")
    public ModelAndView addUser(@ModelAttribute("userForm") @Valid User user, BindingResult bindingResult, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        if (!userService.saveUser(user)) {
            modelAndView.addObject("userExistsError", "User with such username already exists!");
            modelAndView.setViewName("registration");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }


}

