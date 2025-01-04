<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fetch 예제</title>
</head>
<body>
	<h1>Fetch와 서블릿</h1>
	<button onclick="sendFetch()">Fetch 요청 보내기</button>
	<p id="fetchResult"></p>
	
	<script type="text/javascript">
		function sendFetch() {
			//Fetch API로 GET 요청
			fetch("<%=request.getContextPath()%>/fetchServlet.do")
				.then(response => {
					if(!response.ok){
						throw new Error(`HTTP error! Status: ${response.status}`);
					}
					
					return response.json(); //응답을 json으로 파싱
				})
				.then(data => {
					document.getElementById("fetchResult").innerText = data.message;
				})
				.catch(error => console.error("Error:", error));
		}
		
	</script>
</body>
</html>