<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Demo Spring Security</title>
</head>
<body>
  <h2>Demo Spring MVC + Security.</h2>
  <hr>
  <p>Username: <security:authentication property="principal.username"/></p>
  <p>Roles (Autorities): <security:authentication property="principal.authorities"/></p>
  <hr>
  <security:authorize access="hasRole('MANAGER')">
    <p><a href="${pageContext.request.contextPath}/leaders">Leadership Page</a> (Only for Manager) </p>
  </security:authorize>
  <security:authorize access="hasRole('ADMIN')">
    <p><a href="${pageContext.request.contextPath}/systems">Systems Page</a> (Only for Admin) </p>
  </security:authorize>
  <hr>
  <!-- Add a logout button -->
  <form:form action="${pageContext.request.contextPath}/logout" method="POST">
    <input type="submit" value="Logout" />
  </form:form>
</body>
</html>