<%@include file="include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello!</h1>
    <form action="/NewsControl" method="post">
        <input type="hidden" name="page" value="registration_user">
	        <table>
            <tr>
                <td>
                    <div><input type="text" name="firstname" value=""/><fmt:message key="registration.user.firstname"/></div>
                    <br>
                    <div><input type="text" name="lastname" value=""/><fmt:message key="registration.user.lastname"/></div>
                    <br>
                    <div><input type="text" name="shortname" value=""/><fmt:message key="registration.user.shortname"/></div>
                    <br>
                    <div><input type="text" name="nickname" value=""/><fmt:message key="registration.user.nickname"/></div>
                    <br>
                    <div><input type="text" name="login" value=""/><fmt:message key="registration.user.login"/></div>
                    <br>
                    <div><input type="password" name="password" value=""/><fmt:message key="registration.user.password"/></div>
                    <br>
                    <div><input type="submit" value=<fmt:message key="registration.user.button"/>></div>
                    <br>
                    <div>
                    <input type="radio" name="role" value="author" checked><fmt:message key="registration.user.author"/></input>
					<input type="radio" name="role" value="commentator"><fmt:message key="registration.user.commentator"/></input>
					</div>
                </td>
            </tr>
            <!-- 
            <tr>
                <td>
                    <a href="createClient.jsp"><fmt:message key="login.title.create.client"/></a>
                </td>
            </tr>
             -->
        </table>
	
	</form>

</body>
</html>