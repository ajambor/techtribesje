<%@ include file="/WEB-INF/fragments/tribe-profile.jspf" %>

<div class="talksSection">
    <div class="subSectionHeading">Talks by members</div>

    <c:choose>
        <c:when test="${not empty talks}">
            <%@ include file="/WEB-INF/fragments/talks.jspf" %>
        </c:when>
        <c:otherwise>
            The monkeys couldn't find any talks by this tribe. :-(
        </c:otherwise>
    </c:choose>

    <script src="/static/js/highlight-content-by-same-author.js"></script>
</div>