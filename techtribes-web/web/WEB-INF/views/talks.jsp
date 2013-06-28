<div class="talksSection">
    <div class="sectionHeading">
        <div style="float: right;">
            <ul class="nav nav-pills">
                <c:choose>
                    <c:when test="${activeNav eq '2014'}">
                        <li class="active"><a href="/talks/year/2014">2014</a></li>
                        <li><a href="/talks/year/2013">2013</a></li>
                        <li><a href="/talks/year/2012">2012</a></li>
                    </c:when>
                    <c:when test="${activeNav eq '2013'}">
                        <li><a href="/talks/year/2014">2014</a></li>
                        <li class="active"><a href="/talks/year/2013">2013</a></li>
                        <li><a href="/talks/year/2012">2012</a></li>
                    </c:when>
                    <c:when test="${activeNav eq '2012'}">
                        <li><a href="/talks/year/2014">2014</a></li>
                        <li><a href="/talks/year/2013">2013</a></li>
                        <li class="active"><a href="/talks/year/2012">2012</a></li>
                    </c:when>
                    <c:otherwise>
                        <li><a href="/talks/year/2014">2014</a></li>
                        <li><a href="/talks/year/2013">2013</a></li>
                        <li><a href="/talks/year/2012">2012</a></li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        Talks by local speakers
    </div>
    <p>
        A number of people are putting Jersey and Guernsey on the map by speaking at international conferences and events.
        We think that they're really howler monkeys in disguise...
    </p>
    <p style="text-align: center;">
        <c:forEach var="country" items="${countries}"><img src="<techtribesje:flag name="${country}" />" alt="${country}" title="${country}" /> </c:forEach>
    </p>
    <hr />

    <%@ include file="/WEB-INF/fragments/talks.jspf" %>

    <script src="/static/js/highlight-content-by-same-author.js"></script>
</div>