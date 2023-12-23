<!DOCTYPE html>
<html>
<head>
    <title>BOOKING</title>
</head>
<body>
<h1>BOOKING</h1><hr>

<h4>Подробная информация</h4>
<#list order.images as img>
    <img src="images/${img.id}" height="60px" /><br><br>
</#list>
<b>Название услуги: </b>${order.title}<br>
<b>Цена услуги: </b>${order.price}<br>
<b>Длительность услуги: </b>${order.duration}<br>
<b>Описание услуги: </b>${order.description}<br>

<hr>
<form action="/image/create/${order.id}" method="post", enctype="multipart/form-data">
    Фото: <input type="file" name="file"/> <br><br>
    <input type = "submit" value = "Добавить фото"/>
</form>
<hr>
<form action="/admin-order/delete/${order.id}" method="post">
    <input type = "submit" value = "Удалить услугу"/>
</form>
</body>
</html>