<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="updateQuestionController" method="post">
    <input type="hidden" name="questionId" value="${question.questionId}">
    <label for="questionTitle">Title:</label><br>
    <input type="text" id="questionTitle" name="questionTitle" value="${question.questionTitle}"><br>
    <label for="questionContent">Content:</label><br>
    <textarea id="questionContent" name="questionContent">${question.questionContent}</textarea><br>
    <input type="submit" value="Update">
</form>
