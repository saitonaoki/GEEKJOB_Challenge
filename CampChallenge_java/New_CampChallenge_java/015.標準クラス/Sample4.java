/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package standard;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metar
 */
public class Sample4 extends HttpServlet {
    public static void main(PrintWriter pw){
        //引数で無理やり表示してます。理由：System側で計算表示されなかった為。
        // フォーマットパターン設定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        // Date型２つを用意
        Date dateto= null;
        Date datefrom= null;
        // 日付の作成
        try{
            dateto = sdf.parse("2015年12月31日 23時59分59秒");
            datefrom = sdf.parse("2015年1月1日 0時0分0秒");
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        //日付をlong値に変換
        long dateTimeto = dateto.getTime();
        long dateTimefrom = datefrom.getTime();
    
        // 差分の時間計算
        long dayDiff = ( dateTimeto - dateTimefrom ) / ( 1000 * 60 * 60 );
        
        //
        pw.println("日数(from):"+sdf.format(datefrom)+"<br>");
        pw.println("日数(to):"+sdf.format(dateto)+"<br>");
        pw.println("差分時間:"+dayDiff+"<br>");
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
            
            main(out);
            
            /* TODO output your page here. You may use following sample code. */
/*            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Sample4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Sample4 at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
*/      }
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
