package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login {

    private JFrame frame;
    private JPasswordField txtPassword;
    private JTextField txtUsername;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login window = new Login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public JFrame getFrame() {
        return frame;
    }

    public Login() {
        initialize();
        frame.setLocationRelativeTo(null);
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 950, 422);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(521, 0, 425, 393);
        frame.getContentPane().add(panel_2);
        panel_2.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(20, 138, 79, 17);
        panel_2.add(lblUsername);
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 181, 75, 17);
        panel_2.add(lblPassword);
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(94, 278, 85, 21);
        panel_2.add(btnLogin);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String password = new String(txtPassword.getPassword());
                String username = txtUsername.getText();

                if (isValidUser(username, password)) {
                    txtPassword.setText(null);
                    txtUsername.setText(null);

                    Dashboard mainInterface = new Dashboard();
                    mainInterface.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login Details", "Login Error", JOptionPane.ERROR_MESSAGE);
                    txtPassword.setText(null);
                    txtUsername.setText(null);
                }
            }
        });
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(250, 278, 85, 21);
        panel_2.add(btnReset);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtUsername.setText(null);
                txtPassword.setText(null);
            }
        });
        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(318, 10, 79, 25);
        panel_2.add(btnExit);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame = new JFrame("Exit");
                if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to exit", "Login System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));

        txtPassword = new JPasswordField();
        txtPassword.setBounds(123, 183, 212, 19);
        panel_2.add(txtPassword);
        txtPassword.setFont(new Font("Calibri", Font.PLAIN, 14));

        txtUsername = new JTextField();
        txtUsername.setBounds(123, 140, 212, 20);
        panel_2.add(txtUsername);
        txtUsername.setFont(new Font("Calibri", Font.PLAIN, 14));
        txtUsername.setColumns(10);

        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sign_Up signUpWindow = new Sign_Up();
                signUpWindow.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnSignUp.setBounds(250, 333, 95, 21);
        panel_2.add(btnSignUp);

        JLabel lblLoginSystem = new JLabel("Login System");
        lblLoginSystem.setBounds(123, 47, 149, 35);
        panel_2.add(lblLoginSystem);
        lblLoginSystem.setForeground(new Color(0, 0, 0));
        lblLoginSystem.setFont(new Font("Tahoma", Font.BOLD, 21));

        Checkbox checkbox = new Checkbox("Remember Password");
        checkbox.setFont(new Font("Tahoma", Font.PLAIN, 12));
        checkbox.setBounds(20, 220, 159, 21);
        panel_2.add(checkbox);

        Label label = new Label("Don't have an account?");
        label.setFont(new Font("Tahoma", Font.PLAIN, 12));
        label.setBounds(71, 333, 159, 21);
        panel_2.add(label);

        JButton btnForgetPass = new JButton("Forget Password?");
        btnForgetPass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Reset_Password resetPasswordWindow = new Reset_Password();
                resetPasswordWindow.setVisible(true);
                frame.setVisible(false);
            }
        });
        btnForgetPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnForgetPass.setBounds(248, 220, 149, 21);
        panel_2.add(btnForgetPass);

        JLabel lblimg = new JLabel("");
        lblimg.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblimg.setBackground(new Color(0, 0, 0));
        ImageIcon img = new ImageIcon(this.getClass().getResource("/CRSv1.png"));
        lblimg.setIcon(img);
        lblimg.setBounds(-103, 0, 632, 393);
        frame.getContentPane().add(lblimg);

        initializeDatabase();
    }

    private void initializeDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopn7", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidUser(String username, String password) {
        try {
            String query = "SELECT * FROM signup WHERE Username = ? AND Password = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
