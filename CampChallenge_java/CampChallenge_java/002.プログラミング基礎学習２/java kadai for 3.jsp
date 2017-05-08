<%-- 
    Document   : java kadai for 3
    Created on : 2017/05/08, 10:16:28
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int a =0;

for(int i =0;i <=100;i++){
    a = a + i;
}
out.print("0から100を全部足した結果は"+a+"です");
%>