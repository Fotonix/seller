<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:useAttribute name="selectedSubmenu" />
<ul>
    <%-- Product group --%>
    <c:set var="current" value="" />
    <c:if test="${'productGroup' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/reference/productGroup.html" />
        <a href="${url}"><spring:message code="reference.submenu.productGroup" /></a>
    </li>
    <%-- Product --%>
    <c:set var="current" value="" />
    <c:if test="${'product' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/reference/product.html" />
        <a href="${url}"><spring:message code="reference.submenu.product" /></a>
    </li>
    <%-- Section --%>
    <c:set var="current" value="" />
    <c:if test="${'section' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/reference/section.html" />
        <a href="${url}"><spring:message code="reference.submenu.section" /></a>
    </li>
    <%-- Producer --%>
    <c:set var="current" value="" />
    <c:if test="${'producer' eq selectedSubmenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/reference/producer.html" />
        <a href="${url}"><spring:message code="reference.submenu.producer" /></a>
    </li>
</ul>
