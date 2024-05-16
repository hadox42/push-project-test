package Admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import System.Database_Manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Car_Info extends JFrame {
    private DefaultTableModel model;
    private JTable carInfoTable;

    public static void main(String[] args) {
        Car_Info carInfo = new Car_Info();
        carInfo.setVisible(true);
    }

    public Car_Info() {
        setTitle("Thông tin xe");
        getContentPane().setBackground(new Color(0, 128, 192));
        getContentPane().setForeground(Color.WHITE);
        setBounds(100, 100, 760, 604);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        model = new DefaultTableModel();
        Object[] columns = {"ID", "Tên xe", "Hãng xe", "Loại xe", "Sức chứa", "Số lượng", "Khu vực", "Giá thuê/ngày", "Trạng thái"};
        model.setColumnIdentifiers(columns);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBorder(null);
        setContentPane(contentPane);

        carInfoTable = new JTable();
        carInfoTable.setModel(model);
        carInfoTable.setBackground(Color.white);
        carInfoTable.setForeground(Color.black);
        carInfoTable.setSelectionBackground(Color.red);
        carInfoTable.setGridColor(Color.white);
        carInfoTable.setFont(new Font("Tahoma", Font.PLAIN, 17));
        carInfoTable.setRowHeight(30);
        carInfoTable.setAutoCreateRowSorter(true);

        JScrollPane pane = new JScrollPane(carInfoTable);
        pane.setBounds(0, 131, 746, 436);
        contentPane.add(pane);

        JButton btnAdd = new JButton("Thêm");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Add addFrame = new Add();
                addFrame.setVisible(true);
            }
        });
        btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnAdd.setBounds(10, 19, 83, 44);
        contentPane.add(btnAdd);

        JButton btnDelete = new JButton("Xóa");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnDelete.setBounds(10, 79, 83, 38);
        contentPane.add(btnDelete);

        JButton btnExit = new JButton("Thoát");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnExit.setBounds(653, 25, 83, 33);
        contentPane.add(btnExit);
        
        JButton btnUpdate = new JButton("Cập nhật");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                refreshTableData();
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnUpdate.setBounds(135, 45, 117, 44);
        contentPane.add(btnUpdate);
        
        Database_Manager.fetchData(model);
    }

    private void refreshTableData() {
        model.setRowCount(0);
        Database_Manager.fetchData(model);
    }

    private void deleteSelectedRow() {
        int[] selectedRows = carInfoTable.getSelectedRows();
        if (selectedRows.length > 0) {
            int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa dòng này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                for (int i = selectedRows.length - 1; i >= 0; i--) {
                    int selectedRowIndex = carInfoTable.convertRowIndexToModel(selectedRows[i]);
                    String id = model.getValueAt(selectedRowIndex, 0).toString();
                    model.removeRow(selectedRowIndex);
                    Database_Manager.deleteData(id); //
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chọn ít nhất một dòng để xóa.");
        }
    }
}
