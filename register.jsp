<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jspHeader.jsp"%>

<%--会員登録入力画面 --%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/static/css/header_bottom_style.css" rel="stylesheet">
<link rel="icon" href="${pageContext.request.contextPath}/static/img/favicon.ico">
<script src="https://kit.fontawesome.com/6e46f1a97e.js" crossorigin="anonymous"></script>

<title>会員登録入力</title>


</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/pageHeader.jsp" />
	</header>
	<h1>マッチングサービス 会員登録</h1>
	
	<div class="message">
  <c:forEach var="message" items="${messageList}">
    <c:out value="${message}"/><br>
  </c:forEach>
  </div>
	
	<form action="${pageContext.request.contextPath}/public/RegisterConfirmation" method="post">

		<table class="input-table">

			<tr>
				<td class="form-label">ユーザーID</td>
				<td><input type="text" name="id" value="<c:out value="${usersForm.id}" />"></td>
			</tr>
			<tr>
				<td class="form-label">ニックネーム</td>
				<td><input type="text" name="name"
					value="<c:out value="${usersForm.name}" />"></td>
			</tr>
			<tr>
				<td class="form-label">パスワード</td>
				<td><input type="password" name="password" value="<c:out value="${usersForm.password}" />"></td>
			</tr>
			<tr>
				<td class="form-label">性別</td>
				<td><c:forEach var="gender" items="${usersForm.genderList}">
						<c:set var="checkdString" value="" />
						<c:if test="${usersForm.gender == gender.key}">
							<c:set var="checkedString" value="checked='checked'" />
						</c:if>
						<label><input type="radio" name="gender"
							value="${gender.key}" ${checkedString}>${gender.value}</label>
					</c:forEach></td>
			</tr>
			<tr>
			<tr>
				<td class="form-label">居住地</td>
				<td><select name="region">
						<c:forEach var="region" items="${usersForm.regionList}">
							<c:set var="selectedregion" value="" />
							<c:if test="${usersForm.region == region.key}">
								<c:set var="selectedregion" value="selected='selected'" />
							</c:if>
							<option value="${region.key}" ${selectedregion}>${region.value}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td class="form-label">生年月日</td>
				<td><input type="date" name="birthday" id="birthday"min="1907-01-01" max="2004-12-31" required>
			<tr>
				<td class="form-label">自己紹介</td>
				<td><textarea rows="5" cols="30" maxlength="300"name="introduction" value="introduction"></textarea></td>
			</tr>
			<tr>
				<td class="form-label">アクティビティ</td>
				<td><c:forEach var="activity" items="${usersForm.activityList}">
						<c:set var="checkdString" value="" />
						<c:if test="${usersForm.activity == activity.key}">
							<c:set var="checkedString" value="checked='checked'" />
						</c:if>
						<label><input type="radio" name="activity"
							value="${activity.key}" ${checkedString}>${activity.value}</label>
					</c:forEach></td>
			</tr>
		</table>

		<button type="submit" name="action" value="register" id="submit-button">確認画面へ</button>
	</form>

</body>
</html>
