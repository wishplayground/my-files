public class Demo3 {
    public static void main(String[] args) {
        var input = "+12345";
        System.out.println(isDigits(input));
        System.out.println(isDigit2(input));
        
    }

    public static boolean isDigits(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i)) ) return false;
        }
        return true;
    }

    public static boolean isDigit2(String input){
        try{
            Integer.parseInt(input);
            return true;
        }catch(Exception e){
            return false;
        }
        
    }
}
