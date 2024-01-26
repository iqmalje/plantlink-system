<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PlantLink</title>
		
		<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/dashboard.css" />
	</head>
	<body>
		<jsp:include page="header.jsp" />
		<jsp:include page="headerchannel.jsp">
			<jsp:param name="img" value="${pageContext.request.contextPath }/resources/images/backgroundimage.png" />
			<jsp:param name="text" value="My Channel" />
			
		</jsp:include>
		<div class="button-row-dashboard">
			<button onclick="window.location.href = '/plantlink/create'" >New Channel</button>
			<button onclick="window.location.href = '/plantlink/sensor/register'" >Register a new sensor</button>
		</div>




		<div class="channel-row">
			<c:forEach var="channel" items="${channels}">
				<jsp:include page="channelcomponent.jsp">
					<jsp:param name="img" value="${pageContext.request.contextPath }/resources/images/backgroundimage.png" />
					<jsp:param name="text" value="${channel.getName()}" />
					<jsp:param name="id" value="${channel.getId()}" />
				</jsp:include>
			</c:forEach>
		</div>
		
		
		
			
		
		
		
		
	</body>
</html>