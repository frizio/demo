<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Student form</title>
</head>
<body>
  <h2>Student Confirmation Page</h2>
  <h4>The student from ${student.country} is confirmed: ${student.firstName} ${student.lastName}. Favorite Language: ${student.favoriteLanguage}.</h4>
  Preferred Operating Systems:
  <ul>
    <c:forEach var="temp" items="${student.operatingSystems}">
      <li> ${temp} </li>
    </c:forEach>
  </ul>

</body>
</html>