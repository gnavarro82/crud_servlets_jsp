<%@page import="servlets.BuscarPersonas"%>
<%@page import="servlets.MostrarPersonas"%>
<%@page import="datos.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Persona"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Persona</title>
    </head>
    <body>
        <form action="BuscarPersonas" method="post">
            <table border="1">
                <tr>
                    <td><input type="text" name="buscar" /></td>
                    <td><input type="submit" value="Buscar"/></td>
                </tr>
            </table>
        </form>     
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
                BuscarPersonas buscar = new BuscarPersonas();
              
                for(Persona persona: buscar.getRetorno()){
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
