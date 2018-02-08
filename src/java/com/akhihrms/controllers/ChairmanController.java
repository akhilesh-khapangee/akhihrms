package com.akhihrms.controllers;

import com.akhihrms.dao.ViewEmployeeProfile;
import com.akhihrms.model.ChairmanModel;
import com.akhihrms.model.EmployeeInfoModel;
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
 * @author samsung
 */
@Controller
public class ChairmanController {

    @RequestMapping(value = "/chairman_leave_home", method = RequestMethod.GET)
    public String adminLeaveHomeUrl(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                return "/chairman_leave_home";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman", method = RequestMethod.GET)
    public String chairmanHome(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                return "/chairman";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_view_leave_requests", method = RequestMethod.GET)
    public String chairmanViewLeaveRequests(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                List<EmployeeLeaveModel> reqList = new ArrayList<>();
                reqList = empModel.getLeaveRequests();
                model.addAttribute("leaveRequestList", reqList);
                for (EmployeeLeaveModel obj : reqList) {
                    System.out.println(obj.getLeaveEmpId() + "=========");
                }
                return "/chairman_view_leave_requests";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_approveds", method = RequestMethod.GET)
    public String approvedRequestsOnly(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                List<EmployeeLeaveModel> reqList = new ArrayList<>();
                reqList = empModel.getApprovedOnly();
                model.addAttribute("leaveRequestList", reqList);
                for (EmployeeLeaveModel obj : reqList) {
                    System.out.println(obj.getLeaveEmpId() + "=========");
                }
                return "/chairman_view_leave_requests";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_rejecteds", method = RequestMethod.GET)
    public String getRejectedLeaveRequests(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                List<EmployeeLeaveModel> reqList = new ArrayList<>();
                reqList = empModel.getDeclinedOnly();
                model.addAttribute("leaveRequestList", reqList);
                for (EmployeeLeaveModel obj : reqList) {
                    System.out.println(obj.getLeaveEmpId() + "=========");
                }
                return "/chairman_view_leave_requests";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/leave_approve", method = RequestMethod.GET)
    public String approveLeaveRequest(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel, HttpServletRequest request) {

        int leaveRequestId = Integer.parseInt(request.getParameter("id"));

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                if (empModel.approveLeaveRequest(leaveRequestId)) {

                    return chairmanViewLeaveRequests(model, modelMap, session, loginModel, empModel);
                } else {
                    return chairmanViewLeaveRequests(model, modelMap, session, loginModel, empModel);
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/leave_decline", method = RequestMethod.GET)
    public String declineLeaveRequest(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel, HttpServletRequest request) {

        int leaveRequestId = Integer.parseInt(request.getParameter("id"));

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                if (empModel.declineLeaveRequest(leaveRequestId)) {

                    return chairmanViewLeaveRequests(model, modelMap, session, loginModel, empModel);
                } else {
                    return chairmanViewLeaveRequests(model, modelMap, session, loginModel, empModel);
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/check_profile", method = RequestMethod.GET)
    public String viewEmployeeProfile(Model model, ModelMap modelMap,
            HttpServletRequest request, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                int id = Integer.parseInt(request.getParameter("id"));

                ViewEmployeeProfile viewFullprofile = new ViewEmployeeProfile();

                List<EmployeeInfoModel> list = new ArrayList();
                list = viewFullprofile.checkEmployeeProfileByChairman(id);
                for (EmployeeInfoModel obj : list) {
                    modelMap.put("empId", obj.getEmpId());
                    modelMap.put("firstName", obj.getFirstName());
                    modelMap.put("lastName", obj.getLastName());
                    modelMap.put("gender", obj.getGender());
                    modelMap.put("department", obj.getDepartment());
                    modelMap.put("designation", obj.getDesignation());
                    modelMap.put("joinDate", obj.getJoinDate());
                    modelMap.put("jobStatus", obj.getJobStatus());
                    modelMap.put("qualification", obj.getQualification());
                    modelMap.put("cellNo", obj.getCellNo());
                    modelMap.put("residenceContact", obj.getResidenceContact());
                    modelMap.put("emailId", obj.getEmailId());
                    modelMap.put("address", obj.getAddress());
                }

                return "check_profile";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }
        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/leave_reason", method = RequestMethod.GET)
    public String adminViewLeaveRule(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp, HttpServletRequest request) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                int leaveReqId = Integer.parseInt(request.getParameter("id"));

                if (session.getAttribute("user") != null) {
                    List<EmployeeLeaveModel> reqList = new ArrayList<>();
                    reqList = emp.getLeavePurposeForChairman(leaveReqId);

                    for (EmployeeLeaveModel obj : reqList) {
                        model.addAttribute("leaveEmpId", obj.getLeaveEmpId());
                        model.addAttribute("leavePurpose", obj.getLeavePurpose());
                    }

                    model.addAttribute("addLeaveType", emp);
                    return chairmanViewLeaveRequests(model, modelMap, session, loginModel, emp);
                } else {
                    model.addAttribute("loginDetails", loginModel);
                    return "/login";
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("employeeeHome", "Currently, you are logged in as employee.");
                return "/employee";
            } else {
                model.addAttribute("adminHome", "Currently,you are logged in as admin.");
                return "/admin";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_task_home", method = RequestMethod.GET)
    public String chairmanTaskHome(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                return "/chairman_task_home";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_create_projects", method = RequestMethod.GET)
    public String chairmanCreateProjects(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                List<ChairmanModel> projectList = new ArrayList<>();
                projectList = chairModel.getProjectList();

                model.addAttribute("projectList", projectList);
                model.addAttribute("createProjects", chairModel);
                return "/chairman_create_projects";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_create_projects", method = RequestMethod.POST)
    public String createProjects(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                if (chairModel.createProject(chairModel)) {
                    model.addAttribute("projectCreated", "Project successfully created.");
                    model.addAttribute("createProjects", chairModel);
                    return chairmanCreateProjects(model, modelMap, session, loginModel, chairModel);
                } else {
                    model.addAttribute("projectCreationError", "Problem in project creation. Project already started.");
                    model.addAttribute("createProjects", chairModel);
                    return chairmanCreateProjects(model, modelMap, session, loginModel, chairModel);
                }

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_create_tasks", method = RequestMethod.GET)
    public String chairmanCreateTasks(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                //for task list view
                List<ChairmanModel> taskList = new ArrayList<>();
                taskList = chairModel.getTaskList();
                model.addAttribute("taskList", taskList);
                model.addAttribute("createTasks", chairModel);
                return "/chairman_create_tasks";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_create_tasks", method = RequestMethod.POST)
    public String createTasks(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                if (chairModel.createProjectTask(chairModel)) {

                    model.addAttribute("createTasks", chairModel);
                    model.addAttribute("successTaskCreation", "Successfully task created.");
                    return chairmanCreateTasks(model, modelMap, session, loginModel, chairModel);
                } else {
                    model.addAttribute("createTasks", chairModel);
                    model.addAttribute("errorTaskCreation", "Problem in task creation. Duplicate task or..");
                    return chairmanCreateTasks(model, modelMap, session, loginModel, chairModel);
                }

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_assign_task", method = RequestMethod.GET)
    public String assignTasks(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                //For project list
                List<ChairmanModel> projectList = new ArrayList<>();
                projectList = chairModel.getProjectList();
                model.addAttribute("projectList", projectList);

                //For task list
                List<ChairmanModel> taskList = new ArrayList<>();
                taskList = chairModel.getTaskList();
                model.addAttribute("taskList", taskList);

                //For Employee list
                ViewEmployeeProfile viewEmpProfile = new ViewEmployeeProfile();
                List<EmployeeInfoModel> list = new ArrayList();
                list = viewEmpProfile.getEmployeeList();
                modelMap.put("userEmpIdList", list);
                

                //For project task details list
                List<ChairmanModel> projectTaskList = new ArrayList<>();
                projectTaskList = chairModel.getProjectTaskDetailList();
                model.addAttribute("projectTaskList", projectTaskList);

                model.addAttribute("assignTasks", chairModel);
                return "/chairman_assign_task";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "/chairman_assign_task", method = RequestMethod.POST)
    public String assignTaskToEmployee(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, ChairmanModel chairModel) {

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {

                if (chairModel.insertTaskAssignment(chairModel)) {

                    model.addAttribute("assignSuccess", "Task Assigned successfully.");
                    model.addAttribute("assignTasks", chairModel);
                    return assignTasks(model, modelMap, session, loginModel, chairModel);
                } else {
                    model.addAttribute("assignError", "Problem in task assignment.");
                    model.addAttribute("assignTasks", chairModel);
                    return assignTasks(model, modelMap, session, loginModel, chairModel);

                }

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeeHome", "Currently,you are logged in as employee.");
                return "/employee";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }
}
