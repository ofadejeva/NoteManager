
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<jsp:include page="logout.jsp" />
	<center>Welcome ${user}</center>
	<a href="/NoteManager/notes"> Go to my notebook!</a>
</body>
</html>