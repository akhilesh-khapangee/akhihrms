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
                if (value1 !== value2) {
                    alert('Enter the same passoword!');

                }

            }


        </script> 
        <style type="text/css">
            .col11{width:25%; float:left;}
            .col22{width:25%; float:left;}
            .col33{width:25%; float:left;}
            .col44{width:25%; float:left;}
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
                    <li><a href="chairman_create_projects.do">Create projects</a></li>
                    <li><a href="chairman_create_tasks.do">Create tasks</a></li>
                    <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                    <li><a href="chairman_view_task_updates.do">View task updates</a></li>

                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_leave_rule">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                            <li><a href="chairman_task_home.do">TMS Home</a></li>
                            <li><a href="chairman_create_projects.do">View projects</a></li>
                            <li><a href="chairman_create_tasks.do">View tasks</a></li>
                            <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                            <li><a href="chairman_view_task_updates.do">View task updates</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Create Projects</h3></div>

                    <form:form id="create_projects" action="chairman_create_projects.do" method="post" commandName="createProjects">
                        <div class="form">
                            <div class="form_row"><font color="red"><b>${projectCreationError}${projectCreated} </b></font></div>
                            <div class="form_row">
                                <div class="col1">Enter project name:</div>
                                <div class="col2"><form:input path="projectName" type="text"  required="true"/></div>
                            </div>
                            <div class="form_row">
                                <div class="col1">Project start date:</div>
                                <div class="col2"><form:input path="projectStartDate" type="date"  required="true"/></div>
                            </div>
                            <div class="form_row">
                                <div class="col1">Project end date:</div>
                                <div class="col2"><form:input path="projectEndDate" type="date"  required="true"/></div>
                            </div>

                            <div class="form_row">
                                <div class="col1"></div>
                                <div class="col2"><input type="submit" value="Create Project"/></div>
                            </div>
                        </form:form>
                        <div class="form_row">
                            <div class="col1"></div>
                            <div class="col2"></div>
                        </div>  
                        <div class="form_row">
                            <div class="col11"><u>Project ID</u></div>
                            <div class="col22"><u>Project Name</u></div>
                            <div class="col33"><u>Start Date</u></div>
                            <div class="col44"><u>End Date</u></div>
                        </div>
                        <c:forEach items="${projectList}" var="lst">
                            <div class="form_row">
                                <div class="col1">${lst.getProjectDetailId()}</div>
                                <div class="col22">--> ${lst.getProjectName()}</div>
                                <div class="col33">-->${lst.getProjectStartDate()}</div>
                                <div class="col44">--> ${lst.getProjectEndDate()}</div>
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