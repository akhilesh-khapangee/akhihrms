package com.akhihrms.controllers;

import com.akhihrms.model.EmployeeLeaveModel;
import com.akhihrms.model.LoginModel;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Akhilesh
 */
@Controller
public class EmployeeLeaveController {

    @RequestMapping(value = "/admin_leave_home", method = RequestMethod.GET)
    public String adminLeaveHomeUrl(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                return "/admin_leave_home";

            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/admin_view_leave_requests.do", method = RequestMethod.GET)
    public String adminViewLeaveRequests(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                return "/admin_view_leave_requests";
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/admin_add_new_leave_type", method = RequestMethod.GET)
    public String adminAddNewLeaveType(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                List<EmployeeLeaveModel> leaveList = new ArrayList<>();
                leaveList = emp.getLeaveTypeList();
                model.addAttribute("leaveList", leaveList);
                model.addAttribute("addLeaveType", emp);
                return "/admin_add_new_leave_type";
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/admin_add_new_leave_type_action", method = RequestMethod.POST)
    public String addLeaveType(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                if (emp.insertLeaveType(emp)) {
                    model.addAttribute("addLeaveType", emp);
                    model.addAttribute("success", "Successfully added.");
                    return adminAddNewLeaveType(model, modelMap, session, loginModel, emp);
                    //return "admin_add_new_leave_type";
                } else {
                    model.addAttribute("error", "Error.");
                    return adminAddNewLeaveType(model, modelMap, session, loginModel, emp);
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/delete_admin_add_new_leave_type", method = RequestMethod.GET)
    public String deleteLeaveType(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp, HttpServletRequest request) {
        int leaveTypeId = Integer.parseInt(request.getParameter("id"));
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                if (emp.deletetLeaveType(leaveTypeId)) {

                    model.addAttribute("addLeaveType", emp);
                    model.addAttribute("success", "Successfully deleted.");
                    return adminAddNewLeaveType(model, modelMap, session, loginModel, emp);
                    //return "admin_add_new_leave_type";
                } else {

                    return adminAddNewLeaveType(model, modelMap, session, loginModel, emp);
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/admin_view_leave_rule", method = RequestMethod.GET)
    public String adminViewLeaveRule(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp, HttpServletRequest request) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                int leaveTypeId = Integer.parseInt(request.getParameter("id"));

                if (session.getAttribute("user") != null) {
                    List<EmployeeLeaveModel> leaveList = new ArrayList<>();
                    leaveList = emp.getLeaveRule(leaveTypeId);

                    for (EmployeeLeaveModel obj : leaveList) {
                        model.addAttribute("leaveTypeName", obj.getLeaveType());
                        model.addAttribute("leaveRuleC", obj.getLeaveDesc());
                    }

                    model.addAttribute("addLeaveType", emp);
                    return adminAddNewLeaveType(model, modelMap, session, loginModel, emp);
                } else {
                    model.addAttribute("loginDetails", loginModel);
                    return "/login";
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

}
