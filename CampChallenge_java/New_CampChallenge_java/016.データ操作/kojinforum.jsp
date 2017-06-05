<%-- 
    Document   : kojinforum
    Created on : 2017/06/05, 16:20:00
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>個人入力フォーラム　テスト</title>
    </head>
    <body>
        <form action="Seesion2" method="get"> <!--form先を指定して、サーブレット側で使用できるようにする-->
        <h2>個人入力 フォーラム（セッション式）</h2>
        名前<br>
        <input type="text" name="name">
        <br><br>
        性別<br>
        <input type="radio" name="rdSex" value="男性">男性
        <input type="radio" name="rdSex" value="女性">女性
        <br><br>
        趣味<br>
        <input type="text" name="hobby">
        <br><br>
        <input type="submit" name="butSubmit" value="送信する">
    </body>
</html>
