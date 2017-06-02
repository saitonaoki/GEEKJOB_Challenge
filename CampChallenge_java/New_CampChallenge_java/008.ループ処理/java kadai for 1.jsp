<%-- 
    Document   : java kadai for 1
    Created on : 2017/06/02, 18:17:57
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    long a = 1; //int型ではオーバーして表示出来ないため
    
    for(int i =1; i <=20;i++){
        a = a * 8;
        
        out.print("8の"+i+"乗は"+a+"<br>");
    }


%>