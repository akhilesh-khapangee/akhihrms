<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li><a href="admin_add_employee.do">Add Employee</a></li>
                     <li><a href="admin_is.do">View Employees</a></li>
                    <li><a href="admin_view_user_accounts.do">User Accounts</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_add_employee">
                <div class="admin_is_container">
                    <div class="link_div"><h3>Update profile of employee ID: <font color="yellow">${empId}</font> and name: <font color="yellow">${firstName} ${lastName}</font></h3></div>
                    <div class="form">
                        <form:form  id="admin_edit_employee_profile" action="admin_edit_employee_profile.do?id=${empId}" method="post" 
                                    commandName="editEmployee">

                            <div style="width:100%;"> <font color="red"><b>${successEdit}</b></font></div>
                           
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Emp. Id</b></div>
                                <div class="add_employee_col2"><form:input path="empId" value="${empId}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>First Name</b></div>
                                <div class="add_employee_col2"><form:input path="firstName" value="${firstName}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Last Name</b></div>
                                <div class="add_employee_col2"><form:input path="lastName" value="${lastName}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Gender</b></div>
                                <div class="add_employee_col2">
                                    <form:select path="gender">
                                        <form:option value="Male">Male</form:option>
                                        <form:option value="Female">Female</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Department</b></div>
                                <div class="add_employee_col2">
                                    <form:select path="department">
                                        <form:option value="Software Engineering">Software Engineering</form:option>
                                        <form:option value="Accounting">Accounting</form:option>
                                        <form:option value="Administration">Administration</form:option>
                                        <form:option value="Test">Test</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Designation</b></div>
                                <div class="add_employee_col2"><form:input path="designation" value="${designation}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Joined Date</b></div>
                                <div class="add_employee_col2"><form:input path="joinDate" value="${joinDate}" type="date" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Job status</b></div>
                                <div class="add_employee_col2">

                                    <form:select path="jobStatus">
                                        <form:option value="Full time contract">Full time contract</form:option>
                                        <form:option value="Part time contract">Part time contract</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Qualification</b></div>
                                <div class="add_employee_col2"><form:input path="qualification" value="${qualification}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Cell no.</b></div>
                                <div class="add_employee_col2"><form:input path="cellNo" type="tel" value="${cellNo}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Residence contact</b></div>
                                <div class="add_employee_col2"><form:input path="residenceContact" type="tel" value="${residenceContact}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Email ID</b></div>
                                <div class="add_employee_col2"><form:input path="emailId" type="email" value="${emailId}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Address</b></div>
                                <div class="add_employee_col2"><form:input path="address" value="${address}" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"></div>
                                <div class="add_employee_col2"><input type="submit" value="UPDATE EMPLOYEE"/></div>
                            </div>
                            
                        </form:form>
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