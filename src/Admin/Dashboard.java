package Admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import User.Bills;
import User.Rent_Details;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JTree;

public class Dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final Panel panel = new Panel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 237, 683);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCarInfo = new JButton("Thông tin xe");
		btnCarInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 Car_Info carInfo = new Car_Info();
	             carInfo.setVisible(true);
	      
			}
		});
		btnCarInfo.setBounds(21, 164, 186, 57);
		panel.add(btnCarInfo);
		btnCarInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		JButton btnRent = new JButton("Thuê xe");
		btnRent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Rent_Details rentWindow = new Rent_Details();
                rentWindow.setVisible(true);
            }
        });
		btnRent.setBounds(21, 246, 186, 57);
		panel.add(btnRent);
		btnRent.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JButton btnDriverInfo = new JButton("Thông tin tài xế");
		btnDriverInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDriverInfo.setBounds(21, 321, 186, 57);
		panel.add(btnDriverInfo);
		btnDriverInfo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(-10, 10, 243, 144);
		panel.add(lblIcon);
		lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIcon.setBackground(new Color(0, 0, 0));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/CarIcon.png"));
		lblIcon.setIcon(icon);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(34, 628, 173, 31);
		panel.add(btnLogout);
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        Login login = new Login();
		        login.getFrame().setVisible(true);
		        dispose();
		    }
		});
	        btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnLogout.setBounds(34, 628, 173, 31);
	        panel.add(btnLogout);
	        
	        JButton btnBill = new JButton("Hóa đơn");
	        btnBill.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Bills billsWindow = new Bills();
	                billsWindow.setVisible(true);
	            }
	        });

	        btnBill.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        btnBill.setBounds(21, 403, 186, 57);
	        panel.add(btnBill);
		
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(237, 0, 1019, 683);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnProfile = new JButton("Profile");
		btnProfile.setBounds(922, 10, 87, 31);
		panel_1.add(btnProfile);
		btnProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(-404, -11, 1961, 192);
		panel_1.add(lblBanner);
		lblBanner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBanner.setBackground(new Color(0, 0, 0));
		ImageIcon banner = new ImageIcon(this.getClass().getResource("/Banner.png"));
		lblBanner.setIcon(banner);
		
		JLabel lblBlack = new JLabel("");
		lblBlack.setBounds(0, 180, 1028, 493);
		panel_1.add(lblBlack);
		ImageIcon black = new ImageIcon(this.getClass().getResource("/Black.png"));
		lblBlack.setIcon(black);
		
		setLocationRelativeTo(null);
	}
}