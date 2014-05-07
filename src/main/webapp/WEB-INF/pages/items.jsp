<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<spring:url scope="page" var="bootstrapStylesheetUrl"
            value="/resources/css/bootstrap.css"/>
<spring:url scope="page" var="bootstrapResponsiveStylesheetUrl"
            value="/resources/css/bootstrap-responsive.css"/>
<spring:url scope="page" var="bootstrapJavascriptUrl"
            value="/resources/js/bootstrap.js"/>
<spring:url scope="page" var="jqueryUrl"
            value="/resources/js/jquery-1.9.1.min.js"/>

<html lang="en">
<head>
    <title>Building Details</title>

    <!-- Le styles -->
    <link rel="stylesheet" href="${pageScope.bootstrapStylesheetUrl}"/>
    <style>
        body {
            padding-top: 60px;
            /* 60px to make the container go all the way to the bottom of the topbar */
        }
    </style>
    <link rel="stylesheet"
          href="${pageScope.bootstrapResponsiveStylesheetUrl}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="UWT Delivery On Demand System" content="">
    <meta name="Sky Moon" content="">

</head>
<body>
<%@include file="/WEB-INF/pages/menu.jspf" %>

<div class="container">

    <h1>Item List</h1>

    <form name="deletionForm" method="post">


        <c:if test="${not empty itemList}">
            <table class="table table-striped">
                <tr>
                    <th>Item ID</th>
                    <th>Item Name</th>
                    <th>Item Type</th>
                    <th>Quantity on Hand</th>
                </tr>
                <c:forEach items="${itemList}" var="item">
                    <tr>
                        <td><a href="<c:url value="/items/details/${item.itemId}"/>">${item.itemId}</a></td>
                        <td>${item.itemName}</td>
                        <td>${item.itemType.itemTypeName}</td>
                        <td>${item.quantityOnHand}</td>
                    </tr>
                </c:forEach>
            </table>
            <button id="delete"> Delete</button>
        </c:if>

    </form>

</div>
<!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageScope.jqueryUrl}"></script>
<script src="${pageScope.bootstrapJavascriptUrl}"></script>


</body>
</html>
