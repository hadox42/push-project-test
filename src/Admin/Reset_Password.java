package Admin;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reset_Password extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset_Password frame = new Reset_Password();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Reset_Password() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 487, 566);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label label = new Label("Reset Password");
        label.setBounds(169, 36, 188, 38);
        panel.add(label);
        label.setBackground(new Color(173, 216, 230));
        label.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblUsername.setBounds(24, 142, 123, 27);
        panel.add(lblUsername);
        
        JLabel lblResetPassCode = new JLabel("Reset Password Code:");
        lblResetPassCode.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblResetPassCode.setBounds(24, 199, 202, 27);
        panel.add(lblResetPassCode);
        
        JLabel lblNewPass = new JLabel("New Password:");
        lblNewPass.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblNewPass.setBounds(24, 261, 144, 27);
        panel.add(lblNewPass);
        
        textField = new JTextField();
        textField.setBounds(252, 202, 225, 25);
        panel.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JTextField();
        textField_1.setBounds(252, 145, 225, 25);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        textField_2 = new JTextField();
        textField_2.setBounds(252, 264, 225, 25);
        panel.add(textField_2);
        textField_2.setColumns(10);
        
        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnConfirm.setBounds(67, 460, 113, 38);
        panel.add(btnConfirm);
        
        JButton btnReturn = new JButton("Return");
        btnReturn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnReturn.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnReturn.setBounds(303, 460, 113, 38);
        panel.add(btnReturn);
        
        JLabel lblConfirmNewPass = new JLabel("Confirm New Password:\r\n");
        lblConfirmNewPass.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblConfirmNewPass.setBounds(24, 315, 202, 27);
        panel.add(lblConfirmNewPass);
        
        textField_3 = new JTextField();
        textField_3.setBounds(252, 317, 225, 27);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        setLocationRelativeTo(null);
	}
}