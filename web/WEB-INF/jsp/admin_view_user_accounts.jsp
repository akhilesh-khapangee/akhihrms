<%@page import="java.sql.*"%>
<%@page import="com.akhihrms.dao.ConnectionDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <li><a href="admin.do">Admin Home</a></li>
                    <li><a href="admin_add_employee.do">Add Employee</a></li>
                     <li><a href="admin_is.do">View Employees</a></li>
                    <li><a href="admin_view_user_accounts.do">User Accounts</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">${id}
            <div class="body_add_employee">
                <div class="admin_is_container">
                    <div class="link_div"><h3>User Accounts List:</h3></div>
                    <div class="form">
                        <div class="row_div">
                            <div style="width:15%;float:left;"><b>UserName</b></div>
                             <div style="width:15%;float:left;"><b>UserType</b></div>
                             <div style="width:15%;float:left;"><b>Emp. Id.</b></div>
                            <div style="width:45%;float:left;"><b>Delete Account</b></div>
                            
                            
                        </div>
                       
                      <c:forEach items="${userAccountsList}" var="emp">
                      <div class="row_div">
                            <div style="width:15%;float:left;">${emp.getEmpUserName()}</div>
                            <div style="width:15%;float:left;">${emp.getUserType()}</div>
                            <div style="width:15%;float:left;">${emp.getUserEmpId()}</div>
                            <div style="width:45%;float:left;"><a href="admin_delete_user_account.do?id=${emp.getEmpUserName()}">Delete</a></div>
                           
                            
                        </div>
                       </c:forEach>
                        <div class="row_div">
                            <div style="width:15%;float:left;"></div>
                            <div style="width:75%;float:left;"><a style="color:red" href="admin_create_account.do">Create Account</a></div>
                            
                            
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