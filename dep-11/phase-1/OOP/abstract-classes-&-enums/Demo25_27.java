import java.time.LocalTime;

class Demo25_27{
    public static void main(String[] args) {
        User1 adminUser =new AdminUser1("Wishva", "ijse_123456");
        User1 adminUser2 =new AdminUser1("Gihan", "ijse_789456");
        User1 guestUser =new GuestUser1("Chirantha", "ijse_147258");

        adminUser.login();
        adminUser2.login();
        guestUser.login();


    }
}

enum UserRole{
    ADMIN,GUEST;
}


abstract class User1{
    String userName;
    String passWord;
    UserRole role;
    boolean isLooged = false;

    public abstract void login(); //only idea exist
    //public abstract void login(int num);

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

class AdminUser1 extends User1{
    private String[] passwords = {"ijse_123456", "ijse_789456", "ijse_147258"};
    public AdminUser1(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.role =  UserRole.ADMIN;
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

class GuestUser1 extends User1{

    private static final String passwordGuest = "guest-1234";
    public GuestUser1(String username, String password){
        this.userName = username;
        this.passWord = password;
        this.role =  UserRole.GUEST;
    }

    @Override
    public void login(){
        if(passWord.equals(passwordGuest)){
            System.out.printf("Guest user: %s has logged in at: %s\n",userName,LocalTime.now());
        }
    }
}