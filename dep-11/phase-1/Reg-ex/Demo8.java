import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo8 {
    public static void main(String[] args) {
        String text=  "NIC \n" + "871234567v \n" + "881234567v \n" + "871274567v \n" + "871934567v \n" + "873234567v \n" + "871234527v List";

        Pattern pattern = Pattern.compile("\\b\\d{9}[Vv]\\b");
        Matcher matcher = pattern.matcher(text);

        matcher.find();
        System.out.println(text.substring(matcher.start(), matcher.end()));

        matcher.find();
        System.out.println(text.substring(matcher.start(), matcher.end()));

        matcher.find();
        System.out.println(text.substring(matcher.start(), matcher.end()));

        matcher.find();
        System.out.println(text.substring(matcher.start(), matcher.end()));

        matcher.reset();
        matcher.find();
        System.out.println(text.substring(matcher.start(), matcher.end()));
    }
}
