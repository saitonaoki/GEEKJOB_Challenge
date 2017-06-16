<%-- 
    Document   : searchs4
    Created on : 2017/06/15, 19:45:24
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC テーブル　情報更新（テスト）</title>
    </head>
    <form action="Search4" method="get"> 
    <body>
        <h2>JDBC 追加フォーム</h2><br>
        JDBCを利用して、MySQLテーブル　データ更新を行います。<br>
        更新するIDを決めて、更新する内容を入力してください。<br>
        各項目を入力して、送信してください。<br>
        <h5>※各入力フォームに例を載せています。例にそって入力してください。</h5>
        プロフィールID　　※更新するIDを決めます<!--profilesID--><br>
        <input type="number" name="profilesID" placeholder="例：1など"><br><br>
        ※更新する内容を入力してください。<br>
        名前<!--name--><br>
        <input type="text" name="name" placeholder="例：太郎"><br>
        電話番号<!--tell--><br>
        <input type="text" name="tell" placeholder="例：090-4649-0202など"><br>
        歳<!--age--><br>
        <input type="number" name="age"placeholder="例：20"><br>
        誕生日<!--birthday--><br>
        <input type="number" name="birthday"placeholder="例：19920101">
        <input type="submit" value="送信">
    </body>
</html>

