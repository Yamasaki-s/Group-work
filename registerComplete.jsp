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
<title>会員登録完了</title>
</head>

<body>
		<jsp:include page="/WEB-INF/pageHeader.jsp"/>
		<h1>会員登録完了画面</h1>
		<p>ユーザー登録が完了しました</p>
</body>
</html>
