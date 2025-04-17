
package View;

import Controller.UserService;
import java.awt.Dimension;

public class LoginAndSignUp {


    public static void main(String[] args) {

        Login LoginFrame = new Login();
        int width = 820;
        int height = 530;
        
    LoginFrame.setPreferredSize(new Dimension(width, height));
LoginFrame.setMinimumSize(new Dimension(width, height)); // الحد الأدنى
LoginFrame.setMaximumSize(new Dimension(width, height)); // الحد الأقصى (اختياري)

LoginFrame.pack();
LoginFrame.setLocationRelativeTo(null);
LoginFrame.setVisible(true);
    
//   UserService userService = new UserService();
//        userService.getUsers();
    }
    
}
