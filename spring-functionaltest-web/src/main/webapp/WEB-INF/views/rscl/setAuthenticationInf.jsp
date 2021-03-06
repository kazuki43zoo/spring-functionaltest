﻿<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="wrapper">

	<h1 id="screenTitle">認証情報入力</h1>

	<form:form action="${pageContext.request.contextPath}/rscl/${testId}"
		class="form-horizontal">

		<div class="form-group">
			<h4>
				<span id="testDescription"> 【 ${f:h(testDescription)} 】 </span>
			</h4>

			<div class="form-group">
				<label for="userid" class="col-sm-2 control-label">ユーザID：</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userid" name="userid"
						placeholder="UserId">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">パスワード：</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password"
						placeholder="Password">
				</div>
			</div>
		</div>
		<button type="submit" id="send" class="btn btn-default">send</button>
	</form:form>
</div>
