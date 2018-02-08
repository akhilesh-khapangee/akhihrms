package com.akhihrms.controllers;

import com.akhihrms.model.LoginModel;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Akhilesh
 */
@Controller
public class LogoutController {

    @RequestMapping(value = "/logout")
    public String logout(Model model, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.invalidate();
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logOut", "Successfully logged out.");
            return "login";
        } else {
            model.addAttribute("nLogout", "Error! in Log in!");
            return "login";
        }

    }

}
