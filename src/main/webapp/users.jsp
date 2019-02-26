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
<table var = regexps value="${requestScope.regexps}">
    <tr><td>Login:</td><td>              <label><input type="text" name="login" pattern="${regexps.loginRegexp}" title="format.login" required></label><br></td></tr>
    <tr><td>First name:</td><td>         <label><input type="text" name="firstName" pattern="${regexps.firstNameRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Last name:</td><td>          <label><input type="text" name="lastName" pattern="${regexps.lastNameRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Middle name:</td><td>        <label><input type="text" name="middleName" pattern="${regexps.middleNameRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Comment:</td><td>            <label><input type="text" name="comment" pattern="${regexps.commentRegexp}" title="format"></label><br></td></tr>
    <tr><td>Groups:</td><td>             <label><input type="text" name="groups" pattern="${regexps.groupsRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Home phone number:</td><td>  <label><input type="text" name="homePhone" pattern="${regexps.homePhoneNumberRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Cell phone number:</td><td>  <label><input type="text" name="cellPhone" pattern="${regexps.cellPhoneNumberRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Second cell phone:</td><td>  <label><input type="text" name="cellPhone2" pattern="${regexps.cellPhoneNumber2Regexp}" title="format"></label><br></td></tr>
    <tr><td>E-mail:</td><td>             <label><input type="text" name="email" pattern="${regexps.emailRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Skype name:</td><td>         <label><input type="text" name="skypeName" pattern="${regexps.skypeNameRegexp}" title="format" required></label><br></td></tr>
    <tr><td><b>Address:</b><br></tr>
    <tr><td>Index:</td><td>              <label><input type="text" name="index" pattern="${regexps.indexRegexp}" title="format" required></label><br></td></tr>
    <tr><td>City:</td><td>               <label><input type="text" name="city" pattern="${regexps.cityRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Street:</td><td>             <label><input type="text" name="street" pattern="${regexps.streetRegexp}" title="format" required></label><br></td></tr>
    <tr><td>House:</td><td>              <label><input type="text" name="house" pattern="${regexps.houseRegexp}" title="format" required></label><br></td></tr>
    <tr><td>Appartment:</td><td>         <label><input type="text" name="appartment" pattern="${regexps.appartmentRegexp}" title="format" required></label><br></td></tr>
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
