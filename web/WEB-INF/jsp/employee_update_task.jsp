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
                    <li><a href="employee.do">Home</a></li>
                    <li><a href="employee_my_tasks.do">View task</a></li>
                    <li><a href="employee_update_task.do">Update task</a></li>
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
                            <li><a href="employee_my_tasks.do">View task</a></li>
                            <li><a href="employee_update_task.do">Update task</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>View tasks</h3></div>
                    <div class="form">
                        <table width="650" border="1" cellspacing="0" cellpadding="5" style="border-color: #e0e0e0;">

                            <tr>
                                <th scope="col" style="width:15px;">ID</th>
                                <th scope="col" style="width:25px;">Project Name</th>
                                <th scope="col" style="width:25px;">Assigned Tasks</th>
                                <th scope="col" style="width:25px;">Task Progress</th>
                                <th scope="col" style="width:25px;">Update Progress</th>

                            </tr>
                            <c:forEach items="${myAssignedTaskList}" var="assign">
                                <tr>
                                    <th scope="row" style="width:15px;">${assign.getProjectDetailId()}</th>
                                    <td style="width:25px;">${assign.getProjectName()}</td>
                                    <td style="width:25px;">${assign.getProjectTask()}</td>
                                    <td style="width:25px;">${assign.getTaskDesc()}</td>
                                    <td style="width:25px;"><a href="update_task_progress.do?id=${assign.getProjectDetailId()}">Update Progress</td>

                                </tr>
                            </c:forEach>


                        </table>
                        <div style="width:100%; padding-top:30px;">
                            <form action="update_task_progress.do" method="post">
                                <div style="width:100%;"><b>Update Progress:</b></div>
                                <div style="width:100%" ><input type="text" size="1" readonly="readonly" name="hiddenProjectTaskId" value="${projectTaskId}"></div>
                                <div style="width:100%" > <textarea name="updatedTaskDesc" cols="50" rows="10">${taskDescription}</textarea></div>
                                <div style="width:100%" > <input type="submit"  value="Update Task Progress"/></div>
                            </form>
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