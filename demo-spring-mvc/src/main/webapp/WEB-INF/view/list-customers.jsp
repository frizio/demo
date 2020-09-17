<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Demo Spring MVC + Hibernate Integration</title>
  </head>

  <body>
    <div id="wrapper">
      </div id="header">
        <h4>CRM - Customer Relationship Management</h4>
      </div>
      <div id="container">
        <p>${customers}</p>
        <table>
          <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
          </tr>
          <c:forEach var="customer" items="${customers}">
            <tr>
              <td>${customer.firstName}</td>
              <td>${customer.lastName}</td>
              <td>${customer.email}</td>
            </tr>
          </c:forEach>
        </table>
      </div>
  </body>

</html>
