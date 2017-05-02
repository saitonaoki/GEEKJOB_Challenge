<%-- 
    Document   : java kadai switch 1
    Created on : 2017/05/02, 14:44:31
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    
   int a = 1;
    
 switch(a){
     case 1:
     out.print("one");
     
     break;
             
     case 2:
     out.print("two");
     
     default:
     out.print("想定外");
 
 }

%>