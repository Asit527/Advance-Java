package com.amazon.controller;

import com.amazon.model.UserRequest;
import com.amazon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // 1. Show Pages Links
    @GetMapping("/signup")
    public String showSignup() { return "signup"; }

    @GetMapping("/login")
    public String showLogin() { return "login"; }

    @GetMapping("/reset")
    public String showReset() { return "reset"; }

    // 2. Handle Signup Form Submissions (@ModelAttribute)
    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute UserRequest user, Model model) {
        boolean success = userService.register(user);
        if (success) {
            model.addAttribute("msg", "Registration Successful");
            return "login"; // Redirect to login page on success
        }
        model.addAttribute("error", "Email already registered!");
        return "signup";
    }

    // 3. Handle Login Form Submissions (@RequestParam)
    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String email, @RequestParam String password, Model model) {
        UserRequest user = userService.login(email, password);
        if (user != null) {
            model.addAttribute("name", user.getName());
            return "welcome";
        }
        model.addAttribute("error", "Invalid Credentials!");
        return "login";
    }

    // 4. Handle Password Reset Submissions (@RequestParam)
    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email, @RequestParam String newPassword, Model model) {
        boolean success = userService.resetPassword(email, newPassword);
        if (success) {
            model.addAttribute("msg", "Password Updated Successfully");
            return "login";
        }
        model.addAttribute("error", "Email not found!");
        return "reset";
    }
}