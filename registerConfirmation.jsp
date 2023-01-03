<%@ page import="java.util.Arrays"%>
<%@ page import="jp.co.masquerade.form.UsersForm"%>


<%@ page 
  language="java" 
	contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
 <%@ include file="/WEB-INF/jspHeader.jsp" %>

<%--会員登録確認画面 --%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/static/css/header_bottom_style.css" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
<script src="https://kit.fontawesome.com/6e46f1a97e.js" crossorigin="anonymous"></script>

<title>会員登録確認画面</title>
</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/pageHeader.jsp"/>
	</header>
	<h1>会員登録確認画面</h1>
	<form action="${pageContext.request.contextPath}/public/RegisterCompleteServlet" method="post">
	
		<table class="input-table">
		
			<tr>
				<td class="form-label">ユーザーID</td>
				<td>
				  <input type="text" name="id" value="<c:out value="${usersForm.id}" />" disabled>
				</td>
			</tr>
			<tr>
				<td class="form-label">ニックネーム</td>
				<td>
					<input type="text" name="id" value="<c:out value="${usersForm.name}" />" disabled>
				</td>
			</tr>
			<tr>
				<td class="form-label">パスワード</td>
				<td>
					<input type="password" name="password" value="<c:out value="${usersForm.password}" />" disabled>
				</td>
			</tr>
			<tr>
				<td class="form-label">性別</td>
					<td>
					<c:if test="${usersForm.gender == 'G001'}">
						男性
					</c:if>
					<c:if test="${usersForm.gender == 'G002'}">
						女性
					</c:if>
					<c:if test="${usersForm.gender == 'G003'}">
						どちらでもない
					</c:if>
				</td>
			</tr>
			<tr>
				<td class="form-label"><label for="region">居住地</label></td>
				<td>
					<input type="text" name="regionName" value="<c:out value="${usersForm.regionName}" />" disabled>
				</td>
			</tr>
			<tr>
				<td class="form-label"><label for="birthday">生年月日</label></td>
				<td>
					<input type="text" name="birthday" value="<c:out value="${usersForm.birthday}" />" disabled>
				</td>
			</tr>
			<tr>
				<td class="form-label">自己紹介</td>
				<tr>
				<td class="form-label">アクティビティ</td>
				<td>
					<c:if test="${usersForm.activity == 'A001'}">
						インドア
					</c:if>
					<c:if test="${usersForm.activity == 'A002'}">
						アウトドア
					</c:if>
					<c:if test="${usersForm.activity == 'A003'}">
						どちらも
					</c:if>
				</td>
			</tr>
			<tr>
        <td colspan="2" class="form-title">
					<button type="submit" name="action" value="back">修正する</button>
			    <button type="submit" name="action" value="register" id="submit-button">登録する</button>
			  </td>
			</tr>
		</table>
		
		<%-- 送信用データ、画面に表示されない --%>
   	<%-- 隠し要素 --%>
		<input type="hidden" name="id"                value="<c:out value="${usersForm.id}" />">
		<input type="hidden" name="name"              value="<c:out value="${usersForm.name}" />">
		<input type="hidden" name="password"            value="<c:out value="${usersForm.password}" />">
		<input type="hidden" name="gender"          value="<c:out value="${usersForm.gender}" />">
		<input type="hidden" name="region"        value="<c:out value="${usersForm.region}" />">
		<input type="hidden" name="birthday"     value="<c:out value="${usersForm.birthday}" />">
		<input type="hidden" name="introduction"     value="<c:out value="${usersForm.introduction}" />">
		<input type="hidden" name="activity"     value="<c:out value="${usersForm.activity}" />">
	
	</form>

</body>
</html>
