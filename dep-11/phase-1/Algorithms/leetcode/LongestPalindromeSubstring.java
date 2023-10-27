import java.util.ArrayList;
import java.util.Arrays;

class LongestPalindromeSubstring {
    public static void main(String[] args) {
        String s = "vvgogaewginhopuxzwyryobjjpieyhwfopiowxmyylvcgsnhfcnogpqpukzmnpewavoutbloyrrhatimmxfqmcwgfebuoqbbgvubbkjfvxivjfijlpvtsnhagzfptahhyojwzamayoiegkenycnkxzkambimhdykdcxyyfjnvztzypmfczdhhnkmfuvgkhzbwmjznykkagqdrueohgcmeidjqsvfugcioeduohprjtfdmtzosnhoiganffarokxjifzzxhixdzycwfheqqegduzwtiacmdhqfmxhazcxsqyrvrihfqzjxvawdeandnwgjlquvzadruiqmcsgibglhicsvzqknztqpkiihdoisxipkourentfvrltieihiktgzswtgcmmlfrjifqinhrbplbsgswqlbjkyxjwoshsvxlhlpgzwbmxzwaemtowcxwourjwmmwjruowxcwotmeawzxmbwzgplhlxvshsowjxykjblqwsgsblpbrhniqfijrflmmcgtwszgtkihieitlrvftneruokpixsiodhiikpqtznkqzvscihlgbigscmqiurdazvuqljgwndnaedwavxjzqfhirvryqsxczahxmfqhdmcaitwzudgeqqehfwcyzdxihxzzfijxkoraffnagiohnsoztmdftjrphoudeoicgufvsqjdiemcghoeurdqgakkynzjmwbzhkgvufmknhhdzcfmpyztzvnjfyyxcdkydhmibmakzxkncynekgeioyamazwjoyhhatpfzgahnstvpljifjvixvfjkbbuvgbbqoubefgwcmqfxmmitahrryolbtuovawepnmzkupqpgoncfhnsgcvlyymxwoipofwhyeipjjboyrywzxupohnigweagogvv";
        System.out.println(longestPalindrome(s));
    }


    //Time complexity O(n^3)
    /* public static String longestPalindrome(String s) {
        String out="";
        int beginIndex = 0;
        if(s.length() ==1) return s;
        while(beginIndex < s.length()-1){
            for (int i = beginIndex + 1; i <= s.length(); i++) {
                String temp = ""; 
                for (int j = s.substring(beginIndex, i).length()-1; j >= 0; j--) {
                    temp += s.substring(beginIndex, i).charAt(j);
                }
                if(temp.equals(s.substring(beginIndex, i))){
                    if(temp.length()> out.length()) out= temp;
                }
            }
            beginIndex++;
        }
        return out;
    } */
    /* public static String longestPalindrome(String s) {
        ArrayList<String> palindrome = new ArrayList<>();
        if(s.length() ==1) return s;
        //two length palindromes
        if(s.length()>2){
            for (int i = 0; i < s.length()-1; i++) {
                if(s.charAt(i) ==s.charAt(i+1)) palindrome.add(""+s.charAt(i) +s.charAt(i+1));
            }
        }else{
            if(s.charAt(0) ==s.charAt(1)) palindrome.add(""+s.charAt(0) +s.charAt(1));
            else return "" + s.charAt(0);
        }
        //three or more length palindrome
        int beginIndex = 0;
        while(beginIndex < s.length()){
            for (int i = beginIndex + 3; i <= s.length(); i++) {
                StringBuffer sbf = new StringBuffer(s.substring(beginIndex, i));
                if(sbf.toString().equals(sbf.reverse().toString())  ) palindrome.add(sbf.reverse().toString());
            }
            beginIndex++;
        }
        if(palindrome.size() ==0) palindrome.add("" + s.charAt(0));
        String max = palindrome.get(0);
        for (String string : palindrome) {
            if(string.length()> max.length()) max = string;
        }
        return max;
    } */

    public static  String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) {
            return s;
        }
    
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
    
        // All substrings of length 1 are palindromes.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
    
        // Check for palindromes of length 2.
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
    
        // Check for palindromes of length 3 or more.
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
