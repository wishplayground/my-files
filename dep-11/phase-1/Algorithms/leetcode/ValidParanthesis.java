public class ValidParanthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()[]{}";
        System.out.println(solution.isValid(s));
    }


}

class Solution {
    public boolean isValid(String s) {
        char[] para = s.toCharArray();
        boolean out = false;
        if(para.length==1 || para.length == 0 || para.length%2 !=0) return false;
        
        if(!(String.format(para[0] + "" + para[1]).equals("()") || String.format(para[0] + "" + para[1]).equals("[]") || String.format(para[0] + "" + para[1]).equals("{}"))){
            int end = para.length-1;
            for (int start = 0; start < para.length/2; start++) {
                String brack = String.format(para[start] + "" + para[end]);
                if((brack.equals("()")|| brack.equals("[]")|| brack.equals("{}"))) {
                    out =  true;
                }else return false;
                end--;
            }
            return out;
        }else {
            for (int start = 0; start < para.length-1; start++) {
                String brack2 = String.format(para[start] + "" + para[start+1]);
                if((brack2.equals("()")|| brack2.equals("[]")|| brack2.equals("{}"))) {
                    out =  true;
                    start++;
                }else return false;
            }
            return out;
        }
    }
}
