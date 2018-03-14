<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
    <tr>
        <th>#</th>
        <th>Series</th>
        <th>Date</th>
        <th>Producer</th>
    </tr>
    <c:forEach var="invoice" items="${invoices}" varStatus="status">
        <tr>
            <td>
                <spring:url var="invoiceUrl" value="/supply/invoice.html">
                    <spring:param name="id" value="${invoice.id}" />
                </spring:url>
                <a href="${invoiceUrl}">${status.count}</a>
            </td>
            <td>${invoice.series}</td>
            <td>${invoice.date}</td>
            <td>${invoice.producer.name}</td>
        </tr>
    </c:forEach>
</table>
