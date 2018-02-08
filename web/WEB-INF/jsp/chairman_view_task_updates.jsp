<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
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
                    <li><a href="chairman.do">Chairman Home</a></li>
                    <li><a href="chairman_create_projects.do">Create projects</a></li>
                    <li><a href="chairman_create_tasks.do">Create tasks</a></li>
                    <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                    <li><a href="chairman_view_task_updates.do">View task updates</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_employee_profile">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                            <li><a href="chairman.do">Chairman Home</a></li>
                            <li><a href="chairman_create_projects.do">Create projects</a></li>
                            <li><a href="chairman_create_tasks.do">Create tasks</a></li>
                            <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                            <li><a href="chairman_view_task_updates.do">View task updates</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>View tasks updates</h3></div>
                    <div class="form">
                        <table width="650" border="1" cellspacing="0" cellpadding="5" style="border-color: #e0e0e0;">
                            <font color="red"><b>${successUpdate} ${errorUpdate}</b></font>
                            <tr>
                                <th scope="col" style="width:15px;">ID</th>
                                <th scope="col" style="width:25px;">Project Name</th>
                                <th scope="col" style="width:25px;">Assigned Tasks</th>
                                <th scope="col" style="width:25px;">Employee</th>
                                <th scope="col" style="width:25px;">Task Progress</th>

                            </tr>
                            <c:forEach items="${myAssignedTaskList}" var="assign">
                                <tr>
                                    <th scope="row" style="width:15px;">${assign.getProjectDetailId()}</th>
                                    <td style="width:25px;">${assign.getProjectName()}</td>
                                    <td style="width:25px;">${assign.getProjectTask()}</td>
                                    <td style="width:25px;">${assign.getAssignedEmployee()}</td>
                                    <td style="width:25px;">${assign.getTaskDesc()}</td>

                                </tr>
                            </c:forEach>


                        </table>

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