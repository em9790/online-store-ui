<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<spring:url var="css" value="/resources/css"/>
<spring:url var="vendor" value="/resources/vendor"/>
<spring:url var="images" value="/resources/images"/>
<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Store- ${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${vendor}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${vendor}/bootstrap/css/bootstrap-cosmo-theme.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="${css}/shop-homepage.css" rel="stylesheet">

    <script>
        window.menu ='${title}'
    </script>

</head>

<body>
<div class="wrapper">
    <div class="page-content">
<!-- Navigation -->
<%@include file="./shared/topNavigation.jsp"%>

<!-- Page Content -->
<!-- Loading home content -->
<c:if test="${userClickHome == true}" >
<%@include file="home.jsp"%>
</c:if>

<!-- Only user click about -->
<c:if test="${userClickAbout == true}" >
    <%@include file="about.jsp"%>
</c:if>

<!-- Only user click contact -->
<c:if test="${userClickContact == true}" >
    <%@include file="contact.jsp"%>
</c:if>

        <c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}" >
            <%@include file="listProducts.jsp"%>
        </c:if>
    </div>
<!-- /.container -->

<!-- Footer -->
<%@include  file="./shared/footer.jsp"%>

</div>
<!-- Bootstrap core JavaScript -->
<script src="${vendor}/jquery/jquery.min.js"></script>
<script src="${vendor}/bootstrap/js/bootstrap.bundle.min.js"></script>

<!--Self code javascript -->
<script src="${vendor}/myApp.js" ></script>
</body>

</html>

