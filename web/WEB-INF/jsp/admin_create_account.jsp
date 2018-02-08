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
                    <div class="link_div"><h3>Create user accounts</h3></div>
                    <div class="form">
                        <form:form  id="create_account" action="admin_create_account.do" method="post" 
                                    commandName="createAccount">

                            <div style="width:100%;"> <font color="red"><b>${createSuccess}</b><b>${errorCreate}</b></font></div>

                            <div class="row_div">
                                <div class="add_employee_col1"><b>Account for:</b></div>
                                <div class="add_employee_col2">

                                    <form:select path="userEmpId">
                                        <c:forEach items="${userEmpIdList}" var="empId">
                                            <form:option value="${empId.getEmpId()}"/>
                                        </c:forEach>
                                    </form:select>

                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>UserName:</b></div>
                                <div class="add_employee_col2"><form:input path="empUserName" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Password:</b></div>
                                <div class="add_employee_col2"><form:input path="empPassword" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>User Type:</b></div>
                                <div class="add_employee_col2">
                                    <form:select path="userType">
                                        <form:option value="Employee">Employee</form:option>
                                         <form:option value="Admin">Admin</form:option>
                                          <form:option value="Chairman">Chairman</form:option>
                                    </form:select>
                                </div>
                            </div>

                            <div class="row_div">
                                <div class="add_employee_col1"></div>
                                <div class="add_employee_col2"><input type="submit" value="Create Account"/></div>
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