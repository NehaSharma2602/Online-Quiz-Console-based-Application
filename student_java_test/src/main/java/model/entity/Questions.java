package model.entity;

public class Questions {
    private Integer id;
    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctOption;
    private String difficulty;
    private String topic;

    public Questions() {
        super();
    }

    public Questions(String question, String optionA, String optionB, String optionC, String optionD,
                     String correctOption, String difficulty, String topic) {
        this.question = question;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctOption = correctOption;
        this.difficulty = difficulty;
        this.topic = topic;
    }

    public Questions(Integer id, String question, String optionA, String optionB, String optionC, String optionD,
                     String correctOption, String difficulty, String topic) {
        this(question, optionA, optionB, optionC, optionD, correctOption, difficulty, topic);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectOption() {
        return correctOption;
    }

    public void setCorrectOption(String correctOption) {
        this.correctOption = correctOption;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Questions [id=" + id + ", question=" + question + ", optionA=" + optionA + ", optionB=" + optionB
                + ", optionC=" + optionC + ", optionD=" + optionD + ", correctOption=" + correctOption
                + ", difficulty=" + difficulty + ", topic=" + topic + "]";
    }
}
