<%-- 
    Document   : registro
    Created on : 26-sep-2019, 10:29:47
    Author     : student
--%>

<%@include file="head.jsp" %>
<!DOCTYPE html>
<html>
    <%= head("Registro") %>
    <body>
        <%@include file="header.jsp" %>
        <div>TODO write content</div>
        <h1>Introduzca sus datos</h1>
        <form name='form1' method='post' action='./param.jsp'>
            <table border='1'>
                <tr>
                    <td>Nombre:</td>
                    <td><input type='text' name='nombre' id='nombre'/></td>
                </tr>
                <tr>
                    <td>Edad:</td>
                    <td><input type='number' name='edad' id='edad'/></td>
                </tr>
            </table>
            <input type='submit' value='Enviar'/>
        </form>
    </body>
</html>
