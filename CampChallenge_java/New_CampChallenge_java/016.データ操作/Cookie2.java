/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getcookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author metar
 */
public class Cookie2 extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Cookie2</title>");            
            out.println("</head>");
            out.println("<body>");
            //Date型で宣言して、現在の日付を宣言(importして使用)
            Date d = new Date(); 
            //SimpleDateFormat型でフォーマットを作成（importして使用）
            SimpleDateFormat sdf =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            //Cookieへ"Lastlogin"でsdf.format(d)という日付データを保存
            //注意：jspだとcookieのimportはいらないが、サーブレットだと必要な為、javax.servlet.http.Cookie;をimportする
            Cookie c = new Cookie("Lastlogin",sdf.format(d));
             // cookieに反映
            response.addCookie(c);
            
            out.println("今回のログイン:"+sdf.format(d)+"<br>");
            //cookieの中身を取得
            Cookie cs[]=request.getCookies();
            
            if(cs!=null){
                for(int i=0;i<cs.length;i++){
                    if(cs[i].getName().equals("Lastlogin")){
                        out.println("前回のログイン:"+cs[i].getValue());
                    }
                }
            }
           
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
