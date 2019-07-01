

<%@page import="servlets.MostrarPersonas"%>
<%@page import="datos.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
  <table border="1">
            <thead>
                <tr>
                    <th>Dni</th>
                    <th>Nombre</th>
                    <th>Edad</th>
                    <th>Telefono</th>
                </tr>   
            </thead>
            <tbody>
                <%
                //OBJETO DE NUESTRO SERVET
                MostrarPersonas mostrar = new MostrarPersonas();
              
                for(Persona persona: mostrar.getRetorno()){
                %>
                <tr>
                    <td><%out.print(persona.getDni());%></td>
                    <td><%out.print(persona.getNombre());%></td>
                    <td><%out.print(persona.getEdad());%></td>
                    <td><%out.print(persona.getTelefono());%></td>
                </tr>
                <%
                }
                %>

                </tbody>

  </table>        
                <br>
                <a href="index.jsp">Volver</a>
    </body>
</html>
