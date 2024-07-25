<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reset Password</title>
    <!-- Include necessary CSS or styles -->
</head>
<body>
    <h1>Reset Password</h1>
    <c:if test="${not empty errorMessage}">
        <div class="error-message">${errorMessage}</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/reset-password">
        <input type="hidden" name="token" value="${param.token}" />
        <input type="password" id="password" name="password" placeholder="Enter new password" required/>
        <br/><br/>
        <button type="submit">Reset Password</button>
    </form>
</body>
</html>
