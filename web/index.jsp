

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "by.itClass.constants.Constants" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <%@include file="header.jsp"%>
  <hr>
   <c:if test="${not empty errorMessage}">
     <c:out value="<%=Constants.ERR_ATR_MESSAGE%>"/>
   </c:if>
  Application tools
  <hr>
  <%@include file="footer.jsp"%>
  </body>
</html>
