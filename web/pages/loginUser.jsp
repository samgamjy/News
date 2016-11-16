<%@include file="include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<style>
		.loginStyle{
			vertical-align: middle;
		}
	</style>
<title>Login user</title>
</head>
<body>
	<form action="/NewsControl" method="post">
		<input type="hidden" name="page" value="login_user">

		<table width=100%>
			<tr/>
			<tr valign="middle">
				<td width=40%></td>
				<td align="center">
					<div align="right"><fmt:message key="login.user.login"/><input type="text" name="login" placeholder=<fmt:message key="login.user.login"/> value=""/></div>
					<br>
					<div align="right"><fmt:message key="login.user.password"/><input type="password"  name="password" placeholder=<fmt:message key="login.user.password"/> value=""/></div>
				</td>
				<td width=40%></td>
			</tr>
			<tr>
				<td width=40%><a></a></td>
				<td>
					<div align="right"><input type="submit" value=<fmt:message key="login.user.button"/>></div>
				</td>
				<td width=40%></td>
			</tr>
			<tr/>
		</table>
	</form>
	 
</body>
</html>