<%-- 
    Document   : searchs3
    Created on : 2017/06/15, 16:56:16
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC テーブル　データ追加（テスト）</title>
    </head>
    <form action="Search3" method="get"> 
    <body>
        <h2>JDBC 削除フォーム</h2><br>
        JDBCを利用して、MySQLテーブル　データ削除を行います。<br>
        項目を選択後に入力して、送信してください。<br>
        <h5>※検索に引っかかったものをまとめて消します。</h5>
        
        削除対象検索<!--profilesID--><br><br>
        ・項目を選択<br>
        プロフィールID<input type="radio" name="types" value="profilesID">
        名前<input type="radio" name="types" value="name">
        電話番号<input type="radio" name="types" value="tell">
        年齢<input type="radio" name="types" value="age">
        生年月日<input type="radio" name="types" value="birthday"><br>
        ・項目内容を入力<br>
        <input type="text" name="text" placeholder="入力してください">
        <input type="submit" value="送信">
    </body>
</html>
