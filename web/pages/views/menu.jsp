<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<div class="privateInfo">
    <sec:authorize ifAnyGranted="admin">
        <a href="/listClient.do">List of clients</a>
        <a href="/createClient.do">Add new client</a>
    </sec:authorize>
    <sec:authorize ifAnyGranted="client">
        <a href="/profileClient.do">Profile client</a>
    </sec:authorize>
</div>

<%--
<root version="2.0" xmlns="http://www.w3.org/1999/xhtml"
      xmlns:jsp="http://java.sun.com/JSP/Page">
    <header class="clear-fix">
        <div class="menu">
            <div class="privateInfo">
                <sec:authorize ifAnyGranted="admin">
                    <a href="/listClient.do">List of clients</a>
                    <a href="/createClient.do">Add new client</a>
                </sec:authorize>
                <sec:authorize ifAnyGranted="client">
                    <a href="/profileClient.do">Profile client</a>
                </sec:authorize>
            </div>
        </div>
    </header>
</root>
--%>

