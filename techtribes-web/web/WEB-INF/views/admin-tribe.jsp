<%@ include file="/WEB-INF/fragments/tribe-profile.jspf" %>

<form action="/admin/tribes/${tribe.shortName}" method="POST">

    <div>
        <label>Profile</label><input name="profile" type="text" placeholder="Description" value="${tribe.profile}" class=" input-xxlarge" />
    </div>

    <div class="row">

        <div class="span6">
            <h3>Members</h3>
            <c:forEach var="person" items="${members}">
                <label class="checkbox">
                    <input type="checkbox" name="person" value="${person.id}" checked="true" /> <img src="${person.profileImageUrl}" alt="Profile image" class="profileImageSmall" /> ${person.name}
                </label>
            </c:forEach>
        </div>

        <div class="span6">
            <h3>Non-members</h3>
            <c:forEach var="person" items="${nonmembers}">
                <label class="checkbox">
                    <input type="checkbox" name="person" value="${person.id}" /> <img src="${person.profileImageUrl}" alt="Profile image" class="profileImageSmall" /> ${person.name}
                </label>
            </c:forEach>
        </div>

    </div>

    <p>
        <input type="submit" class="btn" value="Update" />
    </p>
</form>