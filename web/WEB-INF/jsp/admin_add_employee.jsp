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
                    <div class="link_div"><h3>Add Employee</h3></div>
                    <div class="form">
                        <form:form  id="add_employee.do" action="admin_add_employee.do" method="post" 
                                    commandName="addEmployee">

                            <div style="width:100%;"> <font color="red"><b>${errorInEmployeeAdd}</b></font></div>

                            <div class="row_div">
                                <div class="add_employee_col1"><b>Emp. Id</b></div>
                                <div class="add_employee_col2"><form:input path="empId" type="text"  required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>First Name</b></div>
                                <div class="add_employee_col2"><form:input path="firstName" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Last Name</b></div>
                                <div class="add_employee_col2"><form:input path="lastName" type="text" required="true"/></div>
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
                                        <c:forEach items="${departList}" var="lst">
                                            <form:option value="${lst.getDepartmentName()}"></form:option>
                                        </c:forEach>
                                    </form:select>
                                     <a href="admin_setup.do">Add department</a>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Designation</b></div>
                                <div class="add_employee_col2">
                                    <form:select path="designation">
                                        <c:forEach items="${desigList}" var="lst">
                                            <form:option value="${lst.getDesignationName()}"></form:option>
                                        </c:forEach>
                                    </form:select>
                                    <a href="admin_setup.do">Add designation</a>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Joined Date</b></div>
                                <div class="add_employee_col2"><form:input path="joinDate" type="date" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Job status</b></div>
                                <div class="add_employee_col2">

                                    <form:select path="jobStatus">
                                        <form:option value="Full time contract">Full time contract</form:option>
                                        <form:option value="Part time contract">Part time contract</form:option>
                                        <form:option value="Part time Internship">Part time Internship</form:option>
                                        <form:option value="Full time Internship">Full time Internship</form:option>
                                    </form:select>
                                </div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Qualification</b></div>
                                <div class="add_employee_col2"><form:input path="qualification" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Cell no.</b></div>
                                <div class="add_employee_col2"><form:input path="cellNo" type="tel" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Residence contact</b></div>
                                <div class="add_employee_col2"><form:input path="residenceContact" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Email ID</b></div>
                                <div class="add_employee_col2"><form:input path="emailId" type="email" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"><b>Address</b></div>
                                <div class="add_employee_col2"><form:input path="address" type="text" required="true"/></div>
                            </div>
                            <div class="row_div">
                                <div class="add_employee_col1"></div>
                                <div class="add_employee_col2"><input type="submit" value="ADD EMPLOYEE"/></div>
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