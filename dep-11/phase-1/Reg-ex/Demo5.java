import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    public static void main(String[] args) {
        String text = "My contact : 077-5641236\nHer Contact : 076-6572234\nHis Contact : 075-1234567. Thats all";

        Pattern regex = Pattern.compile("\\b0\\d{2}-\\d{7}\\b");
        Matcher matcher1 = regex.matcher(text);
        //boolean found = matcher.find();
        /* if(found){
            for (int i = 0; i < args.length; i++) {
                
            }
        } */
        while(matcher1.find()){
            //System.out.println(matcher.find());
            System.out.println(text.substring(matcher1.start(), matcher1.end()));
        }
    }
}
