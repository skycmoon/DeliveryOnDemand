<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>Demand History</title>

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
<%@include file="/WEB-INF/pages/menu.jspf" %>
<div class="container">

    <h1>Demand History</h1>

    <form:form modelAttribute="deliveryStatusForm" method="post">
        <c:if test="${not empty deliveryStatusForm}">
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Time Stamp</th>
                    <th>Room Name</th>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Veracity</th>
                    <th>Delivery Status</th>
                </tr>
                <c:set var="demandHistories" value="deliveryStatusForm.demandHistories"/>
                <c:forEach items="${deliveryStatusForm.deliveryStatusList}" var="deliveryStatus" varStatus="status">
                    <tr>
                        <td>${deliveryStatus.demandId}</td>
                        <td>${deliveryStatus.timeStamp}</td>
                        <td>
                            <a href="<c:url value="rooms/details/${deliveryStatus.roomId}"/>">${deliveryStatus.roomName}</a>
                        </td>
                        <td>
                            <a href="<c:url value="items/details/${deliveryStatus.itemId}"/>">${deliveryStatus.itemName}</a>
                        </td>
                        <td>${deliveryStatus.quantity}</td>
                        <c:choose>
                            <c:when test="${deliveryStatus.veracity == '0'}">
                                <td><form:select path="deliveryStatusList[${status.index}].veracity"
                                                 style="width: 110px;">
                                    <form:option value="0" sellected="selected">Undefined</form:option>
                                    <form:option value="1"> True </form:option>
                                    <form:option value="2"> False </form:option>
                                </form:select></td>
                            </c:when>
                            <c:when test="${deliveryStatus.veracity == '1'}">
                                <td>True</td>
                            </c:when>
                            <c:otherwise>
                                <td>False</td>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${deliveryStatus.veracity == '0'}">
                                <td>Veracity Check First</td>
                            </c:when>
                            <c:when test="${deliveryStatus.veracity == '1' && deliveryStatus.deliveryStatus == '0'}">
                                <td><form:select path="deliveryStatusList[${status.index}].deliveryStatus"
                                                 style="width: 110px;">
                                    <form:option value="0" sellected="selected">In Process</form:option>
                                    <form:option value="1"> Delivered </form:option>
                                </form:select></td>
                            </c:when>
                            <c:when test="${deliveryStatus.veracity == '1' && deliveryStatus.deliveryStatus == '1'}">
                                <td>Delivered</td>
                            </c:when>
                            <c:otherwise>
                                <td>No Need</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Update"/>
        </c:if>
    </form:form>
</div>
<!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="${pageScope.jqueryUrl}"></script>
<script src="${pageScope.bootstrapJavascriptUrl}"></script>


</body>
</html>
