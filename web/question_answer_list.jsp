
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Q&A Community - Question List</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }



            nav {
                background-color: #f2f2f2;
                padding: 10px;
                text-align: center;
            }

            nav a {
                color: #333;
                text-decoration: none;
                padding: 10px;
            }

            nav a:hover {
                background-color: #ddd;
            }

            main {
                max-width: 800px;
                margin: 20px auto;
                padding: 20px;
            }

            .question {
                border: 1px solid #ccc;
                padding: 10px;
                margin-bottom: 20px;
            }

            .question h3 {
                margin-top: 0;
            }

            footer {
                background-color: #333;
                color: #fff;
                padding: 20px;
                text-align: center;
            }

            header {
                background-color: #333;
                color: #fff;
                padding: 20px;
                text-align: center;
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

            .header-buttons {
                display: flex;
            }

            .btn {
                background-color: #fff;
                color: #333;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 5px;
                margin-left: 10px;
            }

            .btn:hover {
                background-color: #ddd;
            }

            .modal {
                display: none;
                position: fixed;
                z-index: 1;
                left: 0;
                top: 0;
                width: 100%;
                height: 100%;
                overflow: auto;
                background-color: rgba(0, 0, 0, 0.4);
            }

            .modal-content {
                background-color: #fefefe;
                margin: 15% auto;
                padding: 20px;
                border: 1px solid #888;
                width: 30%;
            }

            .close {
                color: #aaa;
                float: right;
                font-size: 28px;
                font-weight: bold;
            }

            .close:hover,
            .close:focus {
                color: black;
                text-decoration: none;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>Q&A Community</h1>
            <div class="header-buttons">
                <a href="#" class="btn">Login</a>
                <a href="register.jsp" class="btn">Sign Up</a><br/>
                <p>Hello ${sessionScope.user.userName}</p>
            </div>
        </header>

        <nav>
            <a href="home.jsp">Home</a>
            <a href="ask_question.jsp">Ask Question</a>
            <a href="qaListController">Q&A</a>
            
        </nav>

        <main>
            <h2>Question List</h2>
            <form action="qaListController" method="post">
                <label for="searchType">Tìm kiếm theo:</label>
                <select name="searchType" id="searchType">
                    <option value="answer">Câu trả lời</option>
                    <option value="questionTitle">Tiêu đề câu hỏi</option>
                    <option value="questionContent">Nội dung câu hỏi</option>
                </select>
                <input type="text" name="keyword" id="keyword">
                <input type="submit" value="Tìm kiếm"><br>
                <c:forEach var="answer" items="${answerSearch}">
                    Answer: ${answer.answerContent}<br>
                </c:forEach>
                <c:forEach var="title" items="${questionSearchTitle}">
                    Title: ${title.questionTitle}<br>
                </c:forEach>
                <c:forEach var="content" items="${questionSearchContent}">
                    Content: ${content.questionContent}<br>
                </c:forEach>
            </form>

            <form action="qaListController" method="get">
                <table>
                    <c:forEach var="question" items="${questionList}">
                        <tr>
                            <td>
                                <a href="deleteQuestionController?questionId=${question.questionId}">Delete</a>
                                <a href="answerQuestionController?questionId=${question.questionId}">Title:${question.questionTitle}</a><br>
                                Content: ${question.questionContent}<br>
                                Date: ${question.createdDate}<br>
                                <a href="updateQuestionController?questionId=${question.questionId}">Update</a>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <c:forEach var="answer" items="${answerList}">
                                    <c:if test="${answer.question.questionId == question.questionId}">
                                        Answer: ${answer.answerContent}<br>
                                    </c:if>
                                </c:forEach>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            <a href="qaListController">Back</a>
        </main>
            


        <footer>
            <p>&copy; 2023 Q&A Community. All rights reserved.</p>
        </footer>
    </body>
</html>
