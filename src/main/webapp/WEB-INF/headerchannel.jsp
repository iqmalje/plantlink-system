<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

	.text-top {
		color: white;
		font-size: 50px;
	}
</style>
</head>
<body>
	<div class="image-container" style="height: 270px; background-image: url(${param.img}); background-size: cover; display: flex; justify-content: center; align-items: center;">
		<h1 class="text-top" >
		${param.text }</h1>
	</div>
</body>
</html>