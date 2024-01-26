<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
@import url("https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap");

.channel {
	width: 350px;
  height: 264px;
  border-radius: 12px;
  background-repeat: no-repeat;
  background-position: 50%;
  background-size: cover;
  background-attachment: scroll;
  background-origin: padding-box;
  background-clip: border-box;
  background-color: transparent;
  display: flex;
  margin-top: 50px;
  cursor: pointer
}

.text-channel {
    align-self: end;
    margin: 25px;
    color: white;
    font-size: 24px;
    font-weight: 500;
    font-family: Poppins;
}
</style>
</head>
<body>
	<div class="channel" style="background-image: url(${param.img});"  onclick="window.location.href='/plantlink/channel/${param.id }'">
		<div class="text-channel">${param.text }</div>
	</div>
</body>
</html>