<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="c1" class="com.sandip.beans.Login" scope="session"/>

<jsp:setProperty property="*" name="c1"/>


${c1.validate()} 


<c:choose>



<c:when test="${c1.u !=null}">
<c:choose>
<c:when test="${c1.u.role== 'admin'}">
 <c:redirect url="result.jsp"/> 
</c:when>
<c:otherwise>
 <c:redirect url="candlist.jsp" /> 
</c:otherwise>
</c:choose>


</c:when>
<c:otherwise>



	<h2>Login Failed</h2>
			<p>
			Invalid email or password.
			</p>
			<p>
			<a href="index.jsp">Login Again</a>
			</p>
</c:otherwise>
</c:choose>

</body>
</html>