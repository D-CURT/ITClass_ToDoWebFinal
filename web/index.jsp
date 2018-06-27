

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <%@include file="header.jsp"%>
  <hr>
   <c:if test="${not empty errorMessage}">
     <c:out value="${errorMessage}"/>
   </c:if>
  Application tools
  <hr>
  <%@include file="footer.jsp"%>
  </body>
</html>
