public class PalindromeNumberAlgo {
    public static void main(String[] args) {
        int x= -1;
        System.out.println(isPalindrome(x));
        

    }

    public static boolean isPalindrome(int x) {
        String rev="";
        String temp = String.valueOf(x);
        for (int i = temp.length()-1; i >=0 ; i--) {
            rev += temp.charAt(i);
        }
        if(temp.equals(rev)) return true;
        return false;
        
    }
}
