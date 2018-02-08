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
            <div class="logout">${msg}
                <span><a href="logout.do">Logout</a></span>
            </div>
            <nav class="nav">
                <ul>
                     <li><a href="admin_is.do">EMPLOYEE INFORMATION SYSTEM</a></li>
                    <li><a href="chairman_leave_home.do">LEAVE MANAGEMENT SYSTEM</a></li>
                    <li><a href="chairman_task_home.do">TASK MANAGEMENT SYSTEM</a></li>

                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_home">
                <div class="welcome_div"><h1>Welcome </h1>
                    <p><font color="yellow"><b>${chairmanHome}</b></font></p>
                    <p>Welcome <b><font color="yellow">"<% out.println(session.getAttribute("user"));%></font></b>
                        to Chairman home. You have been successfully logged in to the system....
                    </p>
                </div>
                <div class="welcome_div"><h1>Some guides</h1>
                    <p>You can click on the above menu to perform necessary set up and actions.</p>
                    <p>1. Employee Information System</p>
                    <p>2. Leave Management System</p>
                    <p>3. Task Management System</p>
                    
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