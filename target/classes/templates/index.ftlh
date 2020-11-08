<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>wstest</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
</head>
<body>

<div id="alter" style="display: none">
    <label>你有新的作业</label>
</div>
<script>

        var websocket = null;
        if ('WebSocket' in window) {
            websocket = new WebSocket('ws://localhost:8080/webSocket');
        } else {
            alert('该浏览器不支持websocket');
        }

        websocket.onopen = function (event) {
            console.log('建立连接');
        };


        websocket.onclose = function (event) {
            console.log('连接关闭');
        };

        websocket.onmessage = function (event) {
            console.log('收到消息' + event.data);
            //弹窗提醒，播放音乐
            alter = document.getElementById("alter");
            alter.style.display = "block";
            alter.innerText = event.data;

        };

        websocket.onerror = function () {
            alert('websocket通信发生错误');
        };
        window.onbeforeunload = function () {
            websocket.close;
        };


</script>
</body>
</html>