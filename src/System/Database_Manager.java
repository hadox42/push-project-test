package System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class Database_Manager extends Base_Manager {
    public static void fetchData(DefaultTableModel model) {
        Base_Manager baseManager = new Base_Manager();
        try (Connection conn = baseManager.getConnection()) {
            String sql = "SELECT * FROM thongtinxe";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        Object[] row = {
                            rs.getString("ID"),
                            rs.getString("Tên xe"),
                            rs.getString("Hãng xe"),
                            rs.getString("Loại xe"),
                            rs.getString("Sức chứa"),
                            rs.getString("Số lượng"),
                            rs.getString("Khu vực"),
                            rs.getString("Giá thuê/ngày"),
                            rs.getString("Trạng thái")
                        };
                        model.addRow(row);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static boolean isIDExists(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM thongtinxe WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, id);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt(1);
                        return count > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public static void insertData(String id, String name, String brand, String type, String csn,
                                         String quantity, String location, String price, String available) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO thongtinxe (ID, `Tên xe`, `Hãng xe`, `Loại xe`, `Sức chứa`, `Số lượng`, `Khu vực`, `Giá thuê/ngày`, `Trạng thái`) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, brand);
            statement.setString(4, type);
            statement.setString(5, csn);
            statement.setString(6, quantity);
            statement.setString(7, location);
            statement.setString(8, price);
            statement.setString(9, available);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here, such as showing an error message
        }
    }
    
    public static void deleteData(String id) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM thongtinxe WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, id);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void insertRentData(String id, String name, String sdt, String address, String dayRent, String dayReturn, String payment) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD)) {
            String query = "INSERT INTO Rent (ID, 'Tên khách hàng', 'Số điện thoại', 'Ngày thuê', 'Ngày trả dự kiến', 'Phương thức thanh toán', 'Địa chỉ') " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, sdt);
            statement.setString(4, address);
            statement.setString(5, dayRent);
            statement.setString(6, dayReturn);
            statement.setString(7, payment);
           
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
