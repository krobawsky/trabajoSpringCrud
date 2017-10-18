<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<a href="empform">Add Employee</a>  


<h1>
	Username --> ${command.login}!  
</h1>
<h1>
	Password --> ${command.password}!  
</h1>

<P>   </P>
</body>
</html>
