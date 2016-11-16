<%@ page import="static by.vasilevich.resources.constants.Constants.*" %>
<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 04.11.2016
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" %>
<%
    if (session.getAttribute(SESSION_PARAM_USER) == null){
%>
        <%@include file="unregistredUsers.jsp"%>
<%
    } else {
        String userName = (String) session.getAttribute(SESSION_PARAM_USER);
%>
    <div align="Right">
        <p>Welcome,<%=userName%>   <a href="?page=logout_user"><fmt:message key="index.logout"/></a></p>
    </div>
<%
    }
%>