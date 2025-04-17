/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author Lenovo
 */
public  class User {
    
    public String fullName;
    public String Email;
    public String Password;
    
    public User(String name ,String email , String password){
        this.Email = email;
        this.Password = password;
        this.fullName = name;
        
    }
      public static User create(String username, String email, String password) {
        return new User(username, email, password);
    }
      
       public static User create(String email,String password) {
        // ByDefoult full name of user
        String fullname = "defaultName";
        return new User(fullname, email, password);
    }
      
}
