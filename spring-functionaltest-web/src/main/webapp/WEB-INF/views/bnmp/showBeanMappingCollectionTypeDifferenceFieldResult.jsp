<div id="wrapper">
    <h1 id="screenTitle">Collection型のフィールドをマッピング</h1>
    <br>
    <table class="table table-striped table-bordered table-condensed">
        <c:forEach var="emailAddresses" items="${resultBean.emailAddresses}"
            varStatus="rowStatus">
            <tr>
                <td class="inputColumn">email ${rowStatus.count}</td>
                <td><span id="getEmail${rowStatus.count}">${f:h(emailAddresses.email)}</span></td>
            </tr>
        </c:forEach>
    </table>
</div>