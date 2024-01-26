<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.plantlink.builder.SensorCode"%>
    
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	.display-code{
	white-space: "pre"}
</style>
</head>
<body>
	<%
		SensorCode sc = (SensorCode) request.getAttribute("sensorcode");
	
		request.setAttribute("sc", sc);
	%>
	
	<div class="display-code">
		<code>
			<c:if test="${isCustomImport eq false}" >
			
				${sc.getImportsWIFI() }
				${sc.getImportsEthernet()}
			</c:if>
			
			
			<br />
			<br />
			
			
				${sc.getWIFIVariable() }
				${sc.getEthernetVariable() }
		        ${sc.getEndpointVariable()}
		        ${sc.getWifiConnect() }
		        ${sc.getEthernetConnect() }
		        
		        ${sc.getAPIKey()}
		        ${sc.getSendMethod()}
		        ${sc.getStructure()}
        </code>
	</div>
	
	
	
</body>
</html>