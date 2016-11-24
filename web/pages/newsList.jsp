<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 12.11.2016
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@include file="include.jsp"%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>News list</title>
</head>
<body>
    <%@include file="headerMenu.jsp"%>
    <fieldset>
        <table>
        <legend><fmt:message key="newsList.news.title"/></legend>
        <c:forEach var="news" items="${newsBeanList}">
            <tr>
                <td><a href="/NewsControl?page=itemNews&newsID=${news.newsID}">${news.title}</a></td>
                <td>${news.shortText}</td>
            </tr>
        </c:forEach>
        </table>
    </fieldset>
</body>
</html>
