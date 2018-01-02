<%--
  Created by IntelliJ IDEA.
  User: sqm
  Date: 2017-12-26
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
      <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
      <%--<script type="text/javascript">--%>
          <%--$(function () {--%>
              <%--$("button").onclick(function () {--%>
                  <%--$.ajax({--%>
                      <%--url: "${pageContext.request.contextPath}/my-ajax.do",--%>
                      <%--data: {--%>
                          <%--myusername: "sqm",--%>
                          <%--mypassword: "win",--%>
                          <%--name:"song",--%>
                          <%--age: 23--%>
                      <%--},--%>
                      <%--success: function (data) {--%>
                          <%--var myJson = JSON.parse(data);--%>
                          <%--alert(myJson.myusername+" "+myJson.mypassword + " "+myJson.name + " " + myJson.age);--%>
                      <%--}--%>
                  <%--});--%>
              <%--});--%>
          <%--});--%>
      <%--</script>--%>
      <script type="text/javascript">
          $(function () {
              $("button").click(function () {
                  $.ajax({
                      url: "test/return-number.do",
                      success: function (data) {
                          alert(data);
                      }
                  });
              });
          });
      </script>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/test/my-controller.do">controller</a><br/>
  <a href="${pageContext.request.contextPath}/test/my-annotation-controller.do">annotation-controller</a><br/>
  <a href="${pageContext.request.contextPath}/test/some/1/some-what-ever.do">some</a><br/>
  <a href="${pageContext.request.contextPath}/test/other/what-ever-other.do">other</a><br/>
   <form action="${pageContext.request.contextPath}/test/regist.do" method="post">
       <table>
           <tr>
               <td>用户名</td>
               <td><input type="text" name="myusername"></td>
           </tr>
           <tr>
               <td>密码</td>
               <td><input type="password" name="mypassword"></td>
           </tr>
           <tr>
               <td><input type="submit" value="注册"></td>
           </tr>
       </table>
   </form>
  <form action="${pageContext.request.contextPath}/regist.do" method="post">
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="myusername"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="mypassword"></td>
          </tr>
          <tr>
              <td>真实姓名</td>
              <td><input type="text" name="userInformation.name"></td>
          </tr>
          <tr>
              <td>年龄</td>
              <td><input type="text" name="userInformation.age"></td>
          </tr>
          <tr>
              <td><input type="submit" value="注册User"></td>
          </tr>
      </table>
  </form>
  <a href="${pageContext.request.contextPath}/sqm/25/regist.do">pathVariable</a><br/>
  <hr/>
  <form action="${pageContext.request.contextPath}/return-string.do" method="post">
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="myusername"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="mypassword"></td>
          </tr>
          <tr>
              <td>真实姓名</td>
              <td><input type="text" name="userInformation.name"></td>
          </tr>
          <tr>
              <td>年龄</td>
              <td><input type="text" name="userInformation.age"></td>
          </tr>
          <tr>
              <td><input type="submit" value="returnString"></td>
          </tr>
      </table>
  </form>
  <hr/>
  <form action="${pageContext.request.contextPath}/return-void.do" method="post">
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="myusername"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="mypassword"></td>
          </tr>
          <tr>
              <td>真实姓名</td>
              <td><input type="text" name="userInformation.name"></td>
          </tr>
          <tr>
              <td>年龄</td>
              <td><input type="text" name="userInformation.age"></td>
          </tr>
          <tr>
              <td><input type="submit" value="returnVoid"></td>
          </tr>
      </table>
  </form>
  <hr/>
  <%--<button name="button">提交ajax请求</button>--%>
  <button>返回object</button>
  <hr/>
  <form action="${pageContext.request.contextPath}/test/forward.do" method="post">
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="myusername"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="mypassword"></td>
          </tr>
          <tr>
              <td>真实姓名</td>
              <td><input type="text" name="userInformation.name"></td>
          </tr>
          <tr>
              <td>年龄</td>
              <td><input type="text" name="userInformation.age"></td>
          </tr>
          <tr>
              <td><input type="submit" value="forward"></td>
          </tr>
      </table>
  </form>
  <hr/>
  <form action="${pageContext.request.contextPath}/test/some.do" method="post">
      <table>
          <tr>
              <td>用户名</td>
              <td><input type="text" name="myusername"></td>
          </tr>
          <tr>
              <td>密码</td>
              <td><input type="password" name="mypassword"></td>
          </tr>
          <tr>
              <td>真实姓名</td>
              <td><input type="text" name="userInformation.name"></td>
          </tr>
          <tr>
              <td>年龄</td>
              <td><input type="text" name="userInformation.age"></td>
          </tr>
          <tr>
              <td><input type="submit" value="forward"></td>
          </tr>
      </table>
  </form>
  <hr/>
  </body>
</html>
