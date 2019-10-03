<%-- 
    Document   : param
    Created on : 25-sep-2019, 17:37:17
    Author     : student
--%>

<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
    <%= head("Datos Introducidos") %>
    <body>
        <%@include file="header.jsp" %>
        <h1>Datos</h1>
        <p>Te llamas <%  out.println(request.getParameter("nombre")); %> </p>
        <p>Y tienes <% out.println(request.getParameter("edad")); %> </p>

        <ul>
            <%  for (int i = 0; i < 10; i++) {%>

            <li class="tipo-letra-tam-<%=i%>">Numero  <% out.println("" + i); %>  </li>

            <% }%>
        </ul>
    </body>
</html>
