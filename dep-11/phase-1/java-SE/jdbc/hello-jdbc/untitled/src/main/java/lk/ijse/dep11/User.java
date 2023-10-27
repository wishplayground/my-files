package lk.ijse.dep11;

public class User {
    private static User instance;
    private User(){
    }
    public static User getInstance(){
        if(instance == null){
            instance = new User();
        }
        return instance;
    }
}
