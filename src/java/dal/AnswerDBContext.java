package dal;

import entity.Answer;
import entity.Question;
import entity.User;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class AnswerDBContext extends DBContext<Answer> {

    @Override
    public ArrayList<Answer> list() {
        ArrayList<Answer> answers = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Answers order by AnswerId desc";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int answerId = resultSet.getInt("AnswerId");
                int questionId = resultSet.getInt("QuestionId");
                int userId = resultSet.getInt("UserId");
                String answerContent = resultSet.getString("AnswerContent");

                User user = new User();
                user.setUserId(userId);

                Question question = new Question();
                question.setQuestionId(questionId);

                Answer answer = new Answer();
                answer.setQuestion(question);
                answer.setUser(user);
                answer.setAnswerId(answerId);
                answer.setAnswerContent(answerContent);
                answers.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answers;
    }

    @Override
    public void insert(Answer entity) {
        String sql = "INSERT INTO Answers (QuestionId, UserId, AnswerContent) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getQuestion().getQuestionId());
            statement.setInt(2, entity.getUser().getUserId());
            statement.setString(3, entity.getAnswerContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Answer> searchByAnswer(String keyword) {
        ArrayList<Answer> searchedAnswers = new ArrayList<>();
        String sql = "SELECT * FROM Answers WHERE AnswerContent LIKE ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int answerId = resultSet.getInt("AnswerId");
                int questionId = resultSet.getInt("QuestionId");
                int userId = resultSet.getInt("UserId");
                String answerContent = resultSet.getString("AnswerContent");

                User user = new User();
                user.setUserId(userId);

                Question question = new Question();
                question.setQuestionId(questionId);

                Answer answer = new Answer();
                answer.setQuestion(question);
                answer.setUser(user);
                answer.setAnswerId(answerId);
                answer.setAnswerContent(answerContent);

                searchedAnswers.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchedAnswers;
    }

    public Answer getPreviousAnswer(int questionId) {
        Answer previousAnswer = null;
        String sql = "SELECT Top 3 * FROM Answers WHERE QuestionId = ? ORDER BY CreatedDate DESC ";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int answerId = resultSet.getInt("AnswerId");
                int userId = resultSet.getInt("UserId");
                String answerContent = resultSet.getString("AnswerContent");

                User user = new User();
                user.setUserId(userId);
                previousAnswer = new Answer(answerId, null, user, answerContent, null, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return previousAnswer;
    }

    @Override
    public void update(Answer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Answer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Answer get(Answer entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    


}
