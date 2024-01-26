<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PlantLink</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css" />
	</head>
	<body>
		<div class="header">
        <img src="${pageContext.request.contextPath }/resources/images/PlantLinkLogo.png" alt="" class="img-header" />
        <h1>PlantLink</h1>
        <div class="expand"></div>
        <div class="button-row">
          <h2 style="cursor: pointer" onclick="window.location.href = '/plantlink/'">My Channel</h2>
          <h2>Profile</h2>
          <button
            onclick="() => alert('hii')"
          >Log Out</button>
        </div>
      </div>
	</body>
</html>