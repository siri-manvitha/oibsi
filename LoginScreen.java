import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Screen");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 50, 160, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 160, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 150, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordField.getPassword());

                // Example validation
                if (username.equals("apple") && password.equals("password")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful");
                    frame.dispose();
                    openMainScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                }
            }
        });

        frame.setVisible(true);
    }

    public static void openMainScreen() {
        JFrame mainFrame = new JFrame("Main Screen");
        mainFrame.setSize(500, 400);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainFrame.add(mainPanel);
        mainPanel.setLayout(null);

        JButton updateProfileButton = new JButton("Update Profile");
        updateProfileButton.setBounds(50, 50, 150, 30);
        mainPanel.add(updateProfileButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(200, 50, 150, 30);
        mainPanel.add(logoutButton);

        JButton startQuizButton = new JButton("Start Quiz");
        startQuizButton.setBounds(50, 100, 150, 30);
        mainPanel.add(startQuizButton);

        startQuizButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                startQuiz();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
                System.exit(0);
            }
        });

        updateProfileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openUpdateProfile();
            }
        });

        mainFrame.setVisible(true);
    }

    public static void openUpdateProfile() {
        JFrame updateFrame = new JFrame("Update Profile");
        updateFrame.setSize(400, 300);
        updateFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel updatePanel = new JPanel();
        updateFrame.add(updatePanel);
        updatePanel.setLayout(null);

        JLabel newPasswordLabel = new JLabel("New Password:");
        newPasswordLabel.setBounds(50, 50, 100, 25);
        updatePanel.add(newPasswordLabel);

        JPasswordField newPasswordField = new JPasswordField(20);
        newPasswordField.setBounds(150, 50, 160, 25);
        updatePanel.add(newPasswordField);

        JButton updateButton = new JButton("Update");
        updateButton.setBounds(150, 100, 80, 25);
        updatePanel.add(updateButton);

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordField.getPassword());
                JOptionPane.showMessageDialog(updateFrame, "Password Updated Successfully");
                updateFrame.dispose();
            }
        });

        updateFrame.setVisible(true);
    }

    public static void startQuiz() {
        JFrame quizFrame = new JFrame("MCQ Quiz");
        quizFrame.setSize(500, 400);
        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel quizPanel = new JPanel();
        quizFrame.add(quizPanel);
        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));

        JLabel questionLabel = new JLabel("Question 1: What is Java?");
        quizPanel.add(questionLabel);

        JRadioButton option1 = new JRadioButton("Programming Language");
        JRadioButton option2 = new JRadioButton("Operating System");
        JRadioButton option3 = new JRadioButton("Hardware");

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        quizPanel.add(option1);
        quizPanel.add(option2);
        quizPanel.add(option3);

        JButton submitButton = new JButton("Submit");
        quizPanel.add(submitButton);

        Timer timer = new Timer(1000, new ActionListener() {
            int timeRemaining = 10;
            public void actionPerformed(ActionEvent e) {
                if (timeRemaining > 0) {
                    timeRemaining--;
                } else {
                    JOptionPane.showMessageDialog(quizFrame, "Time's up! Auto-submitting...");
                    submitButton.doClick();
                }
            }
        });
        timer.start();

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (option1.isSelected()) {
                    JOptionPane.showMessageDialog(quizFrame, "Correct Answer");
                } else {
                    JOptionPane.showMessageDialog(quizFrame, "Incorrect Answer");
                }
                quizFrame.dispose();
            }
        });

        quizFrame.setVisible(true);
    }
}
