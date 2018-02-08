package com.akhihrms.controllers;

import com.akhihrms.dao.ManageAccount;
import com.akhihrms.dao.ViewEmployeeProfile;
import com.akhihrms.model.ChairmanModel;
import com.akhihrms.model.DeleteEmployeeModel;
import com.akhihrms.model.EditEmployeeProfileModel;
import com.akhihrms.model.EmployeeInfoModel;
import com.akhihrms.model.EmployeeLeaveModel;
import com.akhihrms.model.LoginModel;
import com.akhihrms.service.EmployeeInfoService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService addEmpService;

    @RequestMapping(value = "/admin_setup", method = RequestMethod.GET)
    public String adminSetup(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                //creaing department list
                List<EmployeeInfoModel> departList = new ArrayList<>();
                departList = empModel.getDepartmentList();
                model.addAttribute("departList", departList);

                //creaing designation list
                List<EmployeeInfoModel> desigList = new ArrayList<>();
                desigList = empModel.getDesignationList();
                model.addAttribute("desigList", desigList);

                model.addAttribute("adminSetup1", empModel);
                model.addAttribute("adminSetup2", empModel);
                return "/admin_setup";

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

    @RequestMapping(value = "/delete_depart", method = RequestMethod.GET)
    public String deleteDepart(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel, HttpServletRequest request) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                int id = Integer.parseInt(request.getParameter("id"));

                if (empModel.deleteDepartment(id)) {
                    model.addAttribute("deleteSucess","Successfully department deleted.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
                }else{
                     model.addAttribute("deleteError","Problem in deletion.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
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
    
    @RequestMapping(value = "/delete_desig", method = RequestMethod.GET)
    public String deleteDesig(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel, HttpServletRequest request) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                int id = Integer.parseInt(request.getParameter("id"));

                if (empModel.deleteDesignation(id)) {
                    model.addAttribute("deleteSucess","Successfully designation deleted.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
                }else{
                     model.addAttribute("deleteError","Problem in deletion.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
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

    @RequestMapping(value = "/admin_setup1", method = RequestMethod.POST)
    public String adminSetup1(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                if (empModel.createDepartmentName(empModel)) {
                    model.addAttribute("successAdminSetup", "Department successfully created.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
                } else {
                    model.addAttribute("errorAdminSetup", "Error in department creation.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
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

    @RequestMapping(value = "/admin_setup2", method = RequestMethod.POST)
    public String adminSetup2(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                if (empModel.createDesignation(empModel)) {
                    model.addAttribute("successAdminSetup", "Designation successfully created.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                     return adminSetup(model, modelMap, session, empModel);
                } else {
                    model.addAttribute("errorAdminSetup", "Error in designation creation.");
                    model.addAttribute("adminSetup1", empModel);
                    model.addAttribute("adminSetup2", empModel);
                    return adminSetup(model, modelMap, session, empModel);
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

    @RequestMapping(value = "/employee_is", method = RequestMethod.GET)
    public String employeeIs(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            System.out.println(roleOfCurrenUser + "roleOfCurrenUser");
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                return "employee_is";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/leave_home", method = RequestMethod.GET)
    public String leaveHome(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                return "leave_home";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/task_home", method = RequestMethod.GET)
    public String taskHome(Model model, HttpSession session, LoginModel loginModel) {

        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                return "task_home";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/employee_profile", method = RequestMethod.GET)
    public String employeeProfile(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();

            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {

                ViewEmployeeProfile viewEmpProfile = new ViewEmployeeProfile();

                List<EmployeeInfoModel> list = new ArrayList();
                list = viewEmpProfile.getEmployeeList(currentUser);

                model.addAttribute("empProfileList", list);
                for (EmployeeInfoModel obj : list) {
                    model.addAttribute("empId", obj.getEmpId());
                    model.addAttribute("firstName", obj.getFirstName());
                    model.addAttribute("lastName", obj.getLastName());
                    model.addAttribute("gender", obj.getGender());
                    model.addAttribute("department", obj.getDepartment());
                    model.addAttribute("designation", obj.getDesignation());
                    model.addAttribute("joinDate", obj.getJoinDate());
                    model.addAttribute("jobStatus", obj.getJobStatus());
                    model.addAttribute("qualification", obj.getQualification());
                    model.addAttribute("cellNo", obj.getCellNo());
                    model.addAttribute("residenceContact", obj.getResidenceContact());
                    model.addAttribute("emailId", obj.getEmailId());
                    model.addAttribute("address", obj.getAddress());
                }
                return "employee_profile";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String employeeUrl(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                return "employee";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/employee_manage_account", method = RequestMethod.GET)
    public String employeeManageAccount(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                model.addAttribute("changePassword", loginModel);
                return "/employee_manage_account";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/employee_manage_account", method = RequestMethod.POST)
    public String changePassword(Model model, HttpSession session, LoginModel loginModel) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                String userName = session.getAttribute("user").toString();
                if (loginModel.getConfirmPassoword().equals(loginModel.getEnterPassword())) {
                    ManageAccount ma = new ManageAccount();
                    if (ma.changePassword(loginModel, userName)) {
                        model.addAttribute("changePassword", loginModel);
                        model.addAttribute("passSuccess", "Password successfully changed.");
                        return "/employee_manage_account";
                    } else {
                        model.addAttribute("changePassword", loginModel);
                        model.addAttribute("errorSuccess", "Problem in password change.");
                        return "/employee_manage_account";
                    }
                } else {
                    model.addAttribute("changePassword", loginModel);
                    model.addAttribute("notSamepass", "Confirm password not same.");
                    return "/employee_manage_account";
                }

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
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

    @RequestMapping(value = "/apply_for_leave", method = RequestMethod.GET)
    public String applyForLeave(EmployeeInfoModel empModel, Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                String userName = session.getAttribute("user").toString();

                ViewEmployeeProfile viewFullprofile = new ViewEmployeeProfile();

                List<EmployeeInfoModel> list = new ArrayList();
                list = viewFullprofile.getEmployeeList(userName);

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

                EmployeeLeaveModel empLeaveModel = new EmployeeLeaveModel();

                List<EmployeeLeaveModel> lst = new ArrayList();
                lst = empLeaveModel.getLeaveTypeList();
                model.addAttribute("getLeaveTypeList", lst);

                model.addAttribute("applyForLeave", empModel);
                return "apply_for_leave";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }

    }

    @RequestMapping(value = "/apply_for_leave", method = RequestMethod.POST)
    public String applyForLeaveSubmit(EmployeeInfoModel emp, Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel) {

        if (session.getAttribute("user") != null) {
            EmployeeLeaveModel empLeave = new EmployeeLeaveModel();
            if (empLeave.insertLeaveRequest(emp)) {
                model.addAttribute("applyForLeave", emp);

                model.addAttribute("sccc", "Your leave request has been submitted.");

                return applyForLeave(emp, model, modelMap, session, loginModel);
            } else {
                model.addAttribute("errorleaveRequest", "Problem in leave request submission.");
                model.addAttribute("applyForLeave", emp);
                return applyForLeave(emp, model, modelMap, session, loginModel);
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }

    }

    @RequestMapping(value = "/view_leave_history", method = RequestMethod.GET)
    public String chairmanViewLeaveRequests(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel empModel) {

        String userName = session.getAttribute("user").toString();

        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                List<EmployeeLeaveModel> reqList = new ArrayList<>();
                reqList = empModel.getLeaveRequestByEmpId(userName);
                model.addAttribute("leaveRequestList", reqList);

                return "/view_leave_history";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }

    }

    @RequestMapping(value = "/leave_rules", method = RequestMethod.GET)
    public String leaveRulesUrl(Model model, ModelMap modelMap, HttpSession session,
            LoginModel loginModel, EmployeeLeaveModel emp) {

        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                List<EmployeeLeaveModel> leaveList = new ArrayList<>();
                leaveList = emp.getAllLeaveTypesAndRole();

                model.addAttribute("leaveTList", leaveList);

                return "leave_rules";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }

    }

    @RequestMapping(value = "/employee_my_tasks", method = RequestMethod.GET)
    public String employeemyTasks(Model model, LoginModel loginModel, HttpSession session,
            ChairmanModel chairModel) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                ChairmanModel obj1 = new ChairmanModel();
                List<ChairmanModel> myTaskList = new ArrayList<>();
                myTaskList = obj1.getMyTaskList(currentUser);

                //checking if the values are in list or not
                for (ChairmanModel obj : myTaskList) {
                    System.out.println(obj.getProjectDetailId() + "-->ID===");
                    System.out.println(obj.getProjectName() + "-->NAME===");
                    System.out.println(obj.getProjectTask() + "-->Task===");
                    System.out.println(obj.getAssignedEmployee() + "-->EMPloy====");
                    System.out.println(obj.getTaskDesc() + "==>AAKHILESH");
                }

                model.addAttribute("myAssignedTaskList", myTaskList);

                return "employee_my_tasks";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }
    }

    @RequestMapping(value = "/chairman_view_task_updates", method = RequestMethod.GET)
    public String chairmanViewTaskUpdates(Model model, LoginModel loginModel, HttpSession session,
            ChairmanModel chairModel) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("chairman")) {
                ChairmanModel obj1 = new ChairmanModel();
                List<ChairmanModel> myTaskList = new ArrayList<>();
                myTaskList = obj1.getAllTaskDetail();

                //checking if the values are in list or not
                for (ChairmanModel obj : myTaskList) {
                    System.out.println(obj.getProjectDetailId() + "-->ID===");
                    System.out.println(obj.getProjectName() + "-->NAME===");
                    System.out.println(obj.getProjectTask() + "-->Task===");
                    System.out.println(obj.getAssignedEmployee() + "-->EMPloy====");
                    System.out.println(obj.getTaskDesc() + "==>AAKHILESH");
                }

                model.addAttribute("myAssignedTaskList", myTaskList);

                return "chairman_view_task_updates";

            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("employeeHome", "Currently,you are logged in as employee.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }
    }

    @RequestMapping(value = "/employee_update_task", method = RequestMethod.GET)
    public String employeeUpdateTask(Model model, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                ChairmanModel obj1 = new ChairmanModel();

                //Getting project task details list
                List<ChairmanModel> myTaskList = new ArrayList<>();
                myTaskList = obj1.getMyTaskList(currentUser);
                model.addAttribute("myAssignedTaskList", myTaskList);

                return "employee_update_task";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }
    }

    @RequestMapping(value = "/update_task_progress", method = RequestMethod.GET)
    public String updateTaskProgress(Model model, LoginModel loginModel, HttpSession session,
            HttpServletRequest request) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();

            //Get clicked project task detail id
            int clickedId = Integer.parseInt(request.getParameter("id"));

            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                ChairmanModel obj1 = new ChairmanModel();

                //Getting task desc List
                List<ChairmanModel> taskUpdateList = new ArrayList<>();
                taskUpdateList = obj1.getClickedTaskDesc(obj1, clickedId);
                model.addAttribute("taskUpdateList", taskUpdateList);
                for (ChairmanModel chair : taskUpdateList) {
                    model.addAttribute("projectTaskId", chair.getProjectDetailId());
                    model.addAttribute("taskDescription", chair.getTaskDesc());
                }

                //Getting project task details list
                List<ChairmanModel> myTaskList = new ArrayList<>();
                myTaskList = obj1.getMyTaskList(currentUser);
                model.addAttribute("myAssignedTaskList", myTaskList);

                model.addAttribute("updateTaskDesc", obj1);
                return "employee_update_task";
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }
    }

    @RequestMapping(value = "update_task_progress.do", method = RequestMethod.POST)
    public String updateTaskProgressAction(Model model, LoginModel loginModel, HttpSession session,
            HttpServletRequest request) {

        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();

            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("employee")) {
                ChairmanModel obj1 = new ChairmanModel();

                //Updated task desc from form
                int hiddenProjectTaskId = Integer.parseInt(request.getParameter("hiddenProjectTaskId"));
                String updatedTaskDesc = request.getParameter("updatedTaskDesc");

                if (obj1.updateTaskProgress(hiddenProjectTaskId, updatedTaskDesc)) {
                    model.addAttribute("successUpdate", "You have successfully updated task progress.");
                    return employeemyTasks(model, loginModel, session, obj1);
                } else {
                    model.addAttribute("errorUpdate", "Error in task progress update.");
                    return employeemyTasks(model, loginModel, session, obj1);
                }
            } else if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                model.addAttribute("adminHome", "Currently, you are logged in as admin.");
                return "/admin";
            } else {
                model.addAttribute("chairmanHome", "Currently,you are logged in as chairman.");
                return "/chairman";
            }

        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "/login";
        }
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                return "admin";
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

    @RequestMapping(value = "/admin_is", method = RequestMethod.GET)
    public String adminIsUrl(Model model, ModelMap modelMap, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                ViewEmployeeProfile viewEmpProfile = new ViewEmployeeProfile();
                List<EmployeeInfoModel> list = new ArrayList();
                list = viewEmpProfile.getEmployeeList();
                modelMap.put("empProfile", list);
                return "/admin_is";

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

    //this method is to show the add_employee page
    @RequestMapping(value = "/admin_add_employee", method = RequestMethod.GET)
    public String addEmployeeUrl(Model model, ModelMap modelMap, HttpSession session,
            EmployeeInfoModel empModel) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                
                //creaing department list
                List<EmployeeInfoModel> departList = new ArrayList<>();
                departList = empModel.getDepartmentList();
                model.addAttribute("departList", departList);

                //creaing designation list
                List<EmployeeInfoModel> desigList = new ArrayList<>();
                desigList = empModel.getDesignationList();
                model.addAttribute("desigList", desigList);
                
                
                
                EmployeeInfoModel addEmpModel = new EmployeeInfoModel();
                model.addAttribute("addEmployee", addEmpModel);
                return "admin_add_employee";
                
                
                
                
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

    //this method is used when the sumbmit button is pressed
    @RequestMapping(value = "/admin_add_employee", method = RequestMethod.POST)
    public String addEmployees(Model model, ModelMap modelMap, EmployeeInfoModel addEmpModel,
            HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            try {
                if (addEmpService.insertEmployee(addEmpModel)) {
                    return adminIsUrl(model, modelMap, session);
                } else {
                    model.addAttribute("addEmployee", addEmpModel);
                    model.addAttribute("errorInEmployeeAdd", "Error in adding employee! Enter unique Emp. Id!");
                    return "admin_add_employee";
                }
            } catch (Exception e) {
                System.out.println("Exception in LoginController " + e.getMessage());
                e.printStackTrace();
                return "admin_add_employee";
            }
        } else {
            model.addAttribute("loginDetails", loginModel);
            model.addAttribute("logonMsg", "You have to login first...");
            return "login";
        }

    }

    @RequestMapping(value = "admin_delete_employee_profile", method = RequestMethod.GET)
    public String deleteEmployeeProfile(Model model, ModelMap modelMap,
            HttpServletRequest request, HttpSession session) {
        LoginModel loginModel = new LoginModel();
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                String empId = request.getParameter("id");
                DeleteEmployeeModel deleteEmployeeModel = new DeleteEmployeeModel();

                try {
                    if (deleteEmployeeModel.deleteEmployeeProfile(empId)) {
                        return adminIsUrl(model, modelMap, session);
                    }

                } catch (Exception e) {
                    System.out.println(e);
                    model.addAttribute("errorIndelete", "Error in delettion!");
                    return adminIsUrl(model, modelMap, session);
                }
                return adminIsUrl(model, modelMap, session);
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

    @RequestMapping(value = "admin_edit_employee_profile", method = RequestMethod.GET)
    public String editEmployeeProfile(Model model, ModelMap modelMap,
            HttpServletRequest request, EmployeeInfoModel empmodel, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {
            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                String empId = request.getParameter("id");
                EditEmployeeProfileModel editEmpProfileModel = new EditEmployeeProfileModel();

                List<EmployeeInfoModel> list = new ArrayList();
                list = editEmpProfileModel.getEmployeeProfile(empId);
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
                model.addAttribute("editEmployee", empmodel);
                return "admin_edit_employee_profile";

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

    @RequestMapping(value = "admin_edit_employee_profile", method = RequestMethod.POST)
    public String editEmployeeProfielPost(Model model, ModelMap modelMap, HttpServletRequest request, EmployeeInfoModel empModel
    ) {

        String empId = request.getParameter("id");
        System.out.println(empModel.getCellNo() + "____________");
        EditEmployeeProfileModel editEmpProfileModel = new EditEmployeeProfileModel();

        EmployeeInfoModel emp = new EmployeeInfoModel();

        emp.setEmpId(empModel.getEmpId());
        emp.setFirstName(empModel.getFirstName());
        emp.setLastName(empModel.getLastName());
        emp.setGender(empModel.getGender());
        emp.setDepartment(empModel.getDepartment());
        emp.setDesignation(empModel.getDesignation());
        emp.setJoinDate(empModel.getJoinDate());
        emp.setJobStatus(empModel.getJobStatus());
        emp.setQualification(empModel.getQualification());
        emp.setCellNo(empModel.getCellNo());
        emp.setResidenceContact(empModel.getResidenceContact());
        emp.setEmailId(empModel.getEmailId());
        emp.setAddress(empModel.getAddress());

        if (editEmpProfileModel.getEditEmployeeProfile(emp, empId)) {
            model.addAttribute("successEdit", "Edit Successfull!");
        }

        model.addAttribute("editEmployee", empModel);
        return "admin_edit_employee_profile";
    }

    @RequestMapping(value = "/admin_view_employee_profile", method = RequestMethod.GET)
    public String viewEmployeeProfile(Model model, ModelMap modelMap,
            HttpServletRequest request, HttpSession session, LoginModel loginModel) {
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {

                String empId = request.getParameter("id");
                model.addAttribute("empId", empId);
                ViewEmployeeProfile viewFullprofile = new ViewEmployeeProfile();
                viewFullprofile.getEmployeeFullProfile(empId);

                List<EmployeeInfoModel> list = new ArrayList();
                list = viewFullprofile.getEmployeeFullProfile(empId);
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
                return "admin_view_employee_profile";

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

    @RequestMapping(value = "admin_create_account", method = RequestMethod.GET)
    public String createAccountUrl(Model model, ModelMap modelMap, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                ViewEmployeeProfile viewEmpProfile = new ViewEmployeeProfile();

                List<EmployeeInfoModel> list = new ArrayList();

                list = viewEmpProfile.getEmployeeList();
                modelMap.put("userEmpIdList", list);
                model.addAttribute("createAccount", loginModel);
                return "admin_create_account";
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

    @RequestMapping(value = "admin_create_account", method = RequestMethod.POST)
    public String createAccount(Model model, ModelMap modelMap, LoginModel loginModel,
            HttpSession session) {
        model.addAttribute("createAccount", loginModel);
        ManageAccount ca = new ManageAccount();

        if (ca.createEmployeeAccount(loginModel)) {
            model.addAttribute("createSuccess", "Account successfully created");
            return createAccountUrl(model, modelMap, loginModel, session);
        } else {
            model.addAttribute("errorCreate", "Problem in account creation due to duplicate username or..");
            return createAccountUrl(model, modelMap, loginModel, session);
        }
    }

    @RequestMapping(value = "/admin_view_user_accounts", method = RequestMethod.GET)
    public String viewUserAccounts(Model model, ModelMap modelMap, LoginModel loginModel, HttpSession session) {
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                ManageAccount ma = new ManageAccount();

                List<LoginModel> list = new ArrayList();
                list = ma.getUserAccounts();

                modelMap.put("userAccountsList", list);
                return "/admin_view_user_accounts";
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

    @RequestMapping(value = "/admin_delete_user_account", method = RequestMethod.GET)
    public String deleteUserAccounts(Model model, ModelMap modelMap, LoginModel loginModel, HttpServletRequest request, HttpSession session) {
        if (session.getAttribute("user") != null) {

            String currentUser = session.getAttribute("user").toString();
            System.out.println(currentUser + "Current USer");
            String roleOfCurrenUser = loginModel.checkUserRole(currentUser);
            if (roleOfCurrenUser.equalsIgnoreCase("admin")) {
                String userName = request.getParameter("id");
                ManageAccount ma = new ManageAccount();

                if (ma.deleteUserAccount(userName)) {
                    model.addAttribute("userDelete", "User successfully deleted..");
                    return viewUserAccounts(model, modelMap, loginModel, session);
                } else {
                    model.addAttribute("errorDelete", "Problem in deleteion");
                    return "/admin_view_user_accounts";
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
