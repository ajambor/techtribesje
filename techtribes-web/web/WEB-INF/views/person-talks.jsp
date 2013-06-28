<%@ include file="/WEB-INF/fragments/person-profile.jspf" %>

<div class="talksSection">
    <div class="subSectionHeading">Talks</div>
    <c:choose>
        <c:when test="${not empty talks}">
            <%@ include file="/WEB-INF/fragments/talks.jspf" %>
        </c:when>
        <c:otherwise>
            The monkeys couldn't find any talks by this person. :-(
        </c:otherwise>
    </c:choose>
</div>