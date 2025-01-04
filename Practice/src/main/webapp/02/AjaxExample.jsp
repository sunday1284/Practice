<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 예제</title>
</head>
<body>
	<h1>AJAX 서블릿</h1>
	<button onclick="sendAjax()">AJAX 요청 보내기</button>
	<p id="ajaxResult"></p>
	
	<script type="text/javascript">
		function sendAjax(){
			const xhr = new XMLHttpRequest();
			//GET요청으로 서블릿 호출
			xhr.open("GET","<%=request.getContextPath()%>/ajaxServlet.do",true);
			
			//응답이 준비되면 실행되는 콜백 함수
			xhr.onload = function () {
				if(xhr.status = 200){
					const response = JSON.parse(xhr.responseText)
					document.getElementById("ajaxResult").innerText = response.message;
				}
			};
			xhr.send(); //요청 전송 
		
		}
	
	</script>
</body>
</html>