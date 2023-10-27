import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHashing {
    public static void main(String[] args) {
        String[] passwd = {"admin123","wishva123","aruna123"};
        for (String password : passwd) {
            String s = DigestUtils.sha256Hex(password);
            System.out.printf("%s : ==>  %s\n",password,s);
        }
    }
}
