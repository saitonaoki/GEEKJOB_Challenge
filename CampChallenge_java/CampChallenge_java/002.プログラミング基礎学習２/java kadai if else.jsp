<%-- 
    Document   : java kadai if
    Created on : 2017/05/02, 12:56:27
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int a = 1;

if ( a ==1){
    out.print("これは1です！");
}else if( a == 2){
    out.print("プログラミングキャンプ！");

}else{
    out.print("その他です！");

}

%>
