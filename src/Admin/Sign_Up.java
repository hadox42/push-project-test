package Admin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import System.User_Manager;

public class Sign_Up extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtUsername;
    private JPasswordField txtPass;
    private JPasswordField txtRePass;
    private JPasswordField txtResetPassCode;
    private Connection connection;

    public Sign_Up() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 482, 622);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(new Color(173, 216, 230));
        panel.setBounds(-5, 0, 479, 585);
        contentPane.add(panel);
        panel.setLayout(null);

        Label label = new Label("Sign Up");
        label.setBounds(186, 10, 101, 38);
        panel.add(label);
        label.setBackground(new Color(173, 216, 230));
        label.setFont(new Font("Tahoma", Font.BOLD, 18));

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(23, 160, 101, 21);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(23, 223, 101, 29);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblPassword);

        JLabel lblRePassword = new JLabel("Confirm Password:");
        lblRePassword.setBounds(23, 280, 165, 29);
        lblRePassword.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblRePassword);

        JButton btnNewButton = new JButton("Sign in");
        btnNewButton.setBounds(337, 531, 108, 29);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login loginWindow = new Login();
                loginWindow.getFrame().setVisible(true);
                dispose(); 
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(btnNewButton);

        txtUsername = new JTextField();
        txtUsername.setBounds(220, 157, 225, 25);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtUsername);
        txtUsername.setColumns(10);

        txtPass = new JPasswordField();
        txtPass.setBounds(220, 224, 225, 25);
        txtPass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtPass);
        txtPass.setColumns(10);
        txtPass.setEchoChar('*');

        txtRePass = new JPasswordField();
        txtRePass.setBounds(220, 281, 225, 25);
        txtRePass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        panel.add(txtRePass);
        txtRePass.setColumns(10);
        txtRePass.setEchoChar('*');

        JButton btnSignUp = new JButton("SIGN UP");
        btnSignUp.setBounds(172, 462, 135, 38);
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPass.getPassword());
                String repeatPassword = new String(txtRePass.getPassword());
                String resetPassCode = new String(txtResetPassCode.getPassword());
                if (username.isEmpty() || password.isEmpty() || repeatPassword.isEmpty() || resetPassCode.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
                } else if (!password.equals(repeatPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords do not match.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
                } else if (User_Manager.isUserExists(username)) {
                    JOptionPane.showMessageDialog(null, "Username already exists.", "Sign Up Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    addUserToDatabase(username, password, resetPassCode);
                    JOptionPane.showMessageDialog(null, "Account created successfully!", "Sign Up", JOptionPane.INFORMATION_MESSAGE);
                }
                txtUsername.setText("");
                txtPass.setText("");
                txtRePass.setText("");
                txtResetPassCode.setText("");
            }
        });
        btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 18));
        panel.add(btnSignUp);

        Label label_1 = new Label("Already have an account?");
        label_1.setBounds(116, 531, 215, 29);
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        panel.add(label_1);

        JLabel lblResetPassCode = new JLabel("Reset Password Code:");
        lblResetPassCode.setBounds(23, 348, 185, 21);
        lblResetPassCode.setFont(new Font("Tahoma", Font.BOLD, 16));
        panel.add(lblResetPassCode);

        txtResetPassCode = new JPasswordField();
        txtResetPassCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtResetPassCode.setBounds(220, 346, 225, 23);
        panel.add(txtResetPassCode);
        txtResetPassCode.setEchoChar('*');

        setLocationRelativeTo(null);
    }

    private void addUserToDatabase(String username, String password, String resetPassCode) {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopn7", "root", "");

            String query = "INSERT INTO signup (Username, Password, Confirm_Password, Reset_Password_Code) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, password);
            statement.setString(4, resetPassCode);
    
            statement.executeUpdate();
      
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
