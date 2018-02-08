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
                    <li><a href="admin.do">Admin Home</a></li>
                    <li><a href="admin_add_new_leave_type.do">Manage LeaveType</a></li>
                    
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_home">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                            <li><a href="admin.do">Admin Home</a></li>
                            <li><a href="admin_add_new_leave_type.do">Add New LeaveType</a></li>
                            
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Welcome</h3></div>
                    <div class="form"><p>Welcome to <span style="color:#F00;">LMS (Leave Management System).</span></p>
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