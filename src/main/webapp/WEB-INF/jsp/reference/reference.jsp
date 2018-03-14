<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="url" value="/css/element.css" />
<link type="text/css" rel="stylesheet" href="${url}" />

<c:url var="url" value="/js/ajax.js" />
<script type="text/javascript" src="${url}"></script>

<div id="submenu">
    <tiles:insertAttribute name="submenu" />
</div>
<tiles:insertAttribute name="subbody" />
