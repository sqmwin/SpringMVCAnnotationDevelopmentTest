<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2017-12-27
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
用户名:${myusername}<br/>
密码:${mypassoword}  <br/>
<hr/>
用户:${myUser}<br/>
用户名:${myUser.myusername}<br/>
密码:${myUser.mypassword}  <br/>
信息:${myUser.userInformation}<br/>
真实姓名:${myUser.userInformation.name}<br/>
年龄:${myUser.userInformation.age}  <br/>
<hr/>
姓名:${myname}<br/>
年龄:${myage}<br/>
</body>
</html>
