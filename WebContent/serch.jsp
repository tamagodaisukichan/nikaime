<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.SerchBean" scope="request" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>検索結果</h3>
	ID：<%=bean.getKaiinId() %>　名前：<%=bean.getKaiinName() %>
	　性別：<%=bean.getSex()%>　登録日：<%=bean.getTourokubi()%><br>
	<br>
	<a href ='/KaiinDBWeb/index.html'>メニューに戻る</a>
</body>
</html>