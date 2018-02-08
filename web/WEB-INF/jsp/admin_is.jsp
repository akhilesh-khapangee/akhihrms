<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                    <li><a href="admin_setup.do">Admin Setup</a></li>
                    <li><a href="admin_add_employee.do">Add Employee</a></li>
                    <li><a href="admin_view_user_accounts.do">User Accounts</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">${id}
            <div class="body_add_employee">
                <div class="admin_is_container">
                    <div class="link_div"><h3>Employees</h3></div>
                    <div class="form">
                        <div class="row_div">
                            <div class="col1"><b>Emp. Id</b></div>
                            <div class="col2"><b>First Name</b></div>
                            <div class="col3"><b>Last Name</b></div>
                            <div class="col4"><b>Department</b></div>
                            <div class="col5"><b>Gender</b></div>
                            <div class="col6"><b>Update</b></div>
                            <div class="col7"><b>View</b></div>
                            <div class="col8"><b>Delete</b></div>
                        </div>
                       
                      <c:forEach items="${empProfile}" var="emp">
                      <div class="row_div">
                            <div class="col1">${emp.getEmpId()}</div>
                            <div class="col2">${emp.getFirstName()}</div>
                            <div class="col3">${emp.getLastName()}</div>
                            <div class="col4">${emp.getDepartment()}</div>
                            <div class="col5">${emp.getGender()}</div>
                            <div class="col6"><a href="admin_edit_employee_profile.do?id=${emp.getEmpId()}">Edit</a></div>
                            <div class="col7"><a href="admin_view_employee_profile.do?id=${emp.getEmpId()}">View</a></div>
                            <div class="col8"><a href="admin_delete_employee_profile.do?id=${emp.getEmpId()}">Delete</a></div>
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