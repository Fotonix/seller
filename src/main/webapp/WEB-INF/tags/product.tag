<%@ tag language="java" pageEncoding="UTF8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="entity" required="false" rtexprvalue="true" type="seller.domain.reference.Product"%>
<%@ attribute name="groups" required="true" rtexprvalue="true" type="java.util.List"%>

<div class="action-element">
    <input class="id" type="hidden" value="${entity.id}" />
    <table>
        <tbody>
            <tr>
                <th>
                    <spring:message code="product.name" />:
                </th>
                <td class="main-element">
                    <input class="name" type="text" value="${fn:escapeXml(entity.name)}" maxlength="64" />
                </td>
                <td>
                    <spring:message var="saveTitle" code="product.title.save" />
                    <a href="#" class="save-btn" title="${saveTitle}"></a>
                </td>
                <td>
                    <spring:message var="deleteTitle" code="product.title.delete" />
                    <a href="#" class="delete-btn" title="${deleteTitle}"></a>
                </td>
                <td>
                    <spring:message var="newTitle" code="product.title.new" />
                    <a href="#" class="new-btn" title="${newTitle}"></a>
                </td>
            </tr>
            <tr>
                <th>
                    <spring:message code="product.group" />:
                </th>
                <td class="main-element" colspan="3">
                    <select class="productGroup">
                        <c:forEach var="group" items="${groups}">
                            <c:choose>
                                <c:when test="${entity.productGroupId eq group.id}">
                                    <option selected="selected" value="${group.id}">
                                        <c:out value="${group.name}" />
                                    </option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${group.id}">
                                        <c:out value="${group.name}" />
                                    </option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="5" class="error-message" />
            </tr>
        </tbody>
    </table>
</div>
