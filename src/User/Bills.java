package User;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Admin.Dashboard;

import java.awt.Font;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bills extends JFrame {

    private JPanel contentPane;
    private DefaultTableModel model;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Bills billsFrame = new Bills();
                    billsFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Bills() {
        setTitle("Hóa đơn");
        getContentPane().setBackground(new Color(0, 128, 192));
        getContentPane().setForeground(Color.WHITE);
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        Object[] columns = {"ID", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Ngày thuê", "Ngày trả dự kiến", "Phương thức thanh toán"};
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

        JButton btnRefresh = new JButton("Làm mới");
        btnRefresh.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRefresh.setBounds(10, 9, 115, 47);
        getContentPane().add(btnRefresh);
        btnRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                billsTableFromDatabase();
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

        setLocationRelativeTo(null);
        billsTableFromDatabase();
    }

    private void billsTableFromDatabase() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/oopn7", "root", "");
            String query = "SELECT * FROM rent";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            model.setRowCount(0);
            while (resultSet.next()) {
                model.addRow(new Object[]{
                        resultSet.getString("ID"),
                        resultSet.getString("Tên khách hàng"),
                        resultSet.getString("Số điện thoại"),
                        resultSet.getString("Địa chỉ"),
                        resultSet.getDate("Ngày thuê"),
                        resultSet.getDate("Ngày trả dự kiến"),
                        resultSet.getString("Phương thức thanh toán"),
                });
            }

            resultSet.close();
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void returnToDashboard() {
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        dispose();
    }
}
