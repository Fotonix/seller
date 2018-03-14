<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<c:url var="css" value="/css/element.css" />
<link type="text/css" rel="stylesheet" href="${css}" />
<c:url var="ajax" value="/js/ajax.js" />
<script type="text/javascript" src="${ajax}"></script>
<c:url var="js" value="/js/element-action.js" />
<script type="text/javascript" src="${js}"></script>

<script type="text/javascript">

var ajaxSend = AjaxSend('config.html');

var createJson = function(button) {
    var element = button.closest(".action-element");
    var entity = {
        key : element.find(".key").val(),
        value : element.find(".value").val(),
        regexp : element.find(".regexp").val()
    };
    return entity;
};

</script>

<div id="page-content">
    <c:forEach var="entity" items="${configurations}">
        <tag:config entity="${entity}"/>
    </c:forEach>
</div>