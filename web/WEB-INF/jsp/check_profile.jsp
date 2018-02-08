<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
    </head>

    <body>

        <!--============================HEADER=======================-->
        <header class="header">
            <img src="images/logo.png" class="logo"/>
            <div class="logout">
                <span><a href="logout.do">Logout</a></span>
            </div>
            <nav class="nav">
                <ul>
                    <li><a href="chairman.do">Chairman Home</a></li>
                    <li><a href="chairman_view_leave_requests.do">View all leave requests</a></li>
                    <li><a href="chairman_approveds.do">View approved only</a></li>
                    <li><a href="chairman_rejecteds.do">View rejected only</a></li>
                   
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_add_employee">
                <div class="admin_is_container">
                    <div class="link_div"><h3>Full Employee Profile of: <font color="yellow">${firstName} ${lastName}</font></h3></div>
                    <div class="form">
                            <div style="width:100%;"> <font color="red"><b>${successEdit}</b></font></div>
                           
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Emp. Id</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${empId}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>First Name</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${firstName}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Last Name</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${lastName}"/></label></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Gender</b></div>
                                <div class="add_employee_col2">
                                <input disabled="disabled" value="${gender}"/>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Department</b></div>
                                <div class="add_employee_col2">
                                   <input disabled="disabled" value="${department}"/>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Designation</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${designation}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Joined Date</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${joinDate}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Job status</b></div>
                                <div class="add_employee_col2">

                                   <input disabled="disabled" value="${jobStatus}"/>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Qualification</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${qualification}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Cell no.</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${cellNo}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Residence contact</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${residenceContact}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Email ID</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${emailId}"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Address</b></div>
                                <div class="add_employee_col2"><input disabled="disabled" value="${address}"></div>
                            </div>
                            
                            
                       
                    </div><!--end of form div-->
                </div>
            </div>
        </div>
        <!--footer-->
        <div class="footer">

            <div class="FBG">
                <div class="footer_resize">       
                    <p class="leftt"><span class="footer_headers">Human Resource Managment System (HRMS)</span><br />
                        &copy; Designed and Developed By Akhilesh Khapangee</p>
                    <div class="clr"></div>
                </div>
            </div>
        </div>

    </body>
</html>