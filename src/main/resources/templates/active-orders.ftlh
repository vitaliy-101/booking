<!DOCTYPE html>
<html>
<head>
    <title>BOOKING</title>
</head>
<body>
<h1>BOOKING</h1><hr>

<#list activeOrders as activeOrder>
    <div>
        <p><b>${activeOrder.getTimeOrder()}</p>
    </div>
</#list>
<hr>
</body>
</html>