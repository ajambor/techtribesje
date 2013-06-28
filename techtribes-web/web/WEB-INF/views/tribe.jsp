<%@ include file="/WEB-INF/fragments/tribe-profile.jspf" %>

<c:if test="${not empty activity && activity.score > 0}">
<div class="subSectionHeading">Activity and badges</div>
    <p>
    <c:choose>
        <c:when test="${tribe.type == 'Community'}">
                Here's a summary of the tribe's activity over the past 7 days.
        </c:when>
        <c:otherwise>
                Here's a summary of the activity over the past 7 days, for the tribe and its members.
        </c:otherwise>
    </c:choose>
    <a href="/activity"><span class="badge"><fmt:formatNumber value="${activity.score}" minFractionDigits="1" maxFractionDigits="1" /> points</span></a>
    </p>
<%@ include file="/WEB-INF/fragments/activity-summary.jspf" %>

</c:if>

<c:if test="${tribe.type ne 'Tech'}">
<c:set var="contentSource" value="${tribe}" />
<%@ include file="/WEB-INF/fragments/badges.jspf" %>
</c:if>

<c:if test="${not empty newsFeedEntries}">
    <div class="contentSection">
        <div class="subSectionHeading">Blog entries, etc</div>
        <%@ include file="/WEB-INF/fragments/newsFeedEntries.jspf" %>

        <div class="pagingLinks">
            <a href="/tribes/${tribe.shortName}/content">More...</a>
        </div>
    </div>
</c:if>

<c:if test="${not empty tweets}">
    <div class="tweetsSection">
        <div class="subSectionHeading">Tweets</div>
        <%@ include file="/WEB-INF/fragments/tweets.jspf" %>

        <div class="pagingLinks">
            <a href="/tribes/${tribe.shortName}/tweets">More...</a>
        </div>
    </div>
</c:if>

<c:if test="${not empty jobs}">
    <div class="jobsSection">
        <div class="subSectionHeading">Jobs</div>
        <%@ include file="/WEB-INF/fragments/jobs.jspf" %>

        <div class="pagingLinks">
            <a href="/tribes/${tribe.shortName}/jobs">More...</a>
        </div>
    </div>
</c:if>
