<%String color = request.getParameter("color");
if(color==null&&color.toString().trim().equals("")){
	color = "verde";
	
}

%>


<body background="<%=color%>">
hola esta es una pagina dinamicas <%=color %>
</body>
