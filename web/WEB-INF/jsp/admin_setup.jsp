<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <link rel="stylesheet" href="css/masterstyle.css" type="text/css">
        <style type="text/css">
            .admin_is_container .add_employee_col11{width:43%;float:left;}
            .admin_is_container .add_employee_col22{width:40%;float:left;}
            .setup div{padding:10px;}
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
                    <li><a href="admin.do">Admin Home</a></li>
                    <li><a href="admin_add_employee.do">Add Employee</a></li>
                    <li><a href="admin_is.do">View Employees</a></li>
                    <li><a href="admin_view_user_accounts.do">User Accounts</a></li>
                </ul>
            </nav>
        </header>


        <div class="body_wrapper">
            <div class="body_leave_rule">
                <div class="admin_is_container">
                    <div class="link_div"><h3>Some admin setups</h3></div>
                    <div class="form">
                        <div class="setup">
                            
                            <div style="width:45%;float:left; height:100px;border-radius: 10px; border:1px solid;margin-top:40px;">
                                
                                <form:form  action="admin_setup1.do" method="post" 
                                            commandName="adminSetup1">
<font color="red"><b>${successAdminSetup}
                                    ${errorAdminSetup}${deleteSucess} ${deleteError}</b></font>


                                    <div class="row_div">
                                        <div class="add_employee_col11"><b>Enter Department name:</b></div>
                                        <div class="add_employee_col22"><form:input path="departmentName" type="text"  required="true"/></div>
                                    </div>
                                    <div class="row_div">
                                        <div class="add_employee_col11"><b>&nbsp;</b></div>
                                        <div class="add_employee_col22"><input type="submit" value="Create Department"/></div>
                                    </div>


                                </form:form>

                            </div><!--end of first one-->
                            <div style="width:45%;float:left;border-radius: 10px; height:100px; border:1px solid;margin:40px 0px 0px 50px;">
                                <form:form  action="admin_setup2.do" method="post" 
                                            commandName="adminSetup2">  
                                    <div class="row_div">
                                        <div class="add_employee_col11"><b>Enter Designation name:</b></div>
                                        <div class="add_employee_col22"><form:input path="designationName" type="text" required="true"/></div>
                                    </div>
                                    <div class="row_div">
                                        <div class="add_employee_col11"><b>&nbsp;</b></div>
                                        <div class="add_employee_col22"><input type="submit" value="Create Designation"/></div>
                                    </div>
                                </form:form>
                            </div><!--end of second one -->


                            <div class="setup">
                                <div style="width:45%;float:left; border-radius: 10px; border:1px solid;margin-top:40px;">
                                    <div style="width:80px;float:left;"><u><b>Depart. ID</b></u></div>
                                    <div style="width:200px;float:left;"><u><b>Department Name</b></u></div>
                                    <div style="width:40px;float:left;"><u><b>Delete</b></u></div>


                                    <c:forEach items="${departList}" var="lst">
                                        <div style="width:80px;float:left;">${lst.getDepartmentId()}</div>
                                        <div style="width:200px;float:left;">${lst.getDepartmentName()}</div>
                                        <div style="width:40px;float:left;"><a href="delete_depart.do?id=${lst.getDepartmentId()}">Delete</a></div>
                                    </c:forEach>


                                </div><!--end of first one-->

                                <div style="width:45%;float:left;border-radius: 10px;  border:1px solid;margin:40px 0px 0px 50px;">
                                    <div style="width:80px;float:left;"><u><b>Desig. ID</b></u></div>
                                    <div style="width:200px;float:left;"><u><b>Designation Name</b></u></div>
                                    <div style="width:40px;float:left;"><u><b>Delete</b></u></div>

                                    <c:forEach items="${desigList}" var="lst">
                                        <div style="width:70px;float:left;">${lst.getDesignationId()}</div>
                                        <div style="width:220px;float:left;">${lst.getDesignationName()}</div>
                                        <div style="width:40px;float:left;"><a href="delete_desig.do?id=${lst.getDesignationId()}">Delete</a></div>
                                    </c:forEach>
                                </div><!--end of second one -->
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
</html>s