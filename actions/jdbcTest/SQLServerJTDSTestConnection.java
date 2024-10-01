package jdbcTest;

import java.sql.*;

public class SQLServerJTDSTestConnection {
    public static Connection getMyConnection() throws SQLException, ClassNotFoundException {
        return SQLServerJTDSConnUtils.getSQLServerConnection();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("Get connection...");
        Connection conn = SQLServerJTDSTestConnection.getMyConnection();
        System.out.println("Opened connection: " + conn);
        String sqlParam = "SELECT *  FROM [Jasmine].[dbo].[CUSTOMER] WHERE CUST_ID BETWEEN ? AND ? AND POSTAL_CODE like ?";
        PreparedStatement preparedStatement = conn.prepareStatement(sqlParam);
        preparedStatement.setInt(1,3);
        preparedStatement.setInt(2,7);
        preparedStatement.setString(3, "02%");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int cust_id = resultSet.getInt("CUST_ID");
            String address = resultSet.getString(2);
            String city = resultSet.getString(3);
            System.out.println("-------------------------");
            System.out.println("CUST_ID = " + cust_id);
            System.out.println("ADDRESS" + address);
            System.out.println("CITY = " + city);
        }
        conn.close();
    }


//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println("Get connection...");
//        Connection conn = SQLServerJTDSTestConnection.getMyConnection();
//        System.out.println("Opened connection: " + conn);
//        Statement statement = conn.createStatement();
//        String sql = "SELECT *  FROM [Jasmine].[dbo].[CUSTOMER];";
//        String insertValue = "INSERT INTO [CUSTOMER] ([ADDRESS],[CITY],[CUST_TYPE_CD],[FED_ID],[POSTAL_CODE],[STATE])\n" +
//                "VALUES ('Tran Binh', 'Ha Noi', 'A', '04-1111111', '03079', 'MA');";
//
//        int rowCount = statement.executeUpdate(insertValue);
//        System.out.println("Row count = " + rowCount);
//        ResultSet  resultSet = statement.executeQuery(sql);
//        while (resultSet.next()){
//            int cust_id = resultSet.getInt("CUST_ID");
//            String address = resultSet.getString(2);
//            String city = resultSet.getString(3);
//            System.out.println("-------------------------");
//            System.out.println("CUST_ID = " + cust_id);
//            System.out.println("ADDRESS" + address);
//            System.out.println("CITY = " + city);
//        }
//        conn.close();
//    }

//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        System.out.println("Get connection... ");
//
//        // Lấy ra đối tượng Connection kết nối vào database.
//        Connection conn = SQLServerJTDSTestConnection.getMyConnection();
//
//        System.out.println("Opened connection: " + conn);
//
//        Statement statement = conn.createStatement();
//
//        String sql = "SELECT * FROM [jasmine].[dbo].[Product_Type];";
//
//        // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
//        ResultSet rs = statement.executeQuery(sql);
//
//        // Duyệt trên kết quả trả về
//        while (rs.next()) {
//            // Di chuyển con trỏ xuống bản ghi kế tiếp.
//            String empFirstName = rs.getString(1);
//            String empLastName = rs.getString("NAME");
//
//            System.out.println("--------------------");
//            System.out.println("Emp Firstname:" + empFirstName);
//            System.out.println("Emp Lastname:" + empLastName);
//        }
//        // Đóng kết nối
//        conn.close();
//        System.out.println("---------- Closed connection ----------");
//    }
}
