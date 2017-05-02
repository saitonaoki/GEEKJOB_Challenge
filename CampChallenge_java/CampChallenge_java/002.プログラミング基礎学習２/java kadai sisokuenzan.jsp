<%-- 
    Document   : java kadai sisokuenzan
    Created on : 2017/05/02, 11:43:43
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int a = 100;
final int  b = 100;

int tasu =  a + b ;
int hiku =  a - b ;
int kake =  a * b ;
int waru =  a / b ;

out.print("四則演算課題テスト"+"<br>"+"変数宣言 a = 100 定数宣言 b = 100"+"<br>");
out.print("a + b ="+tasu+"<br>");
out.print("a - b ="+hiku+"<br>");
out.print("a * b ="+kake+"<br>");
out.print("a / b ="+waru+"<br>");

%>
