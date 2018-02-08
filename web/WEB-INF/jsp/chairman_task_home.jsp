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
                    <li><a href="chairman.do">Chairman Home</a></li>
                    <li><a href="chairman_create_projects.do">Create projects</a></li>
                    <li><a href="chairman_create_tasks.do">Create tasks</a></li>
                    <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                    <li><a href="chairman_view_task_updates.do">View task updates</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_home">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                           
                            <li><a href="chairman_create_projects.do">View projects</a></li>
                            <li><a href="chairman_create_tasks.do">View tasks</a></li>
                            <li><a href="chairman_assign_task.do">Assign tasks</a></li>
                            <li><a href="chairman_view_task_updates.do">View task updates</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Welcome</h3></div>
                    <div class="form"><p>Welcome to <span style="color:#F00;">TMS (Task Management System).</span></p>
                        <p>Click on the side link to view your information.</p></div>
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