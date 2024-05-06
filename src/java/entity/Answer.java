package entity;

import java.util.Date;
import java.util.List;

public class Answer extends BaseEntity {

    private int answerId;
    private Question question;
    private User user;
    private String answerContent;
    private Date createdDate;
    private List<Rating> ratings;

    public Answer() {
    }

    public Answer(int answerId, Question question, User user, String answerContent, Date createdDate, List<Rating> ratings) {
        this.answerId = answerId;
        this.question = question;
        this.user = user;
        this.answerContent = answerContent;
        this.createdDate = createdDate;
        this.ratings = ratings;
    }


    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
