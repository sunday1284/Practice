<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Application Attribute Example</h1>
	
	<!--application 범위 데이터 출력  -->
	<p>
		Value from application scope:
		<strong>
			<%= application.getAttribute("applicationAtt") != null
				? application.getAttribute("applicationAtt")
				: "No value set"%>
		</strong>
	</p>
	
	<!-- 새로운 값 입력 폼  -->
	<form action="applictionExample.do" method="get">
		<label for="newValue">Update Value:</label>
		<input type="text" id="newValue" name="newValue" required>
		<button type="submit">Update</button>
	</form>
	
</body>
</html>