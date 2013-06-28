<div class="eventsSection">
    <div class="sectionHeading">
        <div style="float: right;">
            <ul class="nav nav-pills">
                <c:choose>
                    <c:when test="${activeNav eq '2014'}">
                        <li class="active"><a href="/events/year/2014">2014</a></li>
                        <li><a href="/events/year/2013">2013</a></li>
                        <li><a href="/events/year/2012">2012</a></li>
                    </c:when>
                    <c:when test="${activeNav eq '2013'}">
                        <li><a href="/events/year/2014">2014</a></li>
                        <li class="active"><a href="/events/year/2013">2013</a></li>
                        <li><a href="/events/year/2012">2012</a></li>
                    </c:when>
                    <c:when test="${activeNav eq '2012'}">
                        <li><a href="/events/year/2014">2014</a></li>
                        <li><a href="/events/year/2013">2013</a></li>
                        <li class="active"><a href="/events/year/2012">2012</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/events/year/2014">2014</a></li>
                        <li><a href="/events/year/2013">2013</a></li>
                        <li><a href="/events/year/2012">2012</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        Local events
    </div>
    <p>
        Here are the local events that we know about. Something missing? Drop us a line. We'll list community events for free and events organised by a <a href="/business">business tribe</a> (e.g. breakfast briefings, etc) for a small fee (all proceeds to a Jersey charity).
    </p>
    <hr />

    <%@ include file="/WEB-INF/fragments/events.jspf" %>

    <script src="/static/js/highlight-content-by-same-author.js"></script>
</div>