
<!DOCTYPE html>
<html>
<head>
    <title>BOOKING</title>
</head>
<body>
<h1>BOOKING</h1><hr>
<#if user.roles == "ADMIN">
    <a href="/admin-orders">Панель администратора</a>
</#if>
<hr>
<#if user.roles == "USER">
    <a href="/active-orders/${user.id}">Мои заказы</a>
    <h4>Наши услуги</h4>
    <#list orders as order>
        <div>
            <p><b>${order.title}</b> ${order.price} руб. | <a href = "/order/${order.id}">Подробнее...</a> </p>
        </div>
    </#list>
    <hr>
</#if>


</body>
</html>