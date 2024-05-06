package entity;

import java.util.Date;
import java.util.List;

public class Question extends BaseEntity {

    private int questionId;
    private User user;
    private String questionTitle;
    private String questionContent;
    private Date createdDate;
    private Date updatedDate;
    private List<QuestionTopic> questionTopics;
    private List<Answer> answers;

    public Question() {
    }

    public Question(int questionId, User user, String questionTitle, String questionContent, Date createdDate, Date updatedDate, List<QuestionTopic> questionTopics, List<Answer> answers) {
        this.questionId = questionId;
        this.user = user;
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.questionTopics = questionTopics;
        this.answers = answers;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public List<QuestionTopic> getQuestionTopics() {
        return questionTopics;
    }

    public void setQuestionTopics(List<QuestionTopic> questionTopics) {
        this.questionTopics = questionTopics;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

}
