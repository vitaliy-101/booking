
<!DOCTYPE html>
<html>
<head>
    <title>BOOKING</title>
</head>
<body>
<h1>BOOKING</h1><hr>
<h4>Наши услуги</h4>
<#list orders as order>
    <div>
        <p><b>${order.title}</b> ${order.price} руб. | <a href = "/admin-order/${order.id}">Подробнее...</a> </p>
    </div>
</#list>
<hr>
<h3>Создать новую услугу</h3>
<form action="/admin-order/create" method="post">
    Название услуги: <input type = "text" name = "title"/><br><br>
    Описание услуги: <input type = "text" name = "description"/><br><br>
    Цена услуги: <input type = "number" name = "price"/><br><br>
    Длительность услуги: <input type = "number" name = "duration"/><br><br>
    <input type = "submit" value = "Добавить услугу"/>
</form>
</body>
</html>