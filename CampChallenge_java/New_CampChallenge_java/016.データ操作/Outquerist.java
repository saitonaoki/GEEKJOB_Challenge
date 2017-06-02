/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getpack;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metar
 */
public class Outquerist extends HttpServlet {

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
        
        // querist.jspから受け取る
        String total = request.getParameter("total"); // requestで呼び出し
        String count = request.getParameter("count");
        String type = request.getParameter("type");
      
        //querist.jspからデータを受け取ったものを変換する
        //String型を変更し、double型で少数点入り計算実行する為（消費税）
        double a = Double.parseDouble(total); //String型をint型に変える
        double b = Double.parseDouble(count); //String型をint型に変える
        double c ; //総額と個数を割って計算するためにdouble c を用意
        double point;
        //*.parace*(String型変数); *に入るのは各ラッパクラス　今回はdouble型使用
        
        // DecimalFormatでdouble型の小数点を切り捨て実行
        DecimalFormat format = new DecimalFormat("0"); //DecimalFormatで小数点第１位から切り捨て
        // 総額に消費税を追加する
        a = a * 1.08;
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Output</title>");            
            out.println("</head>");
            out.println("<body>");
            //body内で条件式および、計算実行して表示を行う
            // １．受け取った商品種別を日本語対応で表示確認
            out.println("商品種類:"+type+"<br>");
            
            // ２．受け取った総額と個数から1個当たりの計算を行う
            c = a / b; //総額から個数分割り、1個当たりを計算する。
           
            out.println("1個当たり、"+format.format(c)+"円（税込み）<br>"); 
            // ３．受け取った総額からポイントを付与　条件：5000円以上5%、3000円以上4%
            if ( a >= 5000){
                point = 5;
                out.println("5000円以上購入しましたので、ポイント"+format.format(point)+"%をお付けします。<br>");
            }else if ( 5000 > a && a>=3000){
                point = 4;
                out.println("3000円以上購入しましたので、ポイント"+format.format(point)+"%をお付けします。<br>");
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
