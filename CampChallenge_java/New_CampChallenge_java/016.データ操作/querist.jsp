<%-- 
    Document   : querist
    Created on : 2017/06/02, 15:04:20
    Author     : metar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>スーパーマーケット　レジ</title>
    </head>
    <body>
      <form action="Outquerist" method="get"> <!--formm先を指定して、サーブレット側で使用できるようにする-->
          <h2>レジ　テスト</h2>
          総額(税抜き)<br>
            <input type ="text" name="total">
            <br><br>
            個数<br>
            <input type="text" name="count">
            <br><br>
            タイプ<br>
            <input type="radio" name="type" value="雑貨">雑貨
            <input type="radio" name="type" value="生鮮商品">生鮮商品
            <input type="radio" name="type" value="その他">その他
            <br><br>
            <input type="submit" name="btnSubmit" value="送信する">
    </body>
</html>
