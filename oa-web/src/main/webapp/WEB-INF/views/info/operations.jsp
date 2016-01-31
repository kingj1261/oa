<%@ include file="../common/tag.jsp" %>
<html>
<head>
    <title>整个菜单部分</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content='text/html' http-equiv='content-type'>
</head>
<body>
<div class="all">

    <div>
        <!--顶部消息-->
        <%@ include file="../common/top.jsp" %>

        <!--通知-->
        <%@ include file="../common/message.jsp" %>
    </div>

    <!--左边菜单部分-->
    <div class="contbott clear LeftMenu">
        <%@ include file="../common/left.jsp" %>
    </div>

    <!--弹出层的遮罩层 begin-->
    <div class="mask">&nbsp;&nbsp;</div>
    <!--弹出层的遮罩层 end-->
    <!--操作提示框-->
</div>
</body>
</html>