package entity;

public class Rating extends BaseEntity {

    private int ratingId;
    private Answer answer;
    private User user;
    private int rating;

    public Rating() {
    }

    public Rating(int ratingId, Answer answer, User user, int rating) {
        this.ratingId = ratingId;
        this.answer = answer;
        this.user = user;
        this.rating = rating;
    }

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
