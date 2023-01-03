<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
%>
    
<%@ include file="/WEB-INF/jspHeader.jsp" %>

<%--会員登録完了画面 --%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3; url = ${pageContext.request.contextPath}/index.jsp" />
<link href="${pageContext.request.contextPath}/static/css/header_bottom_style.css" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
<script src="https://kit.fontawesome.com/6e46f1a97e.js" crossorigin="anonymous"></script>
<title>会員登録完了</title>
</head>

<body>
		<jsp:include page="/WEB-INF/pageHeader.jsp"/>
		<h1>会員登録完了画面</h1>
		<p>ユーザー登録が完了しました</p>
</body>
</html>
