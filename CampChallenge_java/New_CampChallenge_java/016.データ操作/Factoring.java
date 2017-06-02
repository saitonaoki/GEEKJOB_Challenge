/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getpack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metar
 */
public class Factoring extends HttpServlet {

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

            // Simplefactoring.jspから受け取る
            String number = request.getParameter("number"); //requestで呼び出し
            //Simplefactoring.jspからデータを受け取ったものを変換する
            int num = Integer.parseInt(number); //String型をint型に変える
            
            try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>簡易素因数分解　結果</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>簡易素因数分解　結果</h2>");
            
            //受け取った数値を素因数分解する
            //2桁と1桁で処理を分ける if elseで分ける　また、1を入力された場合、素数ではないことを表示
            //ループを組んで、割り切れるまで処理 if elseの２つ同じ処理
            
            int  i = 2;
            if(num >9){     //2桁なら「元の値　１桁の素因数　余った値」を表示する
                while(num!=1){
                    if (num%i==0){
                        out.println("<font size=\"+1\">数字="+num+"  素因数="+i+"</font>"); //
                        num/= i;
                        out.println("<font size=\"+1\">余った値"+num+"</font><br>");
                    }else{
                        i++;
                    }
                }
            }else if(num>=2){      //１桁側の処理　余った値とフォントサイズを変更
                while(num!=1){
                    if (num%i==0){
                        out.println("<font size=\"+2\">数字="+num+"  素因数="+i+"</font><br>"); 
                        num/= i;
                    }else{
                        i++;
                    }
                }
            }else{
                out.println("<font size=\"+3\">"+num+"は素数ではありません</font>"); //１を入力された場合の表示
            }
            
            // 単純に素因数分解するなら以下を実装するだけでよし
/*          int i =2;
            while(num!=1){
                    if (num%i==0){
                        out.println("<font size=\"+1\">数字="+num+"  素因数="+i+"</font>"); //
                        num/= i;
                        out.println("<font size=\"+1\">余った値"+num+"</font><br>");
                    }else{
                        i++;
                    }
            }
*/
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
