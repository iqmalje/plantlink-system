<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/createChannelView.css">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Channel</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<jsp:include page="headerchannel.jsp">
			<jsp:param name="img" value="${pageContext.request.contextPath }/resources/images/backgroundimage.png" />
			<jsp:param name="text" value="Create Channel" />
			
		</jsp:include>
		
		
	<form action="/plantlink/channel/create" method="POST">
		<div class="content-body">
			<div class="row">
		        <div class="column">
		            <form>
		                <label for="name">Name *</label><br>
		                <input type="text" id="name" name="name" class="textfield"><br><br>
		
		                <label for="description">Description</label><br>
		                <input type="text" id="description" name="description" class="textfield" style="height: 80px;"><br>
		            </form>
		        </div>
		
		        <div class="column">
		            <div class="row" style="align-items: start;">
		                <label style="width: 110px;" for="coverpic">Cover Picture</label>
		                <input type="radio" id="coverpic" value="coverpic"><br>
		            </div>
		            <div class="uploadImg" style="height: 170px;">
		                <input type="file" id="myFile" name="filename">
		            </div>
		        </div>
		    </div>
		
		    <br>
		
		    <label for="location">Show Channel Location</label>
		    <input type="radio" id="location" value="location"><br><br>
		
		
		    <div class="row">
		        <div class="column">
		            <div class="row">
		                <label style="width: 80px;" for="latitude">Latitude</label>
		            <input type="text" id="latitude" name="latitude" class="textfield"><br>
		            </div>
		        </div>
		
		        <div class="column" style="width: 10%;"></div>
		
		        <div class="column">
		            <div class="row">
		                <label style="width: 100px;" for="longitude">Longitude</label>
		            <input type="text" id="longitude" name="longitude" class="textfield"><br>
		            </div>
		        </div>
		    </div>
		    
		    <br>
		    <label for="sensors">Number of Sensors</label>
		
		    <select name="sensors" id="sensors">
		        <option value="1">1</option>
		        <option value="2">2</option>
		        <option value="3">3</option>
		        <option value="4">4</option>
		        <option value="5">5</option>
		        <option value="6">6</option>
		        <option value="7">7</option>
		        <option value="8">8</option>
		    </select>
		
		    <br><br>
		
		    <div class="row">
		        <div class="column">
		            <div class="row">
		                <label style="width: 100px;" for="sensor1">Sensor 1</label><br>
		                <input type="text" id="sensor1" name="sensor1" class="textfield"><br>
		            </div>
		        </div>
		
		        <div class="column" style="width: 10%;"></div>
		
		        <div class="column">
		            <div class="row">
		                <label style="width: 100px;" for="sensor2">Sensor 2</label><br>
		                <input type="text" id="sensor2" name="sensor2" class="textfield"><br>
		            </div>
		        </div>
		    </div>
		
		    <br>
		
		    <label for="isChannelPublic">Is Channel Public</label>
		    <input type="radio" id="isChannelPublic" value="isChannelPublic" name="isChannelPublic"><br>
		    
			
			
			<button type="submit" class="submit-btn" style="margin-top: 50px;
    margin-bottom: 50px;
    width: 200px;
    height: 75px;
    margin-left: 300px;">Create channel</button>
		</div>
	</form>
    
</body>
</html>