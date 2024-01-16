<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<form action="write" method="post" >
<div class="container-lg container mt-3">
<div class="mb-3 row">
	<label for="exampleFormControlInput1">제목</label>
	<input id="exampleFormControlInput1" class="form-control" name="title" placeholder="제목">
</div>
<div class="mb-3 row">
	<label for="exampleFormControlInput2">작성자</label>
	<input id="exampleFormControlInput2" class="form-control" name="writer" placeholder="작성자">
</div>
<div class="mb-3 row">
	<label for="exampleFormControlInpu3">내용</label>
	<textarea id="exampleFormControlInput3" class="form-control" name="content" placeholder="내용"></textarea>
</div>
<button class="btn btn-primary">register</button>
<a href="list" class="btn btn-success">list</a>
</div>
</form>
</body>
</html>