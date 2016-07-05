<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<h1></h1>
<ul>
<li>nombre apliccion ${pageContext.request.contextPath}</li>
<li>vaegador ${header["User-Agent"]}</li>
<li>Id session ${cookie.JSESSIONID.value}</li>
<li>web server ${pageContext.servletContext.serverInfo}</li>
<li>usuario de context request ${param["usuario"]}</li>


</ul>
</body>
</html>