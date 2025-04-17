
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    
    // Step 1: تعريف متغير ثابت ليحتفظ بالاتصال الوحيد.
    private static Connection connection = null;
    
    // Step 2: تعريف معلومات الاتصال بقاعدة البيانات.
    private static final String URL = "jdbc:mysql://localhost:3306/Tazkartiy"; // استبدل Tazkartiy باسم قاعدة البيانات الخاصة بك.
    private static final String USER = "root";  // اسم المستخدم لقاعدة البيانات.
    private static final String PASSWORD = "";  // كلمة المرور لقاعدة البيانات.

    // Step 3: إنشاء كود Singleton: Constructor private لضمان عدم إنشاء نسخ متعددة من الكلاس.
    private DatabaseConnection() {
        // Prevent instantiation
    }

    // Step 4: ميثود للحصول على الاتصال بالقاعدة (إذا كان الاتصال مش موجود، هيتم إنشاؤه).
    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            try {
                // محاولة الاتصال بقاعدة البيانات باستخدام JDBC.
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Connection established.");
            } catch (SQLException e) {
                System.out.println("Error while connecting to the database: " + e.getMessage());
                throw e; // في حالة حدوث خطأ، يتم رمي الاستثناء مرة أخرى.
            }
        }
        return connection;
    }

    // Step 5: إضافة طريقة لإغلاق الاتصال بالقاعدة عند الانتهاء.
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
}
