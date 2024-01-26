<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.plantlink.controller.CodeGenerator,com.plantlink.builder.SensorCode"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/sensorPage.css">
    <title>Create Sensor</title>
</head>
<body>

	
	<jsp:include page="header.jsp" />
	<jsp:include page="headerchannel.jsp">
			<jsp:param name="img" value="${pageContext.request.contextPath }/resources/images/backgroundimage.png" />
			<jsp:param name="text" value="Register Sensor" />
			
		</jsp:include>
		
	<div class="content-body">
	<form action="/plantlink/code/generateCode" method="POST">
		 <!-- PLATFORM -->
	    <div class = "platform-container">
	    
	        <h3>Select Platform</h3><br>
	        <div class="platformOption-container">
	            <!-- Arduino -->
	            <div class="thePlatform">
	                <div class="thePlatform-logo"><img src="${pageContext.request.contextPath }/resources/images/arduino_logo.png" alt="arduino"></div>
	                <div class="thePlatform-name"><input type="radio" name="platform" value="arduino" checked="checked"><label for="Arduino">Arduino</label></div>
	            </div>
	            <!-- Raspberry Pi -->
	            <div class="thePlatform">
	                <div class="thePlatform-logo"><img src="${pageContext.request.contextPath }/resources/images/micropython.png" alt="RaspberryPi"></div>
	                <div class="thePlatform-name"><input type="radio" name="platform" value="micropython"><label for="micropython">MicroPython</label></div>
	            </div>
	             <!-- Raspberry Pi -->
	            <div class="thePlatform">
	                <div class="thePlatform-logo"><img src="${pageContext.request.contextPath }/resources/images/circuitpython.png" alt="RaspberryPi"></div>
	                <div class="thePlatform-name"><input type="radio" name="platform" value="circuitpython"><label for="circuitpython">CircuitPython</label></div>
	            </div>
	        </div>
	    </div><br>
	
		<div class="question-div">
			<p class="question">
		    	Does it use custom imports?
		    	<input
		    		type="checkbox"
		    		name="iscustom"
		    		id=""
		    		/>
	   		</p>
		</div>
		<br />
		<br />
		
		<div class="question-div">
		<p class="question">Choose connection method</p>
			<div class="connection-method-div">
              <div class="connection-option">
                <input
                  type="radio"
                  name="connection-method"
                  id="wifi"
                  value="wifi"
                  checked
                />
                <label for="wifi">WiFi</label>
              </div>
              <div class="connection-option">
                <input
                  type="radio"
                  name="connection-method"
                  id="ethernet"
                  value="ethernet"
                 	
                />
                <label for="ethernet">Ethernet</label>
              </div>
            </div>
		</div>
		<button type="submit">Generate code!</button>
		
	    </form>
	</div>
   
</body>
</html>