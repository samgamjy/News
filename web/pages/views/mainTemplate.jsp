<%@ include file="/WEB-INF/jsp/pages/include/include.jsp" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%--<html xmlns:jsp="http://java.sun.com/jsp/Page"--%>
      <%--xmlns:tiles="http://tiles.apache.org/tags-tiles">--%>
<head>
    <title>
        <tiles:useAttribute name="title" id="title"></tiles:useAttribute>
        <c:if test="${not empty title}">
            <title>${title}</title>
        </c:if>
    </title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="left">
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
        </td>
        <td>
            <tiles:insertAttribute name="body"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </td>
    </tr>
</table>
</body>
</html>