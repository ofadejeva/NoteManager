<jsp:include page="parent.jsp" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>

	<div class="dark-matter">
		<jsp:include page="logout.jsp" />
		<div style="text-align: center">
			<h2>Welcome ${user}!</h2>
			<a href="/NoteManager/notes" class="button"> Go to my notebook!</a>
		</div>
	</div>
</body>
</html>
