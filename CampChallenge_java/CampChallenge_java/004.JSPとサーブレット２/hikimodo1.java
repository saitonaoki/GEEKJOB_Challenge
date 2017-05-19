/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikisuumodoriti;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metar
 */
public class hikimodo1 extends HttpServlet {  
    private static String[] maindata(String x){
        
    String[] data  = {};
    String[] data1 = {"1","name1","04/01","chiba"};
    String[] data2 = {"2","name2","05/01","tokyo"};
    String[] data3 = {"3","name3","06/01","kyoto"};
    
    switch(x){
        case("1"):
                   data = data1;    
                   break ;
    
        case("2"):
                   data = data2;
                   break;
        case("3"):   
                   data = data3;
                   break;         
                   
    }
       
    return data;
                }
   
   
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
        try (PrintWriter out = response.getWriter()) {
           
            String a = "2";
           String[]profil = maindata(a);
           for(int i=1;1<=3;i++){
               out.println(profil[i]);
           }
            
            
        

            /* TODO output your page here. You may use following sample code. */
/*            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet hikimodo1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet hikimodo1 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
*/        }
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
