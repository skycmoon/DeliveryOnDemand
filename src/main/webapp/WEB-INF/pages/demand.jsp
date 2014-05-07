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
<spring:url scope="page" var="bootstrapJavascriptUrl"
            value="/resources/js/bootstrap.js"/>
<spring:url scope="page" var="jqueryUrl"
            value="/resources/js/jquery-1.9.1.min.js"/>


<html lang="en">
<head>
    <title>Demand</title>

    <!-- Le styles -->
    <script src="${pageScope.jqueryUrl}"></script>
    <script src="${pageScope.bootstrapJavascriptUrl}"></script>
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

<h1>Demand Your Request</h1>

<h3>Request items using below drop down menu</h3>

<div class="container">

    <form:form id="demand" method="POST" modelAttribute="demandForm">

    <fieldset>
        <h5>Building</h5>
        <form:select id="building" path="buildingId"></form:select>
        <h5>Room</h5>
        <form:select id="room" path="roomId">
            <form:option value=""> Room </form:option>
        </form:select>
        <h5>Item</h5>
        <form:select id="item" path="itemId">
            <form:option value=""> Item </form:option>
        </form:select>
        <h5>Demand Quantity</h5>
        <form:select id="demandQ" path="demandQuantity">
            <form:option value=""> Demand Quantity </form:option>
        </form:select>
        <h5>Reason (Optional)</h5>
        <form:textarea path="reason" rows="5"/>
    </fieldset>
    <p>
        <button type="submit">
            Submit
        </button>
        </form:form>

        <c:url var="findBuildingURL" value="/buildings/buildings"/>
        <script type="text/javascript">
            $(document).ready(function () {
                $.getJSON('${findBuildingURL}', {
                    ajax: 'true'
                }, function (data) {
                    var html = '<option value="">Building</option>';
                    var len = data.length;
                    for (var i = 0; i < len; i++) {
                        html += '<option value="' + data[i].buildingId + '">' + data[i].buildingName + '</option>';
                    }
                    html += '</option>';
                    $('#building').html(html);
                });
            });
        </script>

</div>

<c:url var="findRoomURL" value="/rooms/roomsinbuilding"/>
<script type="text/javascript">
    $(document).ready(function () {
        $('#building').change(function () {
            $.getJSON('${findRoomURL}', {
                buildingId: $('#building').val(),
                ajax: 'true'
            }, function (data) {
                var html = '<option value="">Room</option>';
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].roomId + '">' + data[i].roomName + '</option>';
                }
                html += '</option>';
                $('#room').html(html);
            });
        });
    });
</script>

<c:url var="finditemURL" value="/items/itemsinroom"/>
<script type="text/javascript">
    $(document).ready(function () {
        $('#room').change(function () {
            $.getJSON('${finditemURL}', {
                roomId: $(this).val(),
                ajax: 'true'
            }, function (data) {
                var html = '<option value="">Item</option>';
                var len = data.length;
                for (var i = 0; i < len; i++) {
                    html += '<option value="' + data[i].itemId + '">' + data[i].itemName + '</option>';
                }
                html += '</option>';
                $('#item').html(html);
            });
        });
    });
</script>

<c:url var="demandQuantityURL" value="/items/itemAllotment"/>
<script type="text/javascript">
    $(document).ready(function () {
        $('#item').change(function () {
            $.getJSON('${demandQuantityURL}', {
                itemId: $(this).val(),
                roomId: $('#room').val(),
                ajax: 'true'
            }, function (data) {
                var html = '<option value="">Demand Quantity</option>';
                for (var i = 1; i <= data.itemAllotment; i++) {
                    html += '<option value="' + i + '">' + i + '</option>';
                }
                html += '</option>';
                $('#demandQ').html(html);
            });
        });
    });
</script>

<!-- /container -->

<!-- Le javascript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->

</body>
</html>