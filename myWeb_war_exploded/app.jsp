<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--当前页面获取应用上下文，项目名称--%>
<c:set value="${pageContext.request.contextPath}" var="appPath"/>
<c:out value="${appPath}"/>


