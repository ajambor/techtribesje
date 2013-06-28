<div class="sectionHeading">Search for <c:out value="${query}" escapeXml="true" /></div>

<p>
    Our team of monkeys has gathered the following for you. Enjoy!
</p>

<hr />
<%@ include file="/WEB-INF/fragments/content-source-statistics.jspf" %>
<hr />

<c:forEach var="result" items="${results}" varStatus="status">
    <c:if test="${status.index % 3 == 0}">
        <div class="row">
    </c:if>
            <div class="span4">
                <c:choose>
                    <c:when test="${result.newsFeedEntry}">
                        <c:set var="newsFeedEntry" value="${result}"/>
                        <%@ include file="/WEB-INF/fragments/newsFeedEntry.jspf" %>
                    </c:when>
                    <c:when test="${result.tweet}">
                        <c:set var="tweet" value="${result}"/>
                        <%@ include file="/WEB-INF/fragments/tweet.jspf" %>
                    </c:when>
                </c:choose>
            </div>
    <c:if test="${status.index % 3 == 2}">
        </div>
    </c:if>

    <c:if test="${status.last and status.index % 3 ne 2}">
        <c:forEach begin="1" end="${2-(status.index % 3)}">
            <div class="span4">&nbsp;</div>
        </c:forEach>
        </div>
    </c:if>
</c:forEach>

<script src="/static/js/highlight-content-by-same-author.js"></script>