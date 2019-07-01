<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Persona"%>
<%@page import="modelo.Persona"%>
<%@page import="datos.Conexion"%>

<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <table border="0"><td>Ingreso de Personas</td></table>
        <form action="IngresarDatos" method="post">
            <table border="0">
                <tr> 
                    <td>Dni</td>   
                    <td><input type="text" name="dni" /></td>
                </tr>
                <tr> 
                    <td>Nombre</td>   
                    <td><input type="text" name="nombre" /></td>   
                </tr>
                <tr> 
                    <td>Edad</td>   
                    <td><input type="text" name="edad" /></td> 
                </tr>
                <tr>  
                    <td>Telefono</td>   
                    <td><input type="text" name="telefono" /></td> 
                </tr>
                <tr>  
                    <td><input type="submit" value="Guardar Informacion" /></td> 
                </tr>
            </table>  
        </form>
        <br>
        <form action="EliminarDatos" method="post">
            <table border="0">
                <tr> 
                    <td>Ingresar Dni</td>   
                    <td><input type="text" name="dni" /></td>
                </tr>
                <tr>  
                    <td><input type="submit" value="Eliminar Informacion" /></td> 
                </tr>
            </table>  
        </form>       
        <br>            
        <form action="actualizar.jsp" method="post">
            <table border="0">
                <tr> 
                    <td>Dni</td>   
                    <td><input type="text" name="dni" /></td>
                </tr>
                <tr> 
                    <td>Nombre</td>   
                    <td><input type="text" name="nombre" /></td>   
                </tr>
                <tr> 
                    <td>Edad</td>   
                    <td><input type="text" name="edad" /></td> 
                </tr>
                <tr>  
                    <td>Telefono</td>   
                    <td><input type="text" name="telefono" /></td> 
                </tr>
                <tr>  
                    <td><input type="submit" value="Actualizar Informacion" /></td> 
                </tr>
            </table>  
        </form>                    
        <ul>
            <li><a href="BuscarPersonas">Buscar Personas</a></li>
            <li><a href="MostrarPersonas">Mostrar Personas</a></li>
        </ul>


    </body>
</html>
