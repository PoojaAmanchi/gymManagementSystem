/*package com.GymInfo.gymManagementSystem.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GymInfo.gymManagementSystem.service.EmailService;
import com.GymInfo.gymManagementSystem.service.UserService;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService; // Your user service interface or class

    @Autowired
    private EmailService emailService; // Your email service interface or class

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password"; // JSP page for the forgot password form
    }

    @PostMapping("/forgot-password")
    public String processForgotPassword(@RequestParam("email") String email, HttpServletRequest request, Model model) {
        User user = userService.findByEmail(email);

        if (user != null) {
            // Generate and save password reset token
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user, token);

            // Build reset URL
            String resetUrl = getResetPasswordUrl(request, user, token);

            // Send email with reset link
            String emailSubject = "Password Reset Request";
            String emailContent = "Please click the link below to reset your password:\n" + resetUrl;
            emailService.sendEmail(email, emailSubject, emailContent);

            model.addAttribute("message", "Password reset instructions sent to your email.");
        } else {
            // User not found with the provided email
            model.addAttribute("errorMessage", "User not found with the provided email.");
        }

        return "forgot-password"; // Return to the forgot password form with messages
    }

    private String getResetPasswordUrl(HttpServletRequest request, User user, String token) {
        String appUrl = request.getRequestURL().toString().replace(request.getRequestURI(), request.getContextPath());
        return appUrl + "/reset-password?token=" + token;
    }
}*/