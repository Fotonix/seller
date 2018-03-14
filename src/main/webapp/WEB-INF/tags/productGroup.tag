<%@ tag language="java" pageEncoding="UTF8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="entity" required="false" rtexprvalue="true" type="seller.domain.reference.ProductGroup"%>

<div class="action-element">
    <input class="id" type="hidden" value="${entity.id}" />
    <table>
        <tbody>
            <tr>
                <th>
                    <spring:message code="productGroup.name" />:
                </th>
                <td class="main-element">
                    <input class="name" type="text" value="${fn:escapeXml(entity.name)}" maxlength="64" />
                </td>
                <td>
                    <spring:message var="saveTitle" code="productGroup.title.save" />
                    <a href="#" class="save-btn" title="${saveTitle}"></a>
                </td>
                <td>
                    <spring:message var="deleteTitle" code="productGroup.title.delete" />
                    <a href="#" class="delete-btn" title="${deleteTitle}"></a>
                </td>
                <td>
                    <spring:message var="newTitle" code="productGroup.title.new" />
                    <a href="#" class="new-btn" title="${newTitle}"></a>
                </td>
            </tr>
            <tr>
                <td colspan="5" class="error-message" />
            </tr>
        </tbody>
    </table>
</div>
