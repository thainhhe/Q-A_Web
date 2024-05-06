package dal;

import entity.Question;
import entity.User;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;

public class QuestionDBContext extends DBContext<Question> {

    @Override
    public ArrayList<Question> list() {
        ArrayList<Question> questions = new ArrayList<>();
        String sql = "SELECT * FROM Questions order by QuestionId desc";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("QuestionId");
                int userId = resultSet.getInt("UserId");
                String questionTitle = resultSet.getString("QuestionTitle");
                String questionContent = resultSet.getString("QuestionContent");
                Date createdDate = resultSet.getDate("CreatedDate");
                User user = new User();
                user.setUserId(userId);
                Question question = new Question();
                question.setQuestionId(questionId);
                question.setUser(user);
                question.setQuestionTitle(questionTitle);
                question.setQuestionContent(questionContent);
                question.setCreatedDate(createdDate);
                questions.add(question);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    @Override
    public void insert(Question entity) {
        String sql = "INSERT INTO Questions (UserId, QuestionTitle, QuestionContent) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, entity.getUser().getUserId());
            statement.setString(2, entity.getQuestionTitle());
            statement.setString(3, entity.getQuestionContent());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Question> searchByQuestionTitle(String keyword) {
        ArrayList<Question> searchTitle = new ArrayList<>();
        String sql = "SELECT * FROM Questions WHERE QuestionTitle LIKE ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("QuestionId");
                int userId = resultSet.getInt("UserId");
                String questionTitle = resultSet.getString("QuestionTitle");
                String questionContent = resultSet.getString("QuestionContent");
                User user = new User();
                user.setUserId(userId);
                Question question = new Question();
                question.setQuestionId(questionId);
                question.setUser(user);
                question.setQuestionTitle(questionTitle);
                question.setQuestionContent(questionContent);
                searchTitle.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchTitle;
    }

    public ArrayList<Question> searchByQuestionContent(String keyword) {
        ArrayList<Question> searchContent = new ArrayList<>();
        String sql = "SELECT * FROM Questions WHERE QuestionContent LIKE ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int questionId = resultSet.getInt("QuestionId");
                int userId = resultSet.getInt("UserId");
                String questionTitle = resultSet.getString("QuestionTitle");
                String questionContent = resultSet.getString("QuestionContent");
                User user = new User();
                user.setUserId(userId);
                Question question = new Question();
                question.setQuestionId(questionId);
                question.setUser(user);
                question.setQuestionTitle(questionTitle);
                question.setQuestionContent(questionContent);
                searchContent.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searchContent;
    }
    
    public Question getQuestionById(int questionId) {
        Question question = null;
        String sql = "SELECT * FROM Questions WHERE QuestionId = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, questionId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int userId = resultSet.getInt("UserId");
                String questionTitle = resultSet.getString("QuestionTitle");
                String questionContent = resultSet.getString("QuestionContent");

                User user = new User();
                user.setUserId(userId);

                question = new Question(questionId, user, questionTitle, questionContent, null, null, null, null);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }

    @Override
    public void update(Question updatedQuestion) {
    String sql = "UPDATE Questions SET QuestionTitle = ?, QuestionContent = ? WHERE QuestionId = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, updatedQuestion.getQuestionTitle());
        statement.setString(2, updatedQuestion.getQuestionContent());
        statement.setInt(3, updatedQuestion.getQuestionId());
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public void delete(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Question get(Question entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteQuestionById(int questionId) {
 String sql = "DELETE FROM Questions WHERE QuestionId = ?";
    try {
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, questionId);
        statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }    }


}
