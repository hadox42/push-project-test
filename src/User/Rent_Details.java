package User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Admin.Dashboard;
import System.Database_Manager;
import System.Table_Manager;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Rent_Details extends JFrame {

    private JPanel contentPane;
    private DefaultTableModel model;
    private JTextField txtSearch;

    public static void main(String[] args) {
        Rent_Details rentFrame = new Rent_Details();
        rentFrame.setVisible(true);
    }

    public Rent_Details() {
        setTitle("Thông tin xe thuê");
        getContentPane().setBackground(new Color(0, 128, 192));
        getContentPane().setForeground(Color.WHITE);
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Object[] columns = {"ID", "Tên xe", "Hãng xe", "Loại xe", "Sức chứa", "Số lượng", "Khu vực", "Giá thuê/ngày", "Trạng thái"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        getContentPane().setLayout(null);

        JTable rentTable = new JTable();
        rentTable.setModel(model);
        rentTable.setBackground(Color.white);
        rentTable.setForeground(Color.black);
        rentTable.setSelectionBackground(Color.red);
        rentTable.setGridColor(Color.white);
        rentTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        rentTable.setRowHeight(30);
        rentTable.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(rentTable);
        pane.setBounds(0, 131, 1266, 552);
        getContentPane().add(pane);
        
        txtSearch = new JTextField();
        txtSearch.setForeground(new Color(192, 192, 192));
        txtSearch.setHorizontalAlignment(JTextField.LEFT);
        txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        txtSearch.setText("Nhập nội dung tìm kiếm");
        txtSearch.setBounds(51, 41, 465, 45);
        getContentPane().add(txtSearch);
        txtSearch.setColumns(10);

        txtSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().equals("Nhập nội dung tìm kiếm")) {
                    txtSearch.setText("");
                    txtSearch.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (txtSearch.getText().isEmpty()) {
                    txtSearch.setForeground(new Color(192, 192, 192));
                    txtSearch.setText("Nhập nội dung tìm kiếm");
                }
            }
        });
        
        JButton btnRefresh = new JButton("Làm mới");
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRefresh.setBounds(747, 9, 115, 47);
        getContentPane().add(btnRefresh);
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Table_Manager.refreshTable(model);
            }
        });

        JButton btnReturn = new JButton("Quay lại");
        btnReturn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                returnToDashboard();
            }
        });
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnReturn.setBounds(1141, 9, 115, 47);
        getContentPane().add(btnReturn);
        
        JButton btnDetails = new JButton("Chi tiết");
        btnDetails.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Your code to handle detail button click
            }
        });
        btnDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDetails.setBounds(815, 74, 115, 47);
        getContentPane().add(btnDetails);
        
        JButton btnRent = new JButton("Thuê xe");
        btnRent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Rent rentFrame = new Rent();
                
                int selectedRow = rentTable.getSelectedRow();
                String selectedID = "";
                String selectedStatus = "";
                if (selectedRow != -1) {
                    selectedID = rentTable.getValueAt(selectedRow, 0).toString();
                    selectedStatus = rentTable.getValueAt(selectedRow, 8).toString();
                } else {
                    JOptionPane.showMessageDialog(null, "Vui lòng chọn một hàng để thuê!", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (selectedStatus.equals("Hết")) {
                    JOptionPane.showMessageDialog(null, "Đã hết xe - Không thể thuê", "Thông báo", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                rentFrame.setID(selectedID);
                
                rentFrame.setVisible(true);
                dispose();
            }
        });
        
        btnRent.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRent.setBounds(893, 9, 115, 47);
        getContentPane().add(btnRent);

        setLocationRelativeTo(null);
        Database_Manager.fetchData(model);
    }

    private void returnToDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dispose();
        
        setLocationRelativeTo(null);
    }
}
