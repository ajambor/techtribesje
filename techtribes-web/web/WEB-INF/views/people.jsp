<div class="sectionHeading">
    <div style="float: right;">
        <ul class="nav nav-pills">
            <c:choose>
                <c:when test="${sort eq 'followers'}">
                    <li><a href="/people">Sort by name</a></li>
                    <li class="active"><a href="/people?sort=followers">Sort by followers</a></li>
                    <li><a href="/people?sort=activity">Sort by activity</a></li>
                </c:when>
                <c:when test="${sort eq 'activity'}">
                    <li><a href="/people">Sort by name</a></li>
                    <li><a href="/people?sort=followers">Sort by followers</a></li>
                    <li class="active"><a href="/people?sort=activity">Sort by activity</a></li>
                </c:when>
                <c:otherwise>
                    <li class="active"><a href="/people">Sort by name</a></li>
                    <li><a href="/people?sort=followers">Sort by followers</a></li>
                    <li><a href="/people?sort=activity">Sort by activity</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
    People
</div>

<p>
    Our team of monkeys is watching these ${numberOfPeople} people for every word they write or tweet.
</p>

<hr />

<c:forEach var="person" items="${people}" varStatus="status">
    <div class="row person <c:if test="${not person.active}">faded</c:if>">
        <div class="span1">
            <a href="/people/${person.shortName}"><img src="${person.profileImageUrl}" alt="Profile image" class="profileImage" /></a>
        </div>
        <div class="span11">
            <a href="/people/${person.shortName}">${person.name}</a>
            <c:if test="${not empty person.twitterId}">
                - <a href="http://twitter.com/${person.twitterId}" target="_blank">@${person.twitterId}</a>
                <c:choose>
                    <c:when test="${person.twitterFollowersCount >= 1000}">
                        <a href="http://twitter.com/${person.twitterId}" target="_blank"><span class="badge badge-followersover1000">${person.twitterFollowersCount} followers</span></a>
                    </c:when>
                    <c:when test="${person.twitterFollowersCount >= 500}">
                        <a href="http://twitter.com/${person.twitterId}" target="_blank"><span class="badge badge-followerover500">${person.twitterFollowersCount} followers</span></a>
                    </c:when>
                    <c:when test="${person.twitterFollowersCount == 0}">
                        <a href="http://twitter.com/${person.twitterId}" target="_blank"><span class="badge badge-followers0">${person.twitterFollowersCount} followers</span></a>
                    </c:when>
                    <c:otherwise>
                        <a href="http://twitter.com/${person.twitterId}" target="_blank"><span class="badge badge-followersunder500">${person.twitterFollowersCount} followers</span></a>
                    </c:otherwise>
                </c:choose>
            </c:if>
            <c:if test="${not empty person.profile}">
            <p>
                ${person.profile}
            </p>
            </c:if>
            <p>
                <img src="<techtribesje:flag name="${person.island}" />" alt="${job.island}" title="${person.island}" />
                <c:forEach var="tribe" items="${person.tribes}">
                    <a href="/tribes/${tribe.shortName}"><img src="${tribe.profileImageUrl}" alt="${tribe.name}" class="profileImageSmall" title="${tribe.name}" /></a>
                </c:forEach>
            </p>
        </div>
    </div>
</c:forEach>