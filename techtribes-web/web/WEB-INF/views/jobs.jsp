<div class="jobsSection">
    <div class="sectionHeading">Jobs</div>

    <c:choose>
        <c:when test="${not empty jobs}">
            <p>
                Here are some jobs that have been posted by local people and tribes. Our monkeys don't make any guarantees about the
                accuracy and availability of them.
            </p>

            <hr />
            <%@ include file="/WEB-INF/fragments/content-source-statistics.jspf" %>
            <hr />

            <%@ include file="/WEB-INF/fragments/jobs.jspf" %>

            <script src="/static/js/highlight-content-by-same-author.js"></script>
        </c:when>
        <c:otherwise>
            <p>
                Sorry, we don't have any jobs listed for you at the moment. Please do pop back in the future though.
            </p>
        </c:otherwise>
    </c:choose>
</div>