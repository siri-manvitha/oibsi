import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OnlineReservationSystem extends JFrame 
{
    private CardLayout cardLayout;
    private JPanel cardPanel;
    
    // Login Form components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    
    // Reservation Form components
    private JTextField nameField, trainNoField, classTypeField, dateField, fromField, toField;
    private JButton submitButton;
    
    // Cancellation Form components
    private JTextField pnrField;
    private JButton cancelButton, confirmCancelButton;

    public OnlineReservationSystem()
 {
        setTitle("Online Reservation System");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Initialize and add all forms
        initializeLoginForm();
        initializeReservationForm();
        initializeCancellationForm();

        add(cardPanel);
        setVisible(true);
  }

    // Login Form
    private void initializeLoginForm()
 {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3,2));
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(15);        
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (username.equals("sirimanvitha") && password.equals("siri123"))
                {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    cardLayout.show(cardPanel,"reservationForm"); // Go to reservation form
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            }
        });
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        cardPanel.add(loginPanel, "loginForm");
    }
    // Reservation Form
    private void initializeReservationForm() 
    {
        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new GridLayout(7,2));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);        
        JLabel trainNoLabel = new JLabel("Train No:");
        trainNoField = new JTextField(20);        
        JLabel classTypeLabel = new JLabel("Class Type:");
        classTypeField = new JTextField(20);        
        JLabel dateLabel = new JLabel("Date of Journey:");
        dateField = new JTextField(20);        
        JLabel fromLabel = new JLabel("From:");
        fromField = new JTextField(20);        
        JLabel toLabel = new JLabel("To:");
        toField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
             {
                String name = nameField.getText();
                String trainNo = trainNoField.getText();
                String classType = classTypeField.getText();
                String date = dateField.getText();
                String from = fromField.getText();
                String to = toField.getText();
                JOptionPane.showMessageDialog(null, "Reservation Details: \n"
                        + "Name: " + name + "\n"
                        + "Train No: " + trainNo + "\n"
                        + "Class Type: " + classType + "\n"
                        + "Date of Journey: " + date + "\n"
                        + "From: " + from + "\n"
                        + "To: " + to);
            }
        });

        reservationPanel.add(nameLabel);
        reservationPanel.add(nameField);
        reservationPanel.add(trainNoLabel);
        reservationPanel.add(trainNoField);
        reservationPanel.add(classTypeLabel);
        reservationPanel.add(classTypeField);
        reservationPanel.add(dateLabel);
        reservationPanel.add(dateField);
        reservationPanel.add(fromLabel);
        reservationPanel.add(fromField);
        reservationPanel.add(toLabel);
        reservationPanel.add(toField);
        reservationPanel.add(submitButton);

        JButton cancelReservationButton = new JButton("Cancel Reservation");
        cancelReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "cancellationForm");
            }
        });
        
        reservationPanel.add(cancelReservationButton);

        cardPanel.add(reservationPanel, "reservationForm");
    }

    // Cancellation Form
    private void initializeCancellationForm() {
        JPanel cancellationPanel = new JPanel();
        cancellationPanel.setLayout(new FlowLayout());

        JLabel pnrLabel = new JLabel("PNR No:");
        pnrField = new JTextField(20);
        
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pnr = pnrField.getText();
                // For simplicity, assume dummy data is shown when a PNR is entered
                JOptionPane.showMessageDialog(null, "Reservation Details for PNR: " + pnr + "\n"
                        + "Name: John Doe\n"
                        + "Train No: 12345\n"
                        + "Class: Sleeper\n"
                        + "Date: 01/02/2025\n"
                        + "From: City A\n"
                        + "To: City B");
                
                int confirmation = JOptionPane.showConfirmDialog(null, "Do you want to cancel this ticket?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
                if (confirmation == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(null, "Ticket Cancelled Successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cancellation Cancelled.");
                }
            }
        });

        cancellationPanel.add(pnrLabel);
        cancellationPanel.add(pnrField);
        cancellationPanel.add(cancelButton);

        JButton backButton = new JButton("Back to Reservation");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "reservationForm");
            }
        });
        
        cancellationPanel.add(backButton);

        cardPanel.add(cancellationPanel, "cancellationForm");
    }

    public static void main(String[] args) {
        new OnlineReservationSystem();
    }
}
