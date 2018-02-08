<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Human Resource Management System (HRMS)</title>

        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
        <style type="text/css">
            .zform_row{padding:0px 0px 15px 15px; min-height:70px;}
            .zform .col1{width:25%; float:left;}
            .zform .col2{width:75%; float:right;}

        </style>
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
                    <li><a href="employee.do">Employee Home</a></li>
                    <li><a href="apply_for_leave.do">Request for leave</a></li>
                    <li><a href="view_leave_history.do">My approved leave history</a></li>
                    

                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_leave_rule">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                            <li><a href="employee.do">Employee Home</a></li>
                            <li><a href="apply_for_leave.do">Request for leave</a></li>
                            <li><a href="view_leave_history.do">My approved leave history</a></li>
                            <li><a href="leave_rules.do">Leave rules</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Leave rules</h3></div>
                    <div class="form">
                        <div class="form_row">
                            <div class="col1"><u>Leave types</u></div>
                            <div class="col2"><u>Description</u></div>
                        </div>
                        <c:forEach items="${leaveTList}" var="emp">
                            <div class="zform_row" style="color:brown;">
                                <div class="col1"><b>${emp.getLeaveType()}:</b></div>
                            <div class="col2">${emp.getLeaveDesc()}</div>
                        </div>
                        </c:forEach>
                        

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