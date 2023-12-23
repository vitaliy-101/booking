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
<h3>Создание заказа</h3>

<form action="/order-info/create/${order.id}" method="post">
    Время заказа: <input type = "datetime-local" name = "date"/><br><br>
    <input type = "submit" value = "Сделать заказ"/>
</form>

<hr>
</body>
</html>