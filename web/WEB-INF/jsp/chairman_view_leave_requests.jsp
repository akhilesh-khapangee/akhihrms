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
            .zadmin_is_container .col5{width:110px;float:left;}
            .zadmin_is_container .col6{width:80px;float:left;}
            .zadmin_is_container .col7{width:80px;float:left;}
            .zadmin_is_container .col8{width:100px;float:left;}
            .zadmin_is_container .col9{width:100px;float:left;}
            .zadmin_is_container .col10{width:100px;float:left;}
            

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
                    <li><a href="chairman.do">Chairman Home</a></li>
                    <li><a href="chairman_view_leave_requests.do">View all leave requests</a></li>
                    <li><a href="chairman_approveds.do">View approved only</a></li>
                    <li><a href="chairman_rejecteds.do">View rejected only</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_view_leave_requests">
                <div class="zadmin_is_container">
                    <div class="link_div"><h3>Leave requests</h3></div>
                    <div class="form">
                        <div class="row_div">
                            <div class="col1"><b>Id</b></div>
                            <div class="col2"><b>Emp. Id</b></div>
                            <div class="col3"><b>Leave Type</b></div>
                            <div class="col4"><b>From</b></div>
                            <div class="col5"><b>To</b></div>
                            <div class="col6"><b>Status</b></div>
                            <div class="col7"><b>Reason</b></div>
                            <div class="col8"><b>Approve</b></div>
                            <div class="col9"><b>Decline</b></div>
                            <div class="col10"><b>Emp. Profile</b></div>
                        </div>

                        <c:forEach items="${leaveRequestList}" var="emp">
                            <div class="row_div">
                                <div class="col1">${emp.getLeaveRequestId()}</div>
                                <div class="col2">${emp.getLeaveEmpId()}</div>
                                <div class="col3">${emp.getLeaveType()}</div>
                                <div class="col4">${emp.getLeaveFrom()}</div>
                                <div class="col5">${emp.getLeaveTo()}</div>
                                <div class="col6"><font color="red">${emp.getRequestStatus()}</font></div>
                                <div class="col7"><a href="leave_reason.do?id=${emp.getLeaveRequestId()}">Click</a></div>
                                <div class="col8"><a href="leave_approve.do?id=${emp.getLeaveRequestId()}">Approve</a></div>
                                <div class="col9"><a href="leave_decline.do?id=${emp.getLeaveRequestId()}">Decline</a></div>
                                <div class="col10"><a href="check_profile.do?id=${emp.getLeaveRequestId()}">View</a></div>
                            </div>
                        </c:forEach>
                        <div><font color="brown" size="6">Leave reason of </font>
                            <font color="red">"<b>${leaveEmpId}</b>"</font>:<br><span style="background:#9999cc; color:yellow; border-radius: 10px; padding:0 5px 0px 5px;">${leavePurpose}</span></div>
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