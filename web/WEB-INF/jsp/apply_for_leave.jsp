<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <li><a href="employee.do">Employee Home</a></li>
                    <li><a href="apply_for_leave.do">Request for leave</a></li>
                    <li><a href="view_leave_history.do">My approved leave history</a></li>

                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_employee_profile">
                <div class="left_container">
                    <div class="link_div"><h3>Links</h3></div>
                    <div>
                        <ul>
                           <li><a href="employee.do">Employee Home</a></li>
                            <li><a href="apply_for_leave.do">Request for leave</a></li>
                            <li><a href="view_leave_history.do">My approved leave history</a></li>
                            <li><a href="leave_rules.do">Leave rules</a></li>
                        </ul>
                    </div>
                </div>
                <div class="right_container">
                    <div class="link_div"><h3>Apply for leave</h3></div>
                    <div class="form">
                        <form:form action="apply_for_leave.do" method="POST" commandName="applyForLeave">
                            <div><font color="red"><b> ${sccc} ${errorleaveRequest}</b></font></div>
                            <div class="form_row">
                            <div class="col1">Emp. ID</div>
                            <div class="col2"><form:input readonly="true" path="empIdForLeaveRequest" type="text"  required="required" value="${empId}"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">First Name</div>
                            <div class="col2"><input  disabled="disabled"  type="text" required="required" value="${firstName}"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Last Name</div>
                            <div class="col2"><input disabled="disabled"  type="text" required="required"  value="${lastName}"/></div>
                        </div>

                        <div class="form_row">
                            <div class="col1">Department</div>
                            <div class="col2"><input disabled="disabled" type="text"  value="${department}"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Designation</div>
                            <div class="col2"><input disabled="disabled"  value="${designation}"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Nature of leave</div>
                            <div class="col2">
                                <form:select path="leaveType">
                                    <c:forEach items="${getLeaveTypeList}" var="lst">
                                    <form:option value="${lst.getLeaveType()}"></form:option>
                                    </c:forEach>
                                    
                                </form:select>
                            </div>
                        </div>
                        <div class="form_row">
                            <div class="col1">From</div>
                            <div class="col2"><form:input path="leaveFrom" type="date" required="required"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">To</div>
                            <div class="col2"><form:input path="leaveTo" type="date" required="required"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1">Purpose of leave</div>
                            <div class="col2"><form:textarea path="leavePurpose" rows="2" cols="16" required="required"/></div>
                        </div>
                        <div class="form_row">
                            <div class="col1"><input type="submit" value="Submit"/></div>
                            <div class="col2"></div>
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