<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Q&A Community</title>
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
            <a href="">Home</a>
            <a href="ask_question.jsp">Ask Question</a>
            <a href="qaListController">Q&A</a>
           
        </nav>

        <main>
            <h2>Latest Questions</h2>

            <div class="question">
                <h3>How to learn programming effectively?</h3>
                <p>I am a beginner in learning programming, can anyone share their experience and advice on how to learn programming effectively?</p>
            </div>

            <div class="question">
                <h3>What's the difference between JavaScript and Java?</h3>
                <p>I often get confused between JavaScript and Java, can you explain the difference between these two languages to me?</p>
            </div>

        </main>

        <footer>
            <p>&copy; 2023 Q&A Community. All rights reserved.</p>
        </footer>
        <div id="loginModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <jsp:include page="login.jsp" />
            </div>
        </div>
        <div id="registerModal" class="modal">
            <div class="modal-content">
                <span class="close">&times;</span>
                <jsp:include page="register.jsp" />
            </div>
        </div>
        <script>
            var loginModal = document.getElementById("loginModal");
            var registerModal = document.getElementById("registerModal");

            var spans = document.getElementsByClassName("close");

            var loginBtn = document.querySelector(".header-buttons a:first-child");
            loginBtn.onclick = function () {
                loginModal.style.display = "block";
            }

            var signupBtn = document.querySelector(".header-buttons a:last-child");
            signupBtn.onclick = function () {
                registerModal.style.display = "block";
            }


            for (var i = 0; i < spans.length; i++) {
                spans[i].onclick = function () {
                    loginModal.style.display = "none";
                    registerModal.style.display = "none";
                }
            }

            window.onclick = function (event) {
                if (event.target === loginModal) {
                    loginModal.style.display = "none";
                } else if (event.target === registerModal) {
                    registerModal.style.display = "none";
                }
            }
        </script>
    </body>
</html>