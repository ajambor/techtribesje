<%@ include file="/WEB-INF/fragments/person-profile.jspf" %>

<c:if test="${not empty activity && activity.score > 0}">
<div class="subSectionHeading">Activity and badges</div>
<p>
    Here's a summary of this person's activity over the past 7 days.
    <a href="/activity"><span class="badge"><fmt:formatNumber value="${activity.score}" minFractionDigits="1" maxFractionDigits="1" /> points</span></a>
</p>

<%@ include file="/WEB-INF/fragments/activity-summary.jspf" %>
</c:if>

<c:set var="contentSource" value="${person}" />
<%@ include file="/WEB-INF/fragments/badges.jspf" %>

<c:if test="${not empty talks}">
    <div class="talksSection">
        <div class="subSectionHeading">Talks</div>
        <%@ include file="/WEB-INF/fragments/talks.jspf" %>

        <p style="text-align: center;">
            <c:forEach var="country" items="${countries}"><img src="<techtribesje:flag name="${country}" />" alt="${country}" title="${country}" /> </c:forEach>
        </p>
        <div class="pagingLinks">
            <a href="/people/${person.shortName}/talks">More...</a>
        </div>
    </div>
</c:if>

<c:if test="${not empty newsFeedEntries}">
    <div class="contentSection">
        <div class="subSectionHeading">Blog entries, etc</div>
        <%@ include file="/WEB-INF/fragments/newsFeedEntries.jspf" %>

        <div class="pagingLinks">
            <a href="/people/${person.shortName}/content">More...</a>
        </div>
    </div>
</c:if>

<c:if test="${not empty tweets}">
    <div class="tweetsSection">
        <div class="subSectionHeading">Tweets</div>
        <%@ include file="/WEB-INF/fragments/tweets.jspf" %>

        <div class="pagingLinks">
            <a href="/people/${person.shortName}/tweets">More...</a>
        </div>
    </div>
</c:if>