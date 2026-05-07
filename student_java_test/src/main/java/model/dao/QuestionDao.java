package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Questions;

public class QuestionDao {

    private final Connection con;
    PreparedStatement ps ;

    public QuestionDao(Connection con) {
        this.con = con;
    }

    // ================== Extract Method ===================
    private Questions extract(ResultSet rs) throws SQLException {
        Questions q = new Questions();

        q.setId(rs.getInt("question_id"));
        q.setQuestion(rs.getString("question_text"));
        q.setOptionA(rs.getString("option_a"));
        q.setOptionB(rs.getString("option_b"));
        q.setOptionC(rs.getString("option_c"));
        q.setOptionD(rs.getString("option_d"));
        q.setCorrectOption(rs.getString("correct_answer"));
        q.setDifficulty(rs.getString("difficulty"));
        q.setTopic(rs.getString("topic"));

        return q;
    }

    // ================== Get Questions by Topic ===================
    public List<Questions> getQuestionsByTopic(String topic) {
        String sql = "SELECT * FROM questions WHERE topic = ? ORDER BY RANDOM() LIMIT 10";
        List<Questions> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, topic);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extract(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }




    // ================== Get Questions by Difficulty ===================
    public List<Questions> getQuestionsByDifficulty(String diff) {
        String sql = "SELECT * FROM questions WHERE difficulty = ? ORDER BY RANDOM() LIMIT 10";
        List<Questions> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, diff);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extract(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    // ================== Get Questions by Topic + Difficulty ===================
    public List<Questions> getQuestionsByTopicAndDifficulty(String topic, String diff) {
        String sql = "SELECT * FROM questions WHERE topic = ? AND difficulty = ? ORDER BY RANDOM() LIMIT 10";
        List<Questions> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, topic);
            ps.setString(2, diff);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) list.add(extract(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


    // ================== Get Random Mixed Questions ===================
    public List<Questions> getRandomMixedQuestions(int limit) {
        // ⚠ Change RANDOM() to RAND() if using MySQL
        String sql = "SELECT * FROM questions ORDER BY RANDOM() LIMIT ?";
        List<Questions> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, limit);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extract(rs));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
