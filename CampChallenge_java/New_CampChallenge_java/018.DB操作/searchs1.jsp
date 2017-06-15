<%-- 
    Document   : searchs1
    Created on : 2017/06/14, 16:53:04
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC テーブル検索（テスト）</title>
    </head>
    <form action="Search1" method="get"> 
    <body>
        <h2>JDBC 検索フォーム（名前検索）</h2><br>
        <p>JDBCを利用して、MySQLのテーブル検索を行います。</p><br>
        <p>名前を入力して、送信してください。</p><br>
        名前<br>
        <input type="text" name="name">
        <input type="submit" name="butSubmit" value="送信する">
    </body>
</html>
