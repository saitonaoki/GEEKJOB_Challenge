<%-- 
    Document   : Simplefactoring
    Created on : 2017/06/02, 16:41:55
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>簡易素因数分解　テスト</title>
    </head>
    <body>
        <form action="Factoring" method="get"><!--formm先を指定して、サーブレット側で使用できるようにする-->
        <h2>簡易素因数分解　テスト</h2>
        素因数分解　数値を入力してください<br>
        <label><input type="number" name="number">
        </label>
        <input type="submit" name="btnSubmit" value="計算開始">
    </body>
</html>
