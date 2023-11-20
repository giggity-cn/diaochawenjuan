<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>调查问卷</title>

<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">
<style type="text/css">
	body {
		margin: 0;
		font-family: "PingFang SC", "Microsoft Yahei", sans-serif;

	}

	.container {
		width: 100vw;
		height: 100vh;
		display: flex;
		align-items: center;
		justify-content: center;
		background: url("img/111.png") fixed no-repeat;
		background-size: cover;
	}

	.login-form {
		width: 240px;
		height: 220px;
		display: flex;
		flex-direction: column;
		padding: 40px;
		text-align: center;
		position: relative;
		z-index: 100;
		background: inherit;
		border-radius: 18px;
		overflow: hidden; /* 隐藏多余的模糊效果*/
	}

	.login-form::before {
		content: "";
		width: calc(100% + 20px);
		height: calc(100% + 20px);
		position: absolute;
		top: -10px;
		left: -10px;
		overflow: hidden;
		background: inherit;
		box-shadow: inset 0 0 0 200px rgba(255, 255, 255, 0.25);
		filter: blur(6px);
		z-index: -1;
	}

	.login-form h2 {
		font-size: 18px;
		font-weight: 400;
		color: #000000;
	}

	.login-form input,
	.login-form button {
		margin: 6px 0;
		height: 36px;
		border: none;
		background-color: rgba(255, 255, 255, 0.3);
		border-radius: 4px;
		padding: 0 14px;
		color: #3d5245;
	}

	.login-form input::placeholder {
		color: #000000;
	}


	.login-form button:focus,
	.login-form input:focus {
		outline: 0;
	}

	.login-form button {
		margin-top: 24px;
		background-color: rgba(57, 88, 69, 0.4);
		color: white;
		position: relative;
		overflow: hidden;
		cursor: pointer;
		transition: 0.4s;
	}

	.login-form button:hover {
		background-color: rgba(12, 80, 38, 0.67);
	}


</style>
</head>
<body>
<div class="container">
	<form action="${pageContext.request.contextPath}/loginServlet" class="login-form">
		<h2>登 录</h2>
		<input
				type="text"
				name="username"
				placeholder="用户名"
		/>
		<input
				type="password"
				name="password"
				placeholder="密码"
		/>
		<input
				type="text"
				name="checked"
				placeholder="验证码"
		/>
		<button type="submit">登录</button>
		${error}
	</form>

</div>

</body>
</html>