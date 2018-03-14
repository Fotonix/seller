<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<script type="text/javascript">
(function($) {
    $.fn.editTable = function() {
        this.find('input').focus(function() {
            alert("ok");
        });
    };
})(jQuery);

$(document).ready(function() {
    $('#itemTable').editTable();
});

</script>

<div id="page-content">
    <spring:hasBindErrors name="invoice">
        <spring:message code="error.save" />
    </spring:hasBindErrors>

    <spring:url var="submitUrl" value="/supply/invoice.html" />
    <form:form action="${submitUrl}" method="POST" commandName="invoice">
        <form:hidden path="id" />
        <form:label path="series">Series</form:label>
        <form:input path="series" maxlength="10" />
        <form:input path="date" cssErrorClass="error-field" />
        <form:errors path="date" cssClass="error-message" />
        <form:select path="producerId" items="${producers}" itemValue="id" itemLabel="name" />
        <table id="itemTable">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Product</th>
                    <th>Quantity</th>
                    <th>Cost</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${invoice.items}" varStatus="status">
                    <form:hidden path="items[${status.index}].id" />
                    <form:hidden path="items[${status.index}].invoiceId" />
                    <tr>
                        <td>${status.count}</td>
                        <td>
                            <form:select
                                path="items[${status.index}].productId"
                                items="${products}"
                                itemValue="id"
                                itemLabel="name" />
                        </td>
                        <td><form:input path="items[${status.index}].quantity" /></td>
                        <td><form:input path="items[${status.index}].cost" /></td>
                        <td><input type="button" value="Delete" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <input type="submit" value="Save" />
        <input type="button" value="Add" />
    </form:form>
</div>