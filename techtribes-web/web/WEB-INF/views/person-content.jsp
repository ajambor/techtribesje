<%@ include file="/WEB-INF/fragments/person-profile.jspf" %>

<div class="contentSection">
    <div class="subSectionHeading">Blog entries, etc</div>
    <c:choose>
    <c:when test="${not empty newsFeedEntries}">
    <%@ include file="/WEB-INF/fragments/newsFeedEntries.jspf" %>

    <div class="pagingLinks">
        <c:if test="${currentPage > 1}">
            <a href="/people/${person.shortName}/content/${currentPage-1}">&lt; Newer</a> |
        </c:if>
        Page ${currentPage}
        <c:if test="${currentPage < maxPage}">
            | <a href="/people/${person.shortName}/content/${currentPage+1}">Older &gt;</a>
        </c:if>
    </div>
    </c:when>
    <c:otherwise>
    The monkeys couldn't find any content by this person. :-(
    </c:otherwise>
    </c:choose>
</div>