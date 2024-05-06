package entity;

import java.util.List;

public class Topic extends BaseEntity {

    private int topicId;
    private String topicName;
    private List<QuestionTopic> questionTopics;

    public Topic() {
    }

    public Topic(int topicId, String topicName, List<QuestionTopic> questionTopics) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.questionTopics = questionTopics;
    }



    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public List<QuestionTopic> getQuestionTopics() {
        return questionTopics;
    }

    public void setQuestionTopics(List<QuestionTopic> questionTopics) {
        this.questionTopics = questionTopics;
    }

    
}
