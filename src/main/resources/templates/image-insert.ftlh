<!DOCTYPE html>
<html>
<head>
    <title>BOOKING</title>
</head>
<body>
<h1>BOOKING</h1><hr>
<form action="/image/create/${order.id}" method="post", enctype="multipart/form-data">
    Фото: <input type="file" name="file"/> <br><br>
    <input type = "submit" value = "Добавить фото"/>
</form>
<hr>
</body>
</html>