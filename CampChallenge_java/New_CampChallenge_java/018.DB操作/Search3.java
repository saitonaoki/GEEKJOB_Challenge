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
public class Search3 extends HttpServlet {

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
            //searchs3から情報を受け取り、そのデータを使用して削除。削除結果を表示させる。
            //XAMPP側でMysql起動していなければ"接続成功"と表示されない
            //データベース操作する為、接続とSQL文と実行設定
              Connection db_con = null;      
              PreparedStatement db_st = null;
              ResultSet db_data = null;
              
            //searchs3.jspからデータを受け取る
            //各項目 typesとtextデータをgetParameterで受け取る
            String types = request.getParameter("types");
            String textstr = request.getParameter("text");
            
            //textの中身を変える為に、int型を用意（初期化も行う）
            int textint = 0 ;
            
            //前回作ったテーブルコマンド
            //CREATE TABLE profiles(profilesID int,name varchar(255),tell varchar(255),age int,birthday date);
            //typesがprofilesIDならば、textsの中身をString型からInt型に変えて、MySQL側に対応
            if(types.equals("profilesID")){
                textint = Integer.parseInt(textstr);
                
            //typesがageならば、textsの中身をString型からInt型に変えて、MySQL側に対応
            }else if( types == "age"){
                textint = Integer.parseInt(textstr);
            }
             
            try{
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //"jdbc:" + データベースの種類 + "://" + 接続先 + ":" + ポート番号 + "/" + データベース名 で接続先を指定
                db_con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","saito","sigumasu");
                if(db_con != null){
                    //接続成功
                    System.out.print("接続成功"); 
                }
               //db_st=db_con.prepareStatementで？を設定し、次の文で？に対して何を追加するのかを決める。
               //switch文で中身を見て、処理を分ける。
               switch(types){
                   case "profilesID":
                       
                       db_st = db_con.prepareStatement("DELETE FROM profiles WHERE profilesID = ?");
                       
                       db_st.setInt(1,textint);
                       
                       break;
                   case "name":
                       
                       db_st = db_con.prepareStatement("DELETE FROM profiles WHERE name = ?");
                       
                       db_st.setString(1,textstr);
                       
                       break;
                   case"tell":
                       
                       db_st = db_con.prepareStatement("DELETE FROM profiles WHERE tell = ?");
                       
                       db_st.setString(1,textstr);
                       
                       break;
                   case"age":
                       
                       db_st = db_con.prepareStatement("DELETE FROM profiles WHERE age = ?");
                       
                       db_st.setInt(1,textint);
                       
                       break;
                   case"birthday":
                       
                       db_st = db_con.prepareStatement("DELETE FROM profiles WHERE birthday = ?");
                       
                       db_st.setString(1,textstr);
                       
                       break;
               }
                //MySQL側をデータ更新
                db_st.executeUpdate();
                
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
            out.println("<title>データ削除</title>");            
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
