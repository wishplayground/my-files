public class DEmo2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("dep");
        sb.append("welcome");
        //below canbe done because methods are chained
        StringBuilder result = sb.append("Hello").append(" DEP").append(" Welcome").append(" to Programme");
        System.out.println(result.toString());
    }
}
