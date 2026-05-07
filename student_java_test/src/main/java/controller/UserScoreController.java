package controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import model.dao.ConnectionUtility;
import model.dao.UserScoreDao;
import model.entity.UserScore;

public class UserScoreController {
	Connection con;
	Scanner sc;
	UserScoreDao sdao;

	public UserScoreController() {
	    con = ConnectionUtility.getConnectionUtil();
	    sdao = new UserScoreDao(con);
	    sc = new Scanner(System.in);
	}

	public boolean saveScore(int userId,  int score) {
	    UserScore us = new UserScore();
	    us.setUserId(userId);
	    us.setScore(score);
	   

	    return sdao.saveUserScore(us);
	}

	public List<UserScore> getUserScoreHistory(Integer userId) {
	    return sdao.getScoresByUser(userId);
	}
	  
}
