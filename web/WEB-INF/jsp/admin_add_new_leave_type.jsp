<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Human Resource Management System (HRMS)</title>
        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
        <style type="text/css">
            .add_left{
                padding:0 10px 10px 10px;  
                color:#9999cc;
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
            }
            .add_left div{padding-top:10px;}
            .add_left input{color:#9999cc;}
            .add_left_container{

                width:35%; float:left;
            }
            .add_right_container div{padding:10px;}
            .add_right_container{
                width:63%;  float:right;

            }
            .leave_info{

                width:20%;float:left;
            }
            .leave_type_form2{

                color:#9999cc;font-family:"Trebuchet MS", Arial, Helvetica, sans-serif; 
                background:#fbe3e3; border-radius:0px 0px 10px 10px;
                height: 500px;
            }


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
                    <li><a href="admin_leave_home.do">LMS Home</a></li>

                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_add_employee">
                <div class="add_left_container">
                    <div class="link_div"><h3>Add new type</h3></div>

                    <div class="add_left">
                        <form:form id="fomrm12" method="post" 
                                   action="admin_add_new_leave_type_action.do" commandName="addLeaveType">
                            <div><font color="red"><b>${success}</b></font></div>
                            <div>
                                <div style="width:40%; float:left;">Enter leaveType:</div>
                                <div style="width:40%;float:left;"><form:input path="leaveType" size="20" type="text" required="true"/></div>
                            </div>
                            <div>
                                <div style="width:40%; float:left;">Enter leave rules:</div>
                                <div style="width:40%;float:left;"><form:textarea  path="leaveDesc" rows="10" cols="16" required="true" /></div>
                            </div>
                            <div>
                                <div style="width:40%; float:left;">&nbsp;</div>
                                <div style="width:40%;float:left;"><input type="submit" value="Add LeaveType" /></div>
                            </div>
                        </form:form>
                    </div>

                </div>

                <div class="add_right_container">
                    <div class="link_div"><h3>Current LeaveTypes</h3></div>
                    <div class="leave_type_form2">
                        <div><font color="red"><b>${successDelete}</b></font></div>
                        <div>
                            <div class="leave_info">Leave Id</div>
                            <div class="leave_info">Leave Type</div>
                            <div class="leave_info">Delete</div>
                            <div class="leave_info">Leave Rule</div>
                        </div>
                        <c:forEach items="${leaveList}" var="obj" >
                            <div>
                                <div class="leave_info">${obj.getLeaveId()}</div>
                                <div class="leave_info">${obj.getLeaveType()}</div>
                                <div class="leave_info">
                                    <a href="delete_admin_add_new_leave_type.do?id=${obj.getLeaveId()}">
                                        Delete</a></div>
                                <div class="leave_info"><a href="admin_view_leave_rule.do?id=${obj.getLeaveId()}">
                                        Leave Rule</a></div>
                            </div>
                        </c:forEach>
                        <div>

                            <div style="width:20%;float:left; padding-top:50px;"><font color="blue"><u>Leave Type</u></font></div>
                            <div style="width:70%;float:left;padding-top:50px;"><font color="blue"><u>Leave Rule</u></font></div>
                        </div>
                        <div>

                            <div style="width:20%;float:left;">${leaveTypeName}</div>
                            <div style="width:70%;float:left;">${leaveRuleC}</div>

                        </div>
                    </div>
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