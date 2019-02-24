<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored ="false" %>
<html>
<head>
    <title>Notebook</title>
</head>
<body>

<h1>Your notebook:</h1><br />

<h2>Add user</h2><br />

<form method="post" action="/users">
<table>
    <tr><td>Login:</td><td>              <label><input type="text" name="login" value="tolik"></label><br></td></tr>
    <tr><td>First name:</td><td>         <label><input type="text" name="firstName"></label><br></td></tr>
    <tr><td>Last name:</td><td>          <label><input type="text" name="lastName"></label><br></td></tr>
    <tr><td>Middle name:</td><td>        <label><input type="text" name="middleName"></label><br></td></tr>
    <tr><td>Comment:</td><td>            <label><input type="text" name="comment"></label><br></td></tr>
    <tr><td>Groups:</td><td>             <label><input type="text" name="groups"></label><br></td></tr>
    <tr><td>Home phone number:</td><td>  <label><input type="text" name="homePhone"></label><br></td></tr>
    <tr><td>Cell phone number:</td><td>  <label><input type="text" name="cellPhone"></label><br></td></tr>
    <tr><td>Second cell phone:</td><td>  <label><input type="text" name="cellPhone2"></label><br></td></tr>
    <tr><td>E-mail:</td><td>             <label><input type="text" name="email"></label><br></td></tr>
    <tr><td>Skype name:</td><td>         <label><input type="text" name="skypeName"></label><br></td></tr>
    <tr><td><b>Address:</b><br></tr>
    <tr><td>Index:</td><td>              <label><input type="text" name="index"></label><br></td></tr>
    <tr><td>City:</td><td>               <label><input type="text" name="city"></label><br></td></tr>
    <tr><td>Street:</td><td>             <label><input type="text" name="street"></label><br></td></tr>
    <tr><td>House:</td><td>              <label><input type="text" name="house"></label><br></td></tr>
    <tr><td>Appartment:</td><td>         <label><input type="text" name="appartment"></label><br></td></tr>
</table>
    <input type="submit" value="Ok" name="Ok"><br>
</form>

<c:out value="${requestScope.errorHandling}" default="No users were added for now." escapeXml="false" />

<h2>All users:</h2><br />

<c:forEach var="note" items="${requestScope.notes}">
    <c:out value="${note}" default="No users were added for now." escapeXml="false" />
    <hr />
</c:forEach>

</body>
</html>
