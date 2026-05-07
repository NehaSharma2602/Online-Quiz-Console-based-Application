package controller;

import java.sql.Connection;
import java.util.Scanner;

import model.dao.ConnectionUtility;
import model.dao.UserDao;
import model.entity.User;

public class UserController {
	Connection con;
	Scanner sc;
	UserDao userdao;

	public UserController() {
	    con = ConnectionUtility.getConnectionUtil();
	    sc = new Scanner(System.in);
	    userdao = new UserDao(con);
	}

	// ================= Register ===================
	public boolean registerUser() {
	    System.out.println("==== User Registration ====");
	    System.out.print("Enter Full Name: ");
	    String name = sc.nextLine();

	    System.out.print("Enter Email: ");
	    String email = sc.nextLine();

	    System.out.print("Enter Password: ");
	    String password = sc.nextLine();

	    User u = new User();
	    u.setName(name);
	    u.setEmail(email);
	    u.setPassword(password);

	    return userdao.registerUser(u);
	}

	// ================= Login ===================
	public User loginUser() {
	    System.out.println("==== Login ====");
	    System.out.print("Enter Email: ");
	    String email = sc.nextLine();

	    System.out.print("Enter Password: ");
	    String pass = sc.nextLine();

	    return userdao.loginUser(email, pass);
	}

}
