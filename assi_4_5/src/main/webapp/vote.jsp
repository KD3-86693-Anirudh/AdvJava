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

<h2>Voting Status</h2>
	<jsp:useBean id="vb" class="com.sandip.beans.Vote"/>
	<jsp:setProperty name="vb" property="candId" param="candidate"/>
	<jsp:setProperty name="vb" property="userId" value="${c1.u.id}"/>
	
	<c:choose>
		<c:when test="${c1.u.status == 0}">
			${vb.vote()}
			<c:choose>
				<c:when test="${vb.success}">
					<p>You have successfully voted.</p>
					${c1.u.setStatus(1)}
				</c:when>
				<c:otherwise>
					<p>Your voting attempt failed.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>You have already voted.</p>
		</c:otherwise>
	</c:choose>
	
	<p>
	<a href="logout.jsp">Sign Out</a>
	</p>
</body>
</html>