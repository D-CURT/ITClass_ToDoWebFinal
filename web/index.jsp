<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%--<link rel="stylesheet" type="text/css" href="<c:url value='Content/css/style.css'/>">--%>
    <title>To Do Web Final</title>
      <style>
          <%@include file='Content/css/style.css'%>
      </style>
  </head>

  <body>
  <div class="wrapper">
      <%@include file="header.jsp"%>
      <hr>
      <c:if test="${not empty errorMessage}">
          <p style="color: red"><c:out value="${errorMessage}"/></p>
      </c:if>
      <div class="content">
          Application tools
      </div>
      <hr>
      <%@include file="footer.jsp"%>
  </div>
  </body>
</html>
