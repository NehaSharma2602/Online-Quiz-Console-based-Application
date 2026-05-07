package controller;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import model.dao.ConnectionUtility;
import model.dao.QuestionDao;
import model.entity.Questions;

public class QuestionController {
	 Connection con;
	  Scanner sc;
	  QuestionDao qdao;
	  
	  public QuestionController() {
	      con = ConnectionUtility.getConnectionUtil();
	      qdao = new QuestionDao(con);
	      sc = new Scanner(System.in);
	  }

	  public List<Questions> getQuestionsByTopic() {
	      System.out.print("Enter Topic: ");
	      String topic = sc.nextLine();

	      return qdao.getQuestionsByTopic(topic);
	  }

	  public List<Questions> getQuestionsByDifficulty() {
	      System.out.print("Enter Difficulty (easy/medium/hard): ");
	      String diff = sc.nextLine();

	      return qdao.getQuestionsByDifficulty(diff);
	  }
	  
	  public List<Questions> getQuestionsByTopicAndDifficulty(){
		  System.out.print("Enter Topic: ");
	      String topic = sc.nextLine();
	      
	      System.out.print("Enter Difficulty (easy/medium/hard): ");
	      String diff = sc.nextLine();
	      
		  return qdao.getQuestionsByTopicAndDifficulty(topic, diff);
	  }

	  public List<Questions> getRandomMixedQuestions() {
	      System.out.print("How many questions you want? ");
	      int limit = sc.nextInt();
	      sc.nextLine();

	      return qdao.getRandomMixedQuestions(limit);
	  }
	  
}
