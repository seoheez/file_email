<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<c:if test="${userid == null }">
	<a href="${contextPath }/auth">이메일 인증하기</a>
</c:if>
<c:if test="${userid != null}">
	${userid }님 이메일 인증되었습니다.
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  -->
	<h2>제품소개</h2>
	<a href="https://shopping.naver.com/home/p/index.naver"> 
	<img src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTExMDJfMTgx%2FMDAxNjM1NzgwNTUyMzU1.sEn5jOfS9odT4EFp-0vN6EpZAffeuGdDCPl6X9oJm6wg.bHHQPKZsyWoO7RmNGDvTMDbQD1kjOF8ufpCjJGOlinUg.JPEG.suk5cc8e%2F%25BD%25BD%25B6%25F3%25C0%25CC%25B5%25E53.JPG&type=sc960_832">
	</a>
	
</body>
</html>