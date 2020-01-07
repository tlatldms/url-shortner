<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://thymeleaf.org">
<head>
    <meta charset=UTF-8">
    <title>Insert title here</title>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
    <h1>Hello Spring Boot!</h1>
    <input id="inpt" name=inp>
    <input type="button" value="확인" id="btn">
    <h2 th:text="${shortened}"></h2>
    <script>

        $('#btn').click(function(event) {
            var origin=$('input[name=inp]').val();
            var tt={"origin":origin};
            $.ajax({
                type: "post",
                contentType : 'application/json',
                data : JSON.stringify(tt),
                url: '/',
                success: function() {
                    alert("성공");
                },
                error: function() {
                    alert("실패");
                }
            });
        });
    </script>
</body>
</html>
