<%@ tag language="java" pageEncoding="UTF8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ attribute name="entity" required="false" rtexprvalue="true" type="seller.domain.configuration.Configuration"%>

<div class="action-element">
    <input class="key" type="hidden" value="${entity.key}" />
    <input class="regexp" type="hidden" value="${entity.regexp}" />
    <table>
        <tbody>
            <tr>
                <th>
                    ${entity.description}:
                </th>
                <td class="main-element">
                    <input class="value" type="text" value="${fn:escapeXml(entity.value)}" maxlength="64" />
                </td>
                <td>
                    <spring:message var="saveTitle" code="configuration.title.save" />
                    <a href="#" class="save-btn" title="${saveTitle}"></a>
                </td>
            </tr>
            <tr>
                <td colspan="5" class="error-message" />
            </tr>
        </tbody>
    </table>
</div>
