<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="r" class="com.sandip.beans.Register"/>
<jsp:setProperty property="*" name="r"/>
${r.Registeru()}

<c:choose>

<c:when test="${r.count}"> sucess
<a href="index.jsp">go to login</a>
</c:when>
<c:otherwise> faild <a href="index.jsp">go to login</a></c:otherwise>
</c:choose>




</body>
</html>