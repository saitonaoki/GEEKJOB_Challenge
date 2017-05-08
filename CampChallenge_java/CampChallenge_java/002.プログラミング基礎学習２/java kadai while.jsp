<%-- 
    Document   : java kadai while
    Created on : 2017/05/08, 10:16:57
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
int a = 1000;
int b = 0;

while( a > 100){
    a = a / 2;
    b++;
}

out.print(a+"<br>");
out.print(b + "回ループしました");

%>
