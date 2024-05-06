package controller;

import dal.AnswerDBContext;
import dal.QuestionDBContext;
import entity.Answer;
import entity.Question;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class QuestionAnswerListController extends HttpServlet {

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
        QuestionDBContext questionDBContext = new QuestionDBContext();
        ArrayList<Question> questionList = questionDBContext.list();

        AnswerDBContext answerDBContext = new AnswerDBContext();
        ArrayList<Answer> answerList = answerDBContext.list();

        request.setAttribute("questionList", questionList);
        request.setAttribute("answerList", answerList);

        request.getRequestDispatcher("question_answer_list.jsp").forward(request, response);
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
        String searchType = request.getParameter("searchType");
        String keyword = request.getParameter("keyword");
        
        
        if (searchType != null && keyword != null && !keyword.isEmpty()) {
            if (searchType.equals("answer")) {
                if (searchType.equals("answer")) {
                    AnswerDBContext answerDBContext = new AnswerDBContext();
                    ArrayList<Answer> searchedAnswers = answerDBContext.searchByAnswer(keyword);

                    request.setAttribute("answerSearch", searchedAnswers);

                    request.getRequestDispatcher("question_answer_list.jsp").forward(request, response);
                }

            } else if (searchType.equals("questionTitle")) {

                QuestionDBContext questionDBContext = new QuestionDBContext();
                ArrayList<Question> searchTitle = questionDBContext.searchByQuestionTitle(keyword);

                request.setAttribute("questionSearchTitle", searchTitle);
                request.getRequestDispatcher("question_answer_list.jsp").forward(request, response);

            } else if (searchType.equals("questionContent")) {
                QuestionDBContext questionDBContext = new QuestionDBContext();
                ArrayList<Question> searchContent = questionDBContext.searchByQuestionContent(keyword);

                request.setAttribute("questionSearchContent", searchContent);
                request.getRequestDispatcher("question_answer_list.jsp").forward(request, response);

            }
        } else {
            processRequest(request, response);
        }
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
