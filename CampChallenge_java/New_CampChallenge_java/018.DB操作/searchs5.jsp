<%-- 
    Document   : searchs5
    Created on : 2017/06/16, 15:15:15
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC テーブル複合検索（テスト）</title>
    </head>
    <form action="Search5" method="get"> 
    <body>
        <h2>JDBC 検索フォーム（複合検索）</h2><br>
        <p>JDBCを利用して、MySQLのテーブル検索（完全一致）を行います。</p><br>
        <p>各項目を記入して検索してください。</p><br>
        名前<!--name--><br>
        <input type="text" name="name" placeholder="例：太郎"><br>
        年齢<!--age--><br>
        <input type="number" name="age"placeholder="例：20"><br>
        誕生日<!--birthday--><br>
        <input type="number" name="birthday"placeholder="例：19960101">
        <input type="submit" value="検索">
    </body>
</html>
