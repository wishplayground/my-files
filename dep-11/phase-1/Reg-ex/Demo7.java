import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo7 {
    public static void main(String[] args) {
        
        String endPoint1 = "https://photoslibrary.googleapis.com:443/v1/albums/10";
        String endPoint2 = "http://people.googleapis.com:80/v2/me/connnections";
        
       /*  Pattern protocol = Pattern.compile("http[s]?");
        Pattern host = Pattern.compile("(//[a-z0-9]{2,[.])*[.]com");
        Pattern port = Pattern.compile(":\\d{1,5}"); */
        Pattern compile = Pattern.compile("(?<protocol>http[s]?)://(?<host>[a-z]+[.]googleapis.com):(?<port>\\d{1,5})/v(?<version>\\d+)/(?<path>.+)");

        Matcher matcher1 = compile.matcher(endPoint1);

        matcher1.find();//needs to be add
        System.out.println("Protocol " + matcher1.group(1));
        System.out.println("Host " + matcher1.group(2));
        System.out.println("Port " + matcher1.group(3));
        System.out.println("Version " + matcher1.group(4));
        System.out.println("Path " + matcher1.group(5));

        System.out.println("Protocol= " + matcher1.group("protocol"));
        System.out.println("Host= " + matcher1.group("host"));
        System.out.println("Port= " + matcher1.group("port"));
        System.out.println("Version= " + matcher1.group("version"));
        System.out.println("Path= " + matcher1.group("path"));

        Matcher matcher2 = compile.matcher(endPoint2);
        matcher2.find();
        System.out.println("Protocol= " + matcher2.group("protocol"));
        System.out.println("Host= " + matcher2.group("host"));
        System.out.println("Port= " + matcher2.group("port"));
        System.out.println("Version= " + matcher2.group("version"));
        System.out.println("Path= " + matcher2.group("path"));


    }
}
