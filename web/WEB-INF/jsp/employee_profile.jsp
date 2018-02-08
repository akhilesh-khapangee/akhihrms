<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Human Resource Management System (HRMS)</title>
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
                    <li><a href="employee.do">Home</a></li>
                    <li><a href="employee_profile.do">Profile</a></li>
                    <li><a href="#">About us</a></li>

                </ul>
            </nav>
        </header>
        <div class="body_wrapper">
            <div class="body_employee_profile">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                            <li><a href="employee.do">Home</a></li>
                            <li><a href="employee_profile.do">View profile</a></li>
                            <li><a href="employee_manage_account.do">Manage Account setting</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Employee Profile</h3></div>
                    <div class="form">
                        <div class="form_row">
                            <div class="col1">Emp. ID</div>
                            <div class="col2">${empId}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">First Name</div>
                            <div class="col2">${firstName}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Last Name</div>
                            <div class="col2">${lastName}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Department</div>
                            <div class="col2">${department}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Designation</div>
                            <div class="col2">${designation}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Joined Date</div>
                            <div class="col2">${joinDate}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Job Status</div>
                            <div class="col2">${jobStatus}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Qualification</div>
                            <div class="col2">${qualification}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Cell no.</div>
                            <div class="col2">${cellNo}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Residence contact</div>
                            <div class="col2">${residenceContact}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Email ID</div>
                            <div class="col2">${emailId}</div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Address</div>
                            <div class="col2">${address}</div>
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