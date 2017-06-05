/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getsession;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author metar
 */
public class Session2 extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8"); //日本語入力対応させる
         
        // kojinforum.jspから受け取る
        String name = request.getParameter("name"); // requestで呼び出し
        String rdSex = request.getParameter("rdSex"); 
        String hobby = request.getParameter("hobby"); 
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Seesion2</title>");            
            out.println("</head>");
            out.println("<body>");
            
            // HttpSession型でセッションの取得を取得(importして使用)
            HttpSession hs = request.getSession(); 
            // 何も入ってないor前回のデータをセッションから呼び出す
            out.println("<h2>前回の登録して頂いたデータ</h2><br>");

            out.println("<font size=\"+1\">名前："+hs.getAttribute("name")+"</font><br>");    
            out.println("<font size=\"+1\">性別："+hs.getAttribute("rdSex")+"</font><br>");
            out.println("<font size=\"+1\">趣味："+hs.getAttribute("hobby")+"</font><br>"); 
            out.println("<br><br>");//前回と今回のデータを分けるため改行
            
            // HttpSession型変数.setAttributeでセッションへ登録
            // String型データを登録
            hs.setAttribute("name",name);
            hs.setAttribute("rdSex", rdSex);
            hs.setAttribute("hobby", hobby);
            
            //今回のセッションを表示
            out.println("<h2>今回の登録データ</h2><br>");
            out.println("<font size=\"+1\">名前："+name+"</font><br>");
            out.println("<font size=\"+1\">性別："+rdSex+"</font><br>");
            out.println("<font size=\"+1\">趣味："+hobby+"</font><br>");
            
            
            out.println("</body>");
            out.println("</html>");
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
