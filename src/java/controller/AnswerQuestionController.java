package controller;

import dal.AnswerDBContext;
import dal.QuestionDBContext;
import entity.Answer;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AnswerQuestionController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AnswerQuestionController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AnswerQuestionController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int questionId = Integer.parseInt(request.getParameter("questionId"));

        QuestionDBContext questionDBContext = new QuestionDBContext();
        Question question = questionDBContext.getQuestionById(questionId);

        AnswerDBContext answerDBContext = new AnswerDBContext();
        Answer previousAnswer = answerDBContext.getPreviousAnswer(questionId);

        request.setAttribute("question", question); 
        request.setAttribute("previousAnswer", previousAnswer); 
        request.getRequestDispatcher("answer_question.jsp").forward(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int questionId = Integer.parseInt(request.getParameter("questionId"));

        String answerContent = request.getParameter("answerContent");

        AnswerDBContext answerDBContext = new AnswerDBContext();
        Answer answer = new Answer();
        answer.setUser(user);
        answer.setAnswerContent(answerContent);
        Question question = new Question();
        question.setQuestionId(questionId);
        answer.setQuestion(question);

        answerDBContext.insert(answer);

        //response.sendRedirect("answerQuestionController?questionId=" + questionId);
        response.sendRedirect("qaListController");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
