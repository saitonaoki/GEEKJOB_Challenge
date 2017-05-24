/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprofile;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author metar
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class profile extends HttpServlet {
public class profile {
    
void myprofile(PrintWriter pw){
pw.print("私の名前は、齋藤尚輝です<br>");
pw.print("趣味はゲームと小説を読むことです<br>");
pw.print("得意な事は走ることです");
}
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    PrintWriter out = response.getWriter();

    /**
    for(int i =1; i<=10;i++){
    myprofile(out);
    }
    
   }
}