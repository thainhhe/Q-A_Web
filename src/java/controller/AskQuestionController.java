package controller;

import dal.QuestionDBContext;
import entity.Question;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AskQuestionController extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AskQuestionController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AskQuestionController at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("ask_question.jsp").forward(request, response);
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

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String err = "";

        if (title == null || title.isEmpty() && (content == null || content.isEmpty())) {
            err = "Vui long dien day du cac truong";
            request.setAttribute("err", err);
            request.getRequestDispatcher("ask_question.jsp").forward(request, response);
        } else {
            if (title == null || title.isEmpty()) {
                err = "Ban chua nhap tieu de cau hoi";
                request.setAttribute("err", err);
                request.getRequestDispatcher("ask_question.jsp").forward(request, response);
            }

            if (err.isEmpty()) {
                if (content == null || content.isEmpty()) {
                    err = "Ban chua nhap noi dung cau hoi";
                    request.setAttribute("err", err);
                    request.getRequestDispatcher("ask_question.jsp").forward(request, response);
                } else {
                    QuestionDBContext questionDBContext = new QuestionDBContext();
                    Question question = new Question();
                    question.setUser(user);
                    question.setQuestionTitle(title);
                    question.setQuestionContent(content);

                    questionDBContext.insert(question);
                }

            }
        }
//        QuestionDBContext questionDBContext = new QuestionDBContext();
//        Question question = new Question();
//        question.setUser(user);
//        question.setQuestionTitle(title);
//        question.setQuestionContent(content);
//
//        questionDBContext.insert(question);

        response.sendRedirect("home.jsp");
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
