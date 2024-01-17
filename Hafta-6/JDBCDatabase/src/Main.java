import java.sql.*;

public class Main {
    public static final String DB_URL = "jdbc:mysql://localhost/university";
    public static final String DB_USERNAME = "root";
    public static final String DB_PASSWORD = "mysql";
    public static void main(String[] args) {
        Connection connection = null;

         String preparedSql = "INSERT INTO employee (employee_name, employee_position, employee_salary) VALUES (?, ?, ?)";
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD   );      // veritabanına bağlan
            PreparedStatement prSt = connection.prepareStatement(preparedSql);
            prSt.setString(1, "Olivia Parker");
            prSt.setString(2, "Software Developer");
            prSt.setInt(3, 5000);
            prSt.executeUpdate();
            System.out.println("Kayıt eklendi.");

            prSt.setString(1, "Emma Turner");
            prSt.setString(2, "Software Developer");
            prSt.setInt(3, 5000);
            prSt.executeUpdate();
            System.out.println("Kayıt eklendi.");

            prSt.setString(1, "Noah Martinez");
            prSt.setString(2, "Business Analyst");
            prSt.setInt(3, 45000);
            prSt.executeUpdate();
            System.out.println("Kayıt eklendi.");

            preparedSql = "UPDATE employee SET employee_salary = ? WHERE employee_id = ?";
            prSt = connection.prepareStatement(preparedSql);
            prSt.setInt(1, 10000);
            prSt.setInt(2, 7);
            prSt.executeUpdate();
            System.out.println("Kayıt güncellendi.");


            Statement st = connection.createStatement();        // sorgu çalıştırmak için bir Statement nesnesi oluştur
            ResultSet data = st.executeQuery("SELECT * FROM employee");     // sorguyu çalıştır ve sonuçları data değişkenine ata
            System.out.println("===================== EMPLOYEES ======================");
            System.out.printf("%-5s %-20s %-20s %-10s%n\n", "ID", "Name", "Position", "Salary");
            while (data.next()) {               // data değişkenindeki sonuçları tek tek döndür
                System.out.printf("%-5s %-20s %-20s %-10s%n\n",
                        data.getInt("employee_id"),
                        data.getString("employee_name"),
                        data.getString("employee_position"),
                        data.getInt("employee_salary"));
                System.out.println("=========================================================");
            }
            connection.close();     // bağlantıyı kapat
            prSt.close();
            st.close();

        } catch (SQLException e) {
            System.out.println("Veritabanına bağlanırken bir hata oluştu: " + e.getMessage());
        }
    }
}