package Admin;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import System.Database_Manager;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Add extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtBrand;
    private JTextField txtID;
    private JTextField txtQuantity;
    private JTextField txtCSN;
    private JTextField txtPrice;
    private JTextField txtLocation;
    private JTextField txtType;
    private JTextField txtName;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Add frame = new Add();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Add() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 971, 609);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panelAdd = new JPanel();
        panelAdd.setForeground(new Color(0, 0, 0));
        panelAdd.setBackground(new Color(255, 255, 255));
        panelAdd.setBounds(0, 86, 966, 506);
        contentPane.add(panelAdd);
        panelAdd.setLayout(null);

        txtBrand = new JTextField();
        txtBrand.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtBrand.setBounds(99, 228, 169, 33);
        panelAdd.add(txtBrand);
        txtBrand.setColumns(10);

        JLabel lblID = new JLabel("ID");
        lblID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblID.setBounds(10, 82, 25, 25);
        panelAdd.add(lblID);

        JLabel lblBrand = new JLabel("Hãng xe");
        lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblBrand.setBounds(10, 232, 73, 25);
        panelAdd.add(lblBrand);

        JLabel lblCSN = new JLabel("Sức chứa");
        lblCSN.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblCSN.setBounds(314, 157, 82, 25);
        panelAdd.add(lblCSN);

        JLabel lblQuantity = new JLabel("Số lượng");
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblQuantity.setBounds(317, 232, 79, 25);
        panelAdd.add(lblQuantity);

        JLabel lblPrice = new JLabel("Giá thuê/ngày");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPrice.setBounds(632, 157, 143, 25);
        panelAdd.add(lblPrice);

        JLabel lblLocation = new JLabel("Khu vực");
        lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblLocation.setBounds(632, 82, 72, 25);
        panelAdd.add(lblLocation);

        JLabel lblAvailable = new JLabel("Trạng thái");
        lblAvailable.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblAvailable.setBounds(637, 236, 91, 25);
        panelAdd.add(lblAvailable);

        JLabel lblType = new JLabel("Loại xe");
        lblType.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblType.setBounds(314, 82, 82, 25);
        panelAdd.add(lblType);

        JComboBox<String> cmbAvailable = new JComboBox<>();
        cmbAvailable.setFont(new Font("Tahoma", Font.PLAIN, 20));
        cmbAvailable.setBounds(768, 238, 161, 34);
        panelAdd.add(cmbAvailable);

        txtID = new JTextField();
        txtID.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtID.setBounds(99, 78, 169, 33);
        panelAdd.add(txtID);
        txtID.setColumns(10);

        txtQuantity = new JTextField();
        txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtQuantity.setBounds(414, 228, 176, 33);
        panelAdd.add(txtQuantity);
        txtQuantity.setColumns(10);

        txtCSN = new JTextField();
        txtCSN.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtCSN.setBounds(414, 153, 176, 33);
        panelAdd.add(txtCSN);
        txtCSN.setColumns(10);

        txtPrice = new JTextField();
        txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtPrice.setBounds(767, 153, 162, 33);
        panelAdd.add(txtPrice);
        txtPrice.setColumns(10);

        txtLocation = new JTextField();
        txtLocation.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtLocation.setBounds(768, 79, 161, 32);
        panelAdd.add(txtLocation);
        txtLocation.setColumns(10);

        JButton btnConfirm = new JButton("Confirm");
        btnConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lấy thông tin từ các trường nhập liệu
                String id = txtID.getText();
                String name = txtName.getText();
                String brand = txtBrand.getText();
                String type = txtType.getText();
                String csn = txtCSN.getText();
                String quantity = txtQuantity.getText();
                String location = txtLocation.getText();
                String price = txtPrice.getText();
                String available = cmbAvailable.getSelectedItem().toString();
                
                if (Database_Manager.isIDExists(id)) {
                    JOptionPane.showMessageDialog(null, "ID đã tồn tại. Vui lòng nhập ID khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } else {

                    insertDataIntoDatabase(id, name, brand, type, csn, quantity, location, price, available);

                    JOptionPane.showMessageDialog(null, "Thêm dữ liệu thành công.");
                }
            }
        });
        btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnConfirm.setBounds(99, 365, 121, 46);
        panelAdd.add(btnConfirm);

        JButton btnReset = new JButton("Reset");
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all text fields
                txtID.setText("");
                txtName.setText("");
                txtBrand.setText("");
                txtType.setText("");
                txtCSN.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");
                txtLocation.setText("");
                cmbAvailable.setSelectedIndex(-1);
            }
        });

        btnReset.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnReset.setBounds(414, 365, 91, 46);
        panelAdd.add(btnReset);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnExit.setBounds(768, 365, 91, 46);
        panelAdd.add(btnExit);
        
        txtType = new JTextField();
        txtType.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtType.setBounds(414, 82, 169, 33);
        panelAdd.add(txtType);
        txtType.setColumns(10);
        
        JLabel lblName = new JLabel("Tên xe");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(9, 157, 74, 25);
        panelAdd.add(lblName);
        
        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        txtName.setColumns(10);
        txtName.setBounds(99, 157, 169, 33);
        panelAdd.add(txtName);

        JPanel panelTitle = new JPanel();
        panelTitle.setBackground(new Color(0, 128, 192));
        panelTitle.setBounds(0, 0, 966, 86);
        contentPane.add(panelTitle);
        panelTitle.setLayout(null);

        cmbAvailable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbAvailable.removeAllItems();
                cmbAvailable.addItem("Còn");
                cmbAvailable.addItem("Hết");
            }
        });

        setLocationRelativeTo(null);
    }

    private void insertDataIntoDatabase(String id, String name, String brand, String type, String csn,
                                         String quantity, String location, String price, String available) {
        Database_Manager.insertData(id, name, brand, type, csn, quantity, location, price, available);
    }
}
