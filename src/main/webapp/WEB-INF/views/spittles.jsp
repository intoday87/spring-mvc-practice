<c:forEach items="${spittleList}" var="spittle">

    <li id="spittle_<c:out value="spittle.is"/>">
        <div class="spittleMessage">\
            <c:out value="${spittle.message}" />
        </div>
        <div>
            <span class="spittleTime">
                <c:out value="${spittle.time}" />
            </span>
            <span>
                (<c:out value="${spittle.latitude}" />,
                <c:out value="${spittle.longtitude}" />)
            </span>
        </div>
    </li>

</c:forEach>