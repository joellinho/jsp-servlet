<%
String fondo = request.getParameter("fondo");
%>

<div style="background-color: <%=fondo%>">
esto es una pagina dianamica la cual anvio a su vez tambien parametros en este caso es el fondo
las pagians dinamicas se envian atraves de la etiqueta 

<pre>
<%=fondo%>
</pre>
</div>
