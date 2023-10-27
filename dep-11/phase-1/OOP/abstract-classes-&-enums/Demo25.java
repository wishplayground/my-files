import java.time.LocalTime;

class Demo25{
    public static void main(String[] args) {
        User adminUser =new AdminUser("Wishva", "ijse_123456");
        User adminUser2 =new AdminUser("Gihan", "ijse_789456");
        User guestUser =new GuestUser("Chirantha", "ijse_147258");

        adminUser.login();
        adminUser2.login();
        guestUser.login();


    }
}



abstract class User{
    String userName;
    String passWord;
    String role;
    boolean isLooged = false;

    public abstract void login(); //only idea exist
    public abstract void login(int num);

    // public abstract void print();

    /* public void login(){
        System.out.printf("%s logged in \n",userName);
        isLooged = true;
    } */
    public void logout(){
        if(isLooged) System.out.printf("%s logged out \n",userName);
        else System.out.println("User hasn't logged in yet!");
    }

    public void printUserDetails(){
        System.out.printf("Username = %s   password = %s   role = %s\n",userName,passWord,role);
    }

}

class AdminUser extends User{
    private String[] passwords = {"ijse_123456", "ijse_789456", "ijse_147258"};
    public AdminUser(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.role =  "Role_Admin";
    }

    @Override
    public void login(){

        for (String pw : passwords) {
            if(pw.startsWith("ijse_")){
                System.out.printf("Admin user: %s logged in at: %s\n",userName,LocalTime.now());
            }
        }
        System.out.println("Invalid login Credentials");
        
    }

    public void login(int num){

        for (String pw : passwords) {
            if(pw.startsWith("ijse_")){
                System.out.printf("Admin user: %s logged in at: %s\n",userName,LocalTime.now());
            }
        }
        System.out.println("Invalid login Credentials");
        
    }

}

class GuestUser extends User{

    private static final String passwordGuest = "guest-1234";
    public GuestUser(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.role =  "Role_Guest";
    }

    @Override
    public void login(){
        if(passWord.equals(passwordGuest)){
            System.out.printf("Guest user: %s has logged in at: %s\n",userName,LocalTime.now());
        }
    }
}