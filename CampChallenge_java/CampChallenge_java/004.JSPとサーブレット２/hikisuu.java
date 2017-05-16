/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hikisuu;

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
public class hikisuu {
    void test(String[] args){
        int n = Integer.parseInt(args[0]);
        n = 50;
        
    if(n %2== 0){
            System.out.println("偶数");
        }
    else{
            System.out.println("奇数");
        }
    }
}
