<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:useAttribute name="selectedSubmenu" />
<ul>
    <%-- Invoice Edit --%>
    <c:set var="current" value="" />
    <c:if test="${'invoice' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/supply/invoice.html" />
        <a href="${url}"><spring:message code="supply.submenu.invoice" /></a>
    </li>
    <%-- Invoice List --%>
    <c:set var="current" value="" />
    <c:if test="${'invoiceList' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/supply/invoice/list.html" />
        <a href="${url}"><spring:message code="supply.submenu.invoice.list" /></a>
    </li>
</ul>
