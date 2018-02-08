<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
        <style type="text/css">
            .admin_is_container{width:100%;}

            .admin_is_container .form
            {
                width:100%; color:#9999cc;font-family:"Trebuchet MS", Arial, Helvetica, sans-serif; 
                background:#fbe3e3; border-radius:0px 0px 10px 10px;
            }
            .zadmin_is_container .row_div{width:100%;}
            .zadmin_is_container .col1{width:50px;float:left; }
            .zadmin_is_container .col2{width:90px;float:left;}
            .zadmin_is_container .col3{width:130px;float:left;}
            .zadmin_is_container .col4{width:110px;float:left;}
            .zadmin_is_container .col5{width:500px;float:left;}

           
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
                     <li><a href="leave_rules.do">Leave rules</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_home">
                <div class="zadmin_is_container">
                    <div class="link_div"><h3>Approved leave requests</h3></div>
                    <div class="form">
                        <div class="row_div">
                            <div class="col1"><b>Id</b></div>
                            <div class="col2"><b>Emp. Id</b></div>
                            <div class="col3"><b>Leave Type</b></div>
                            <div class="col4"><b>From</b></div>
                            <div class="col5"><b>To</b></div>

                        </div>

                        <c:forEach items="${leaveRequestList}" var="emp">
                            <div class="row_div">
                                <div class="col1">${emp.getLeaveRequestId()}</div>
                                <div class="col2">${emp.getLeaveEmpId()}</div>
                                <div class="col3">${emp.getLeaveType()}</div>
                                <div class="col4">${emp.getLeaveFrom()}</div>
                                <div class="col5">${emp.getLeaveTo()}</div>

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