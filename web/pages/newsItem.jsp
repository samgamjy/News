<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 12.11.2016
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>News list</title>
</head>
<body>
    <%@include file="headerMenu.jsp"%>
    <fieldset>
        <legend><fmt:message key="newsList.news.title"/></legend>
            <table>
                <tr>
                    <td><a href="/NewsControl?page=itemNews&newsID=${news.newsID}">${news.title}</a></td>
                    <td>${news.shortText}</td>
                </tr>
            </table>
    </fieldset>

</body>
</html>

