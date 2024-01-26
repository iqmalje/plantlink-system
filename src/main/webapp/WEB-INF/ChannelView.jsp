<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath }/resources/css/ChannelView.css">
      </head>   
  <body>

	<jsp:include page="header.jsp" />
		<jsp:include page="headerchannel.jsp">
			<jsp:param name="img" value="${pageContext.request.contextPath }/resources/images/backgroundimage.png" />
			<jsp:param name="text" value="${channel.getName() }" />
			
	</jsp:include>
    <div class="system-container-row">
        <div class="system-container">
            <div class="system-name">
               	${channel.getName() }
            </div>

            <div class="system-description">
                ${channel.getDescription() }
            </div>


            <div class="text-subject-row">
                <div class="text-subject">
                    Channel ID: 
                </div>

                <div class="text-subject-description">
                    ${channel.getId() }
                </div>
            </div>

            

            <div class="text-subject-row">
                <div class="text-subject">
                    Access:
                </div>

                <div class="text-subject-description">
                    <c:if test="${channel.isPublic() == true }">
                    	Public
                   	</c:if>
                   	<c:if test="${channel.isPublic() == false }">
                    	Private
                   	</c:if>
                </div>
            </div>

            

            <div class="map-box" style="background-image:url('${pageContext.request.contextPath }/resources/images/exmap.png')">
    
            </div>  

        </div>

    </div>     

    
    <div class="data-visualization">
        Data Visualization
    </div>

    <div class="space5top"></div>

    <div class="visulization-box-container">
        <div class="vis-box-row">
            <div class="visualization-box">
                Temperature(‘C) vs Time(s)
            </div>

            <div class="visualization-box">
                Humidity(g.kg-1) vs Time(day)
            </div>
        </div>

        <div class="space5top"></div>

        <div class="vis-box-row">
            <div class="visualization-box">
                Temperature Gauge
            </div>

            <div class="visualization-box">
                Humidity Gauge
            </div>
        </div>
    </div>


   
    </body>


</html>
