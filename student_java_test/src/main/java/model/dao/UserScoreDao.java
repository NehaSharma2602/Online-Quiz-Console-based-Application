package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.entity.UserScore;

public class UserScoreDao {

    private final Connection con;

    public UserScoreDao(Connection con) {
        this.con = con;
    }

    // ===================== SAVE USER SCORE ======================
    public boolean saveUserScore(UserScore score) {
        String sql = "INSERT INTO user_scores(user_id, score) VALUES (?, ?)";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, score.getUserId());
            ps.setInt(2, score.getScore());
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===================== GET SCORE HISTORY ======================
    public List<UserScore> getScoresByUser(int userId) {
        String sql = "SELECT * FROM user_scores WHERE user_id = ? ORDER BY attempted_at DESC";
        List<UserScore> list = new ArrayList<>();

        try (PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                UserScore s = new UserScore();
                s.setScoreId(rs.getInt("score_id"));
                s.setUserId(rs.getInt("user_id"));
                s.setScore(rs.getInt("score"));

                Timestamp ts = rs.getTimestamp("attempted_at");
                s.setAttemptedAt(ts != null ? ts.toString() : null);

                list.add(s);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
