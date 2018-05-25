<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="bean.ListOutBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員リスト</title>
</head>
<body>
  <h3>会員一覧</h3>
  <table>
  <tr>
  <td>ID</td>
  <td>名前</td>
  <td>性別</td>
  <td>登録日</td>
  </tr>
  <tr>
    <% for (bean.KaiinLineBean klb : bean.getList()) { %>
    <td><%= klb.getKaiinId() %></td>
    <td><%= klb.getKaiinName() %></td>
    <td><%= klb.getSex() %></td>
    <td><%= klb.getTourokubi() %></td>
    <%
      }
    %>
  </tr>
  </table>
  <a href='/KaiinDBWeb/index.html'>メニューに戻る</a>

</body>
</html>