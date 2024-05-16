package User;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class Rent extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtSDT;
    private JTextField txtNames;
    private JTextField txtID;
    private JTextField txtDayReturn;
    private JTextField txtDayRent;
    private JTextField txtType;
    private JTextField txtName;
    private JTextField txtAddress;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Rent frame = new Rent();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setID(String id) {
        txtID.setText(id);
    }
    
    public Rent() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 971, 680);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelAdd = new JPanel();
        panelAdd.setForeground(new Color(0, 0, 0));
        panelAdd.setBackground(new Color(255, 255, 255));
        panelAdd.setBounds(0, 86, 966, 571);
        contentPane.add(panelAdd);
        panelAdd.setLayout(null);

        txtSDT = new JTextField();
        txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtSDT.setBounds(205, 153, 274, 33);
        panelAdd.add(txtSDT);
        txtSDT.setColumns(10);

        JLabel lblID = new JLabel("ID");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblID.setBounds(35, 21, 25, 25);
        panelAdd.add(lblID);

        JLabel lblSDT = new JLabel("Số điện thoại");
        lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblSDT.setBounds(35, 153, 142, 33);
        panelAdd.add(lblSDT);

        JLabel lblDayRent = new JLabel("Ngày thuê");
        lblDayRent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDayRent.setBounds(522, 82, 149, 25);
        panelAdd.add(lblDayRent);

        JLabel lblDayReturn = new JLabel("Ngày trả dự kiến");
        lblDayReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblDayReturn.setBounds(522, 157, 160, 25);
        panelAdd.add(lblDayReturn);

        JLabel lblPayment = new JLabel("Phương thức thanh toán");
        lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPayment.setBounds(35, 313, 242, 25);
        panelAdd.add(lblPayment);

        JLabel lblAddress = new JLabel("Địa chỉ");
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAddress.setBounds(35, 236, 82, 25);
        panelAdd.add(lblAddress);

        txtID = new JTextField();
        txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtID.setBounds(205, 17, 274, 33);
        panelAdd.add(txtID);
        txtID.setColumns(10);

        txtDayReturn = new JTextField();
        txtDayReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDayReturn.setBounds(696, 153, 225, 33);
        panelAdd.add(txtDayReturn);
        txtDayReturn.setColumns(10);

        txtDayRent = new JTextField();
        txtDayRent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtDayRent.setBounds(696, 78, 225, 33);
        panelAdd.add(txtDayRent);
        txtDayRent.setColumns(10);
        
        txtAddress = new JTextField();
        txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtAddress.setColumns(10);
        txtAddress.setBounds(205, 232, 274, 33);
        panelAdd.add(txtAddress);

        JComboBox<String> cmbPayment = new JComboBox<String>();
        cmbPayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cmbPayment.setBounds(35, 359, 160, 34);
        panelAdd.add(cmbPayment);
        cmbPayment.addItem("Tiền mặt");
        cmbPayment.addItem("Ví điện tử");
        cmbPayment.addItem("Credit card");
        cmbPayment.addItem("Visa");
        
        JButton btnConfirm = new JButton("Xác nhận");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = txtID.getText();
                String name = txtNames.getText();
                String sdt = txtSDT.getText();
                String address = txtAddress.getText();
                String dayRent = txtDayRent.getText();
                String dayReturn = txtDayReturn.getText();
                String paymentMethod = (String) cmbPayment.getSelectedItem();
                
                // Insert data into the database
                insertRentData(id, name, sdt, address, dayRent, dayReturn, paymentMethod);

                // Reset text fields
                txtID.setText("");
                txtNames.setText("");
                txtSDT.setText("");
                txtAddress.setText("");
                txtDayRent.setText("");
                txtDayReturn.setText("");
                cmbPayment.setSelectedIndex(-1);
            }
        });
        
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnConfirm.setBounds(779, 453, 128, 53);
        panelAdd.add(btnConfirm);
        
        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent e) {
                 // Clear all text fields
                 txtID.setText("");
                 txtNames.setText("");
                 txtSDT.setText("");
                 txtAddress.setText("");
                 txtDayRent.setText("");
                 txtDayReturn.setText("");
                 // Reset combo boxes to default state
                 cmbPayment.setSelectedIndex(-1);
             }
         });

        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnReset.setBounds(792, 353, 115, 46);
        panelAdd.add(btnReset);
        
        JLabel lblName = new JLabel("Tên khách hàng");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(35, 82, 142, 25);
        panelAdd.add(lblName);
        
        txtNames = new JTextField();
        txtNames.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtNames.setColumns(10);
        txtNames.setBounds(205, 78, 274, 33);
        panelAdd.add(txtNames);
               
        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 128, 192));
        panel.setBounds(0, 0, 957, 89);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnReturn = new JButton("Thoát");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
       
        btnReturn.setBounds(839, 20, 94, 46);
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        panel.add(btnReturn);
        
        setLocationRelativeTo(null);
    }
    private void insertRentData(String id, String name, String sdt, String address, String dayRent, String dayReturn,
            String paymentMethod) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // Establish database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopn7", "root", "");

            // Create SQL query to insert data into the rent table
            String query = "INSERT INTO rent (ID, `Tên khách hàng`, `Số điện thoại`, `Địa chỉ`, `Ngày thuê`, `Ngày trả dự kiến`, `Phương thức thanh toán`) VALUES (?, ?, ?, ?, ?, ?, ?)";
            // Prepare the statement
            statement = connection.prepareStatement(query);

            // Set values for parameters
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, sdt);
            statement.setString(4, address);
            statement.setString(5, dayRent);
            statement.setString(6, dayReturn);
            statement.setString(7, paymentMethod);

            // Execute the statement to insert data
            statement.executeUpdate();

            // Show success message
            JOptionPane.showMessageDialog(null, "Data inserted successfully!", "Success",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            // Show error message
            JOptionPane.showMessageDialog(null, "Error inserting data: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the statement and connection
            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
