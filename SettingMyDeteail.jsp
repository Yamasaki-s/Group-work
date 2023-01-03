<%@ page 
  language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  
  <%@ page import="java.util.List" %>
  <%@ include file="/WEB-INF/jspHeader.jsp"%>

<%--会員情報変更画面 --%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<link href="${pageContext.request.contextPath}/static/css/header_top_style.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/6e46f1a97e.js" crossorigin="anonymous"></script>

<title>会員情報変更画面</title>
</head>

<body>
	<header>
		<jsp:include page="/WEB-INF/pageHeaderTop.jsp"/>
	</header>
	
	<h1>会員情報変更画面</h1>
	<form action="${pageContext.request.contextPath}/SettingMyDeteailConfirmationServlet" method="post">
	
	
	<table class="input-table">
		
		<tr>
			<td class="form-label">ユーザID</td>
			  <td><input type="text" disabled  name="id" value="${usersForm.id}"></td>
			  <%--<td><input type="text" name="id" value="${updateForm.id}" />"></td> --%>
		</tr>
		
		<tr>
      <td class="form-label">ニックネーム</td>
         <td><input type="text" name="name" value="${usersForm.name}"></td>
    </tr>
    
    <tr>
     <td class="form-label">パスワード</td>
         <td><input type="text" disabled name="password" value="変更できません"></td>
    </tr>
    
    <tr>
     <td class="form-label">性別</td>
		<td><c:forEach var="gender" items="${usersForm.genderList}">
				<c:set var="checkdString" value="" />
				<c:if test="${usersForm.gender == gender.key}">
				<c:set var="checkedString" value="checked='checked'" />
				</c:if>
				<label><input type="radio" name="gender" value="${gender.key}" ${checkedString}>${gender.value}</label>
				</c:forEach></td>
    </tr>
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
       <td><input type="text" disabled name="birthday" value="変更できません"></td>
    </tr>
    
    <tr>
      <td class="form-label">自己紹介</td>
        <td><input type="text" name="introduction" value="${usersForm.introduction}"></td>
    </tr>
    
     <tr>
		<td class="form-label">アクティビティ</td>
			<td><c:forEach var="activity" items="${usersForm.activityList}">
					<c:set var="checkdString" value="" />
					<c:if test="${usersForm.activity == activity.key}">
					<c:set var="checkedString" value="checked='checked'" />
					</c:if>
					<label><input type="radio" name="activity" value="${activity.key}" ${checkedString}>${activity.value}</label>
					</c:forEach></td>
			</tr>
    </table>
    
		<button type="submit" name="action" value="register" id="submit-button">確認画面へ</button>
	</form>
<jsp:include page="/WEB-INF/pageFooter.jsp"/>

</body>
</html>
