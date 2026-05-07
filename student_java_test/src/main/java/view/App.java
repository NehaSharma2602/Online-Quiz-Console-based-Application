package view;

import java.util.List;
import java.util.Scanner;

import controller.QuestionController;
import controller.UserController;
import controller.UserScoreController;
import model.entity.Questions;
import model.entity.User;
import model.entity.UserScore;

public class App {

    Scanner sc;

    UserController userController;
    QuestionController questionController;
    UserScoreController scoreController;

    User loggedInUser = null;

    public App() {
        sc = new Scanner(System.in);
        userController = new UserController();
        questionController = new QuestionController();
        scoreController = new UserScoreController();
    }

    public static void main(String[] args) {
        App view = new App();
        view.startApp();
    }

    public void startApp() {
        boolean isRunning = true;

        System.out.println("=============== Test Application Started ===============");

        while (isRunning) {
            System.out.println();
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;

                case 2:
                    loginUser();
                    break;

                case 3:
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid option! Try again.");
            }
        }

        System.out.println("================ Application Closed ================");
    }

    // ======================= REGISTER ==========================
    private void registerUser() {
        boolean done = userController.registerUser();
        if (done)
            System.out.println("Registration Successful!");
        else
            System.out.println("Registration Failed!");
    }

    // ======================= LOGIN =============================
    private void loginUser() {
        loggedInUser = userController.loginUser();

        if (loggedInUser != null) {
            System.out.println("Login Success! Welcome " + loggedInUser.getName());
            userMenu();
        } else {
            System.out.println("Invalid email/password!");
        }
    }

    // ======================= USER MENU ===========================
    private void userMenu() {
        boolean isUserActive = true;

        while (isUserActive) {
            System.out.println();
            System.out.println("===== USER MENU =====");
            System.out.println("1. Take Test");
            System.out.println("2. View Score History");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    takeTest();
                    break;

                case 2:
                    viewHistory();
                    break;

                case 3:
                    loggedInUser = null;
                    isUserActive = false;
                    System.out.println("Logged Out Successfully!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ======================= TAKE TEST ===========================
    private void takeTest() {
        System.out.println("==== Choose Test Type ====");
        System.out.println("1. Topic Wise Questions");
        System.out.println("2. Difficulty Wise Questions");
        System.out.println("3. Mixed Random Questions");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();
        sc.nextLine();

        List<Questions> questions = null;

        switch (choice) {
            case 1:
                questions = questionController.getQuestionsByTopic();
                break;

            case 2:
                questions = questionController.getQuestionsByDifficulty();
                break;

            case 3:
                questions = questionController.getRandomMixedQuestions();
                break;

            default:
                System.out.println("Invalid choice!");
                return;
        }

        if (questions == null || questions.isEmpty()) {
            System.out.println("No Questions Found!");
            return;
        }

        int score = 0;
        int total = questions.size();

        // Ask questions
        for (Questions q : questions) {
            System.out.println("--------------------------------");
            System.out.println(q.getQuestion());
            System.out.println("A. " + q.getOptionA());
            System.out.println("B. " + q.getOptionB());
            System.out.println("C. " + q.getOptionC());
            System.out.println("D. " + q.getOptionD());
            System.out.print("Enter Answer (A/B/C/D): ");

            String ans = sc.nextLine().toUpperCase();

            if (ans.equals(q.getCorrectOption()))
                score++;
        }

        System.out.println("\n==== TEST COMPLETED ====");
        System.out.println("Your Score: " + score + "/" + total);

        boolean saved = scoreController.saveScore(loggedInUser.getId(), score);

        if (saved)
            System.out.println("Score Saved Successfully!");
        else
            System.out.println("Failed to Save Score!");
    }

    // ======================= VIEW SCORE HISTORY ===================
    private void viewHistory() {
        System.out.println("==== Your Score History ====");

        List<UserScore> list = scoreController.getUserScoreHistory(loggedInUser.getId());

        if (list == null || list.isEmpty()) {
            System.out.println("No Scores Found!");
            return;
        }

        for (UserScore us : list) {
            System.out.println("--------------------------------");
            System.out.println("Score: " + us.getScore());
            System.out.println("Total Questions: 10");
            System.out.println("Attempted At: " + us.getAttemptedAt());
        }
    }

}
