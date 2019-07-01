/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
@WebServlet(name = "IngresarDatos", urlPatterns = {"/IngresarDatos"})
public class IngresarDatos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Ingresar</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>El resultado fue : </h1>");
            Persona persona = new Persona();
            Conexion con = new Conexion();
            persona.setDni(request.getParameter("dni"));
            persona.setNombre(request.getParameter("nombre"));
            persona.setEdad(Integer.valueOf(request.getParameter("edad")));
            persona.setTelefono(Integer.valueOf(request.getParameter("telefono")));

            if (con.ingreso_datos(persona)) {
                out.print("<h2>La Persona con Dni : " + persona.getDni() + " fue Ingresada</h2>");
                out.print("<br><a href='index.jsp' >Volver</a>");
            } else {
                out.print("<h2>Persona No Ingresada</h2>");
                out.print("<br><a href='index.jsp' >Volver</a>");
            }

          
        } catch (NumberFormatException ex) {
            out.print("<h1>Formato Incorrecto</h1>");
        } catch (Exception e) {
            out.print("<h1>" + e.getMessage() + "</h1>");
            out.print("<br><a href='index.jsp' >Volver</a>");
        }finally{
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
