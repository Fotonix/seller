<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<tiles:useAttribute name="selectedMenu" />
<ul>
    <%-- Main --%>
    <c:set var="current" value="" />
    <c:if test="${'main' eq selectedMenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/main.html" />
        <a href="${url}"><spring:message code="menu.main" /></a>
    </li>
    <%-- Configuration --%>
    <c:set var="current" value="" />
    <c:if test="${'config' eq selectedMenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/config.html" />
        <a href="${url}"><spring:message code="menu.config" /></a>
    </li>
    <%-- Supply --%>
    <c:set var="current" value="" />
    <c:if test="${'supply' eq selectedMenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/supply.html" />
        <a href="${url}"><spring:message code="menu.supply" /></a>
    </li>
    <%-- References --%>
    <c:set var="current" value="" />
    <c:if test="${'reference' eq selectedMenu}"><c:set var="current" value="current" /></c:if>
    <li class="${current}">
        <c:url var="url" value="/reference.html" />
        <a href="${url}"><spring:message code="menu.reference" /></a>
    </li>
</ul>
