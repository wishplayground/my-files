public class test {
    public static void main(String[] args) {
        String s = "ravi";
        Class<? extends String> c = s.getClass();
        System.out.println(c);
    }
}
