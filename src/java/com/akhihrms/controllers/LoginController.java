package com.akhihrms.controllers;

import com.akhihrms.model.LoginModel;
import com.akhihrms.service.LoginService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    //Creating the loginmodel object.
    private LoginModel loginModel;

    @Autowired
    private LoginService loginService;

    /**
     * This method will load the login.jsp page when the application starts
     */
    @RequestMapping(method = RequestMethod.GET)
    public String init(Model model) {
        loginModel = new LoginModel();
        model.addAttribute("loginDetails", loginModel);
        return "login";
    }

    /**
     * This method will be called when the user submits the login details from
     * login.jsp page. If there is any error it will be displayed on the same
     * page, if the user is valid then, will be redirected to success page.
     *
     * @param loginModel
     * @param bindingResult
     * @param model
     * @param modelMap
     * @param session
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("loginDetails") LoginModel loginModel, BindingResult bindingResult,
            Model model, ModelMap modelMap, HttpSession session) {

        try {

            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "userName", "userName", "Username can not be empty.");
            ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "password", "password", "Password not be empty");

            if (bindingResult.hasErrors()) {
                //returning the errors on same page if any errors..
                return "login";
            } else {
                // If the user details is validated then redirecting the user to success page, 
                // else returning the error message on login page.

                if (loginService.validate(loginModel).equals("admin")) {

                    session.setAttribute("user", loginModel.getUserName());

                    return "admin";
                } else if (loginService.validate(loginModel).equals("employee")) {
                    session.setAttribute("user", loginModel.getUserName());
                    model.addAttribute("employeeSession", session.getAttribute("user"));
                    return "employee";
                } else if (loginService.validate(loginModel).equals("chairman")) {
                    session.setAttribute("user", loginModel.getUserName());
                    return "chairman";
                } else {
                    bindingResult.addError(new ObjectError("Invalid", "Incorrect details. "
                            + "Username or Password is incorrect."));
                    //return new ModelAndView("login", "loginDetails", loginModel);
                    return "login";
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in LoginController " + e.getMessage());
            e.printStackTrace();
            return "login";
        }
    }
}
