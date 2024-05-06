package entity;

public class QuestionTopic extends BaseEntity {

    private int questionTopicId;
    private Question question;
    private Topic topic;

    public QuestionTopic() {
    }

    public QuestionTopic(int questionTopicId, Question question, Topic topic) {
        this.questionTopicId = questionTopicId;
        this.question = question;
        this.topic = topic;
    }

    public int getQuestionTopicId() {
        return questionTopicId;
    }

    public void setQuestionTopicId(int questionTopicId) {
        this.questionTopicId = questionTopicId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

}
