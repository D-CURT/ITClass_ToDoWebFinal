<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
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
          <p>
              Hello, <b>friend</b>! My name is <b>Aleksei</b>. I glad to welcome you here.<br>
              The application is realizing a daily calendar functionality:
          </p>
          <ul>
              <li>Making new tasks for days on your choice;</li>
              <li>An any task you can edit;</li>
              <li>Fix / unfix it;</li>
              <li>Move it to recycle bin;</li>
              <li>Restore it;</li>
              <li>Remove it;</li>
          </ul>
          <p>Couple comments concerning some application`s functions:</p>
          <ul>
              <li>
                  <p>You can search tasks by a <b>current date or later</b> only.</p>
              </li>
              <li>
                  <p>All tasks, that you can`t complete in time and did`t fix it,
                      will move to <b>recycle bin</b> automatically;</p>
              </li>
          </ul>
      </div>
      <hr>
      <%@include file="footer.jsp"%>
  </div>
  </body>
</html>
