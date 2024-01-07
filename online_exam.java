import java.util.Scanner;

public class OnlineExamSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;

    public static void main(String[] args) {
        displayWelcomeMessage();

        currentUser = login();

        while (true) {
            displayMainMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    updatePassword();
                    break;
                case 3:
                    takeMCQs();
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to the Online Exam System!");
    }

    private static User login() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if ("user1".equals(username) && "12345".equals(password)) {
            return new User(username, "John Doe", "12345");
        } else {
            System.out.println("Invalid credentials. Exiting...");
            System.exit(0);
            return null; 
        }
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Update Profile");
        System.out.println("2. Update Password");
        System.out.println("3. Take MCQs");
        System.out.println("4. Logout");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print("Enter your choice: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void updateProfile() {
        System.out.print("Enter your new name: ");
        String newName = scanner.next();
        currentUser.setName(newName);
        System.out.println("Profile updated successfully. Your new name is: " + newName);
    }

    private static void updatePassword() {
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.next();
    
        if (currentUser.getPassword().equals(currentPassword)) {
            System.out.print("Enter your new password: ");
            String newPassword = scanner.next();
            currentUser.setPassword(newPassword);
            System.out.println("Password updated successfully.");
        } else {
            System.out.println("Incorrect current password. Unable to update password.");
        }
    }
    

private static void takeMCQs() {
    System.out.println("MCQs: ");

    for (int i = 1; i <= 5; i++) {
        displayMCQ(i);
    }

    System.out.println("MCQs answered. Auto-submitting...");


    System.out.println("MCQs submitted successfully.");
}

private static void displayMCQ(int questionNumber) {
    System.out.println("Question " + questionNumber + ": " + getMCQQuestionText(questionNumber));
    System.out.println("A. " + getMCQOption(questionNumber, 'A'));
    System.out.println("B. " + getMCQOption(questionNumber, 'B'));
    System.out.println("C. " + getMCQOption(questionNumber, 'C'));
    System.out.println("D. " + getMCQOption(questionNumber, 'D'));
    System.out.print("Your answer (A, B, C, or D): ");
    String userAnswer = scanner.next();

    boolean isCorrect = getCorrectAnswer(questionNumber).equalsIgnoreCase(userAnswer);

    System.out.println("Your answer is " + (isCorrect ? "correct!" : "incorrect!"));
}

private static String getMCQQuestionText(int questionNumber) {
    switch (questionNumber) {
        case 1:
            return "What does JVM stand for?";
        case 2:
            return "Which Java keyword is used to define a constant?";
        case 3:
            return "What is the main purpose of the break statement in Java?";
        case 4:
            return "In Java, what is the purpose of the 'super' keyword?";
        case 5:
            return "Which of the following Java concepts allows a class to have multiple methods having the same name but a different number or type of parameters?";
        default:
            return "Unknown question";
    }
}

private static String getMCQOption(int questionNumber, char option) {
    switch (questionNumber) {
        case 1:
            return (option == 'A') ? "Java Virtual Machine" : (option == 'B') ? "Java Visual Machine" :
                   (option == 'C') ? "Java Verified Machine" : "Java Virtual Module";
        case 2:
            return (option == 'A') ? "constant" : (option == 'B') ? "final" :
                   (option == 'C') ? "immutable" : "static";
        case 3:
            return (option == 'A') ? "To end the program execution" : (option == 'B') ? "To exit a loop or switch statement" :
                   (option == 'C') ? "To create a new line in the console" : "To define a method";
        case 4:
            return (option == 'A') ? "To invoke the superclass constructor" : (option == 'B') ? "To access the current class instance" :
                   (option == 'C') ? "To declare a static method" : "To define a constant value";
        case 5:
            return (option == 'A') ? "Inheritance" : (option == 'B') ? "Polymorphism" :
                   (option == 'C') ? "Encapsulation" : "Abstraction";
        default:
            return "Unknown Option";
    }
}

private static String getCorrectAnswer(int questionNumber) {
    switch (questionNumber) {
        case 1:
            return "A";
        case 2:
            return "B";
        case 3:
            return "B";
        case 4:
            return "A";
        case 5:
            return "B";
        default:
            return "Unknown Answer";
    }
}

    private static void logout() {
        System.out.println("Logging out. Goodbye, " + currentUser.getName() + "!");
        System.exit(0);
    }
}

class User {
    private String username;
    private String name;
    private String password;

    public User(String username, String name, String string) {
        this.username = username;
        this.name = name;
        this.password = "password"; 
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public boolean verifyPassword(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}


