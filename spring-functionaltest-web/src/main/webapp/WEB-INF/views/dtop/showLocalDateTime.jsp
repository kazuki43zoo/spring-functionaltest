<div id="wrapper">
    <p>
        LocalDateTime:<span id="getDateResult"><joda:format
                pattern="yyyy/MM/dd HH:mm:ss.SSS"
                value="${resultDate}" /></span><br />
        Style:<span
            id="getResultStyle"><joda:format
                value="${resultDate}" style="SM" /></span><br />
        Class:<span
            id="getDateClassResult">${f:h(resultDate.getClass().getName())}</span>
    </p>
</div>