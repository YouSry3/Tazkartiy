package Controller;

import Model.DatabaseConnection;
import Objects.User;
import View.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UserService {

    // ميثود جلب المستخدمين
    public void getUsers() {
        String query = "SELECT * FROM Users"; // تأكد من اسم الجدول في قاعدة البيانات.
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            // معالجة البيانات المسترجعة.
            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("username"));
                System.out.println("Email User: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ميثود تسجيل مستخدم جديد
    public static void registerUser(User newUser) {
        String query = "INSERT INTO Users (username, email, password) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newUser.fullName);
            stmt.setString(2, newUser.Email);
            stmt.setString(3, newUser.Password);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ User registered successfully.");
            }

        } catch (SQLException e) {
            System.out.println("❌ Error registering user: " + e.getMessage());
        }
    }

    // ميثود تسجيل الدخول
    public static boolean Login(String email, String password) {
        boolean isValidUser = false;
        String query = "SELECT * FROM Users WHERE email = ? AND password = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // استخدام القيم المرسلة عبر المعاملات
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FullNameAfterLogin(rs.getString("username"));
                    
                    System.out.println("✅ User found");
                    isValidUser = true;
                } else {
                    System.out.println("❌ User not found");
                }
            }
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        return isValidUser;
    }
    
    public static void FullNameAfterLogin(String fullname){
        
        Login login = new Login();
        login.WelcomeUSer(fullname);
        
    }
}
