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