<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>

<c:url var="url" value="/js/element-action.js" />
<script type="text/javascript" src="${url}"></script>

<script type="text/javascript">

var ajaxSend = AjaxSend('section.html');

var createJson = function(button) {
    var element = button.closest(".action-element");
    var entity = {
        id : element.find(".id").val(),
        name : element.find(".name").val()
    };
    return entity;
};

</script>

<div id="page-content">
    <c:forEach var="entity" items="${sections}">
        <tag:section entity="${entity}" />
    </c:forEach>
</div>

<div id="element-hidden" style="visibility: hidden">
    <tag:section />
</div>
