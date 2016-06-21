<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
<head/>

<body>
 <h4>Weather report</h4>
 <a href="http://localhost:8080/weather-report?cityName=London">London</a>
 <a href="http://localhost:8080/weather-report?cityName=Hongkong">Hongkong</a>
 <br><br>
 
 <c:if test = "${not empty report}">
  <c:out value="${report.dt}" /><br>
  <b><c:out value="${report.name}" />
  <fmt:formatNumber value="${report.main.temp - 273.15}"  minFractionDigits="0" maxFractionDigits="1" /> &#8451;
  (<fmt:formatNumber value="${((report.main.temp - 273.15)*9/5)+32}"  minFractionDigits="0" maxFractionDigits="1" /> &#8457;)
  
  <c:out value="${report.weather[0].description}" /></b>
  <br> Sunrise :
  <span title="Sunrise"><fmt:formatDate
    value="${report.sys.sunrise}" pattern="HH:mm" /></span>
  <br> Sunset :
  <span title="Sunset"><fmt:formatDate
    value="${report.sys.sunset}" pattern="HH:mm" /></span>
  <br>
</c:if>

 <br> <i> Raw weather data:
 <a href="/api/weather-report/London">London</a>
 <a href="/api/weather-report/Hongkong">Hongkong</a>
 </i>
</body>
</html>