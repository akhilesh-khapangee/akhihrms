<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href="css/login.css" rel='stylesheet' type='text/css' />

    </head>

    <body>
        <div class="container">
            <div class="content"><img src="images/logo.png"  alt="logo" style="margin-bottom:10px; "/>
                <form:form id="login" action="login.do" method="post"
                           commandName="loginDetails">
                    <fieldset>
                        <div>	
                            <div class="name_pass">Username</div>
                            <div class="float_margin"><form:input path="userName" required="true"></form:input></div>
                            <div class="float_margin"><font color="red"><form:errors path="userName" ></form:errors></font></div>
                            </div>

                            <div class="bottom_margin" style="margin-bottom:50px;">
                                <div class="name_pass">Password</div>
                                <div class="float_margin"><form:input path="password" type="password" required="true"></form:input></div>
                            <div class="float_margin"><font color="red"><form:errors path="password"></form:errors></font></div>

                            </div>
                            <input style="margin-top: 5px;" type="submit" value="Sign in"/>

                        </fieldset>
                        <div>	
                            <p style="padding-left: 20px;"><font color="red">${logonMsg} ${logOut}<form:errors /></font></p>

                    </div>
                </form:form>
            </div>
        </div>


    </body>
</html>
