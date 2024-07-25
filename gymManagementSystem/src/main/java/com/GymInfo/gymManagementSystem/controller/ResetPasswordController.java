/*package com.GymInfo.gymManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.GymInfo.gymManagementSystem.bean.GymUser;
import com.GymInfo.gymManagementSystem.service.PasswordResetToken;
import com.GymInfo.gymManagementSystem.service.UserService;

@Controller
public class ResetPasswordController {

    @Autowired
    private UserService userService; // Your user service interface or class

    @GetMapping("/reset-password")
    public String showResetPasswordForm(@RequestParam("token") String token, Model model) {
        PasswordResetToken resetToken = userService.getPasswordResetToken(token);

        if (resetToken == null || resetToken.isExpired()) {
            model.addAttribute("errorMessage", "Invalid or expired reset link. Please try again.");
            return "redirect:/forgot-password";
        }

        // Store token in model to use in form submission
        model.addAttribute("token", token);
        return "reset-password"; // JSP page for the reset password form
    }

    @PostMapping("/reset-password")
    public String processResetPassword(@RequestParam("token") String token,
                                       @RequestParam("password") String newPassword,
                                       Model model) {
        PasswordResetToken resetToken = userService.getPasswordResetToken(token);

        if (resetToken == null || resetToken.isExpired()) {
            model.addAttribute("errorMessage", "Invalid or expired reset link. Please try again.");
            return "redirect:/forgot-password";
        }

        // Update user password
        GymUser user = resetToken.getUser();
        userService.updatePassword(user, newPassword);

        // Delete used token from database
        userService.deletePasswordResetToken(token);

        model.addAttribute("message", "Password successfully reset. You can now log in with your new password.");
        return "redirect:/login"; // Redirect to login page or any other page
    }
}
*/