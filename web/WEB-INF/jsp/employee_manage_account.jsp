<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Human Resource Management System (HRMS)</title>

        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
        <script type="text/javascript">

            function comparePasswords() {
                var value1;
                var value2;
                value1 = document.getElementById("enter_password").value;
                value2 = document.getElementById("confirm_password").value;
                if (value1!==value2) {
                    alert('Enter the same passoword!');
                    
                }

            }


        </script> 
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
            <div class="body_home">
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
                    <div class="link_div"><h3>Change Password</h3></div>
                    <div class="form">
                        <form:form id="change_password" action="employee_manage_account.do" method="post" commandName="changePassword">
                            <div class="form_row"><font color="red"><b>${passSuccess}${errorSuccess} ${notSamepass}</b></font></div>
                            <div class="form_row">
                            <div class="col1">Enter new password:</div>
                            <div class="col2"><form:input path="enterPassword" type="text"  required="true"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Confirm password:</div>
                            <div class="col2"><form:input path="confirmPassoword" type="text" required="true"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1"></div>
                            <div class="col2"><input type="submit" value="Change Password"/></div>
                        </div>
                        </form:form>
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