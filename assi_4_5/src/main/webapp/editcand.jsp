<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Candidate</h2>
<jsp:useBean id="fcb" class="com.sandip.beans.Findc"/>
	<jsp:setProperty name="fcb" property="candId" param="id" />
	${fcb.find()}
	
	<form method="post" action="updatec.jsp">
		<input type="hidden" name="id" value="${fcb.cand.id}"/>
		Name: <input type="text" name="name" value="${fcb.cand.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.cand.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" readonly="readonly" value="${fcb.cand.votes}"/> <br/><br/>
		<input type="submit" value="Update"/>
	</form>	
</body>
</html>