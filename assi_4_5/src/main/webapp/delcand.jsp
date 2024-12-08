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


	<jsp:useBean id="dl" class="com.sandip.beans.delcnd"/>
	<jsp:setProperty property="id" name="dl" param="id"/>
	
	${dl.delete()}
	<c:choose>
	<c:when test="${dl.count==1}">
	<jsp:forward page="result.jsp">
	<jsp:param value="candidate deleted successfully" name="mag"/>
	
	</jsp:forward>
	</c:when>
	<c:otherwise>
	deletion faild
	</c:otherwise>
	</c:choose>	
	
	

</body>
</html>