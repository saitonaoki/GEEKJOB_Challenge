/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search.mysqls;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author metar
 */
public class Search4 extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */                   
            //searchs4から情報を受け取り、そのデータを使用してレコード更新。結果を表示させる。
            //XAMPP側でMysql起動していなければ"接続成功"と表示されない
            //データベース操作する為、接続とSQL文と実行設定
              Connection db_con = null;      
              PreparedStatement db_st = null;
              ResultSet db_data = null;
              
            //searchs4.jspからデータを受け取る
            //各項目 profilesID,name,tell,age,birthdayデータをgetParameterで受け取る
              String profilesID = request.getParameter("profilesID");
              String name = request.getParameter("name");
              String tell = request.getParameter("tell");
              String age = request.getParameter("age");
              String birthday = request.getParameter("birthday");
            
            //一部のString型の数字をラッパークラスでint型に戻す
            //対象：profilesID,age
              int profilesint = Integer.parseInt(profilesID);
              int ageint = Integer.parseInt(age);
            //前回作ったテーブルコマンド
            //CREATE TABLE profiles(profilesID int,name varchar(255),tell varchar(255),age int,birthday date);
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //"jdbc:" + データベースの種類 + "://" + 接続先 + ":" + ポート番号 + "/" + データベース名 で接続先を指定
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","saito","sigumasu");
                if(db_con != null){
                    //接続成功
                    System.out.print("接続成功"); 
                }
                //db_st=db_con.prepareStatementで？を設定し、次の文で？に対して何を追加するのかを決める。
                db_st = db_con.prepareStatement("UPDATE profiles SET name = ?,tell = ?,age = ?,birthday = ? WHERE profilesID = ?");
                //nameを指定
                db_st.setString(1,name);
                //tellを指定
                db_st.setString(2,tell);
                //age(Integerで変換後)を指定
                db_st.setInt(3,ageint);
                //birthdayを指定
                db_st.setString(4,birthday);
                //profilesID(Integerで変換後)を指定
                db_st.setInt(5,profilesint);
                 //?に対する設定が終わったら、db_st.executeUpdate();でデータベースに実行。
                db_st.executeUpdate();
                
                                
                out.print("<h2>データ更新しました。データを表示します。</h2><br>");
                
                db_data = db_st.executeQuery("SELECT * FROM profiles");
                //while文でループ nextメソッドでデータがある限り取得し続る。そのデータをgetStringで表示する。
                while(db_data.next()){
                        out.print("profilesID："+ db_data.getString("profilesID"));
                        out.print(" name："+db_data.getString("name")); 
                        out.print(" tell："+db_data.getString("tell"));
                        out.print(" age:"+db_data.getString("age"));
                        out.print(" birthday:"+db_data.getString("birthday"));
                        out.print("<br>");
                }
                //実行終了したら、データベースを閉じる
                db_data.close();
                db_st.close();
                db_con.close();
                
                }catch(Exception e){
                //接続失敗 原因確認
                out.println("接続時にエラーが発生<br>"+e.getMessage()); 
                }finally{
                    if(db_con != null){
                        try{
                            db_con.close();
                        }catch(Exception e_con){
                            System.out.println(e_con.getMessage());
                        }
                    }
                }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>データ更新</title>");            
            out.println("</head>");
            out.println("<body>");
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
