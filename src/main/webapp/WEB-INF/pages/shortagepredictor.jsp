<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url scope="page" var="bootstrapStylesheetUrl"
            value="/resources/css/bootstrap.css"/>
<spring:url scope="page" var="bootstrapResponsiveStylesheetUrl"
            value="/resources/css/bootstrap-responsive.css"/>
<spring:url scope="page" var="datePickerStylesheetUrl"
            value="/resources/css/bootstrap-datepicker.css"/>
<spring:url scope="page" var="bootstrapJavascriptUrl"
            value="/resources/js/bootstrap.js"/>
<spring:url scope="page" var="jqueryUrl"
            value="/resources/js/jquery-1.9.1.min.js"/>
<spring:url scope="page" var="datepickerJsUrl"
            value="/resources/js/bootstrap-datepicker.js"/>

<html lang="en">
<head>
    <title>Item Shortage Predictor</title>

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
    <link rel="stylesheet" href="${pageScope.datePickerStylesheetUrl}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="UWT Delivery On Demand System" content="">
    <meta name="Sky Moon" content="">

</head>
<body>
<%@include file="/WEB-INF/pages/menu.jspf" %>

<div class="container">

    <h1>Item Shortage Predictor</h1>

    <h3>Sorry, this has not fully implemented</h3>

    <form:form id="shortagePredictionCriteria" method="POST"
               modelAttribute="shortagePredictionCriteria">
    <fieldset style="margin-bottom: 5px;">
        <h5>Reserve Ratio</h5>
        <form:input path="reserveRatio"/> %
        <h5>Expected Delivery Date</h5>
        <form:input path="expectedDeliveryDate"/>
    </fieldset>
    <p>
        <button type="submit">Submit</button>
        </form:form>

</div>
<!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageScope.jqueryUrl}"></script>
<script src="${pageScope.bootstrapJavascriptUrl}"></script>
<script src="${pageScope.datepickerJsUrl}"></script>
<script>
    $("#expectedDeliveryDate").datepicker();
</script>

</body>
</html>
