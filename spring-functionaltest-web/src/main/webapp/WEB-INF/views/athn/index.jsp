<div id="wrapper">

	<h1 id="screenTitle">ATHN 認証</h1>

	<sec:authentication property="principal" var="principal" />

	<div>
		ようこそ
		<sec:authorize access="isAuthenticated()">
			<span id="AuthenticateUserName">${f:h(principal.username)}</span>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
			<span id="AuthenticateUserName"><spring:message
					code="label.sf.cmmn.defaultUserName" /></span>
		</sec:authorize>
		さん
	</div>
	<br>

	<div>[ATHN01] フォーム認証</div>
	<ul>
		<li><a id="athn0102001"
			href="${pageContext.request.contextPath}/athn/0102/001">athn0102001</a></li>
	</ul>
	<div>[ATHN02] 認証成功時のレスポンス・[ATHN10] 認証処理とSpring
		MVCの連携・[ATHN11] フォーム認証の拡張・[ATHN14] ログアウトの拡張</div>
	<ul>
		<li><a id="athn0201001"
			href="${pageContext.request.contextPath}/athn/0201/001?loginSuccess">athn0201001</a></li>
		<li><a id="athn0201002"
			href="${pageContext.request.contextPath}/athn/0201/001/login">athn0201002</a></li>
	</ul>
	<div>[ATHN03] 認証失敗時のレスポンス</div>
	<ul>
		<li><a id="athn0301001"
			href="${pageContext.request.contextPath}/athn/0301/001/login">athn0301001</a>
		</li>
	</ul>
	<div>[ATHN04] DB認証</div>
	<ul>
		<li><a id="athn0401001"
			href="${pageContext.request.contextPath}/athn/0401/001/login">athn0401001</a></li>
	</ul>
	<div>[ATHN05] パスワードのハッシュ化</div>
	<ul>
		<li><a id="athn0501001"
			href="${pageContext.request.contextPath}/athn/0501/001">athn0501001</a>
		</li>

		<li><a id="athn0502001"
			href="${pageContext.request.contextPath}/athn/0502/001/login">athn0502001</a></li>
	</ul>

	<div>[ATHN06] 認証イベントのハンドリング</div>
	<ul>
		<li><a id="athn0601001"
			href="${pageContext.request.contextPath}/athn/0601/001/login">athn0601001</a>
		</li>
		<li><a id="athn0602001"
			href="${pageContext.request.contextPath}/athn/0601/001/login">athn0602001</a>
		</li>
		<li><a id="athn0602002"
			href="${pageContext.request.contextPath}/athn/0602/002/login">athn0602002</a></li>
	</ul>

	<div>[ATHN07] ログアウト・[ATHN08] ログアウト成功時のレスポンス</div>
	<ul>
		<li><a id="athn0701001"
			href="${pageContext.request.contextPath}/athn/0701/001/login">athn0701001</a>
		</li>
		<li><a id="athn0702001"
			href="${pageContext.request.contextPath}/athn/0702/001/login">athn0702001</a></li>
	</ul>

	<div>[ATHN09] 認証情報へのアクセス</div>
	<ul>
		<li><a id="athn0901001"
			href="${pageContext.request.contextPath}/athn/0901/login">athn0901001</a>
		</li>
	</ul>

	<div>[ATHN12] 認証成功時のレスポンスの拡張</div>
	<ul>
		<li><a id="athn1201001"
			href="${pageContext.request.contextPath}/athn/1201/001/afterLogin">athn1201001</a></li>
		<li><a id="athn1202001"
			href="${pageContext.request.contextPath}/athn/1202/001/login">athn1202001</a></li>
	</ul>

	<div>[ATHN13] 認証失敗時のレスポンスの拡張</div>
	<ul>
		<li><a id="athn1302001"
			href="${pageContext.request.contextPath}/athn/1302/001/login">athn1302001</a></li>
	</ul>

	<div>[ATHN15] ログアウト成功時のレスポンスの拡張</div>
	<ul>
		<li><a id="athn1501002"
			href="${pageContext.request.contextPath}/athn/1501/001/login">athn1501002</a></li>
	</ul>
	<div>[ATHN16] エラーメッセージの拡張</div>
	<ul>
		<li><a id="athn1601001"
			href="${pageContext.request.contextPath}/athn/1601/001/login">athn1601001</a>
		</li>
	</ul>

	<div>[ATHN17] 業務処理向けの拡張</div>
	<ul>
		<li><a id="athn1701001"
			href="${pageContext.request.contextPath}/athn/1701/001">athn1701001</a></li>
		<li><a id="athn1702001"
			href="${pageContext.request.contextPath}/athn/1702/001">athn1702001</a></li>
		<li><a id="athn1703001"
			href="${pageContext.request.contextPath}/athn/1703/001">athn1703001</a></li>
	</ul>

	<div>[ATHN18] パスワードのハッシュ化ハッシュの拡張</div>
	<ul>
		<li><a id="athn1801001"
			href="${pageContext.request.contextPath}/athn/1801/001">athn1801001</a>
		</li>
		<li><a id="athn1801002"
			href="${pageContext.request.contextPath}/athn/1801/002">athn1801002</a></li>
	</ul>
    <div>[ATHN19] 遷移先の指定が可能な認証成功ハンドラ</div>
    <ul>
        <li>GFWの試験で実施するため試験不要
        </li>
    </ul>
	<div>[ATHN20] Spring MVCでリクエストを受けてログインフォームを表示する</div>
	<ul>
		<li>本試験が全般的にSpring MVCを使用しているため、試験不要
		</li>
	</ul>
	<div>[ATHN21] Remeber Meの使用</div>
	<ul>
		<li><a id="athn2101001"
			href="${pageContext.request.contextPath}/athn/2101/001">athn2101001</a></li>

		<li><a id="athn2101001showInfo"
			href="${pageContext.request.contextPath}/athn/2101?loginSuccess">athn2101001showInfo</a></li>
	</ul>
</div>
