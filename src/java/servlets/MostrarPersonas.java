/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import datos.Colecciones;
import datos.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "MostrarPersonas", urlPatterns = {"/MostrarPersonas"})
public class MostrarPersonas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Redireccionando ...</title>");
            out.println("</head>");
            out.println("<body>");
            
            
            Conexion con = new Conexion();
            Colecciones.mostrar.clear();
            ArrayList<Persona> personas= con.listar();
            for(Persona persona: personas){
            Persona per = new Persona();
           
            per.setDni(persona.getDni());
            per.setNombre(persona.getNombre());
            per.setEdad(persona.getEdad());
            per.setTelefono(persona.getTelefono());
            Colecciones.mostrar.add(per);

            }
            
            response.sendRedirect("mostrar.jsp");
          
      
        } catch (Exception e) {
            out.print("<h1>" + e.getMessage() + "</h1>");
            out.print("<br><a href='index.jsp' >Volver</a>");
        }finally{
            out.println("</body>");
            out.println("</html>");
            out.close();
        }

    }

    
    public ArrayList<Persona> getRetorno(){
        return Colecciones.mostrar;
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
