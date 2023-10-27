class Demo24 {
    public static void main(String[] args) throws Exception{
        String chars = "|/-\\|/-\\";
        int count = 0,width = 40;
        String percent;
        System.out.print("Loading ");
        for (int i=0;count < width;i++){
            percent = ""+ String.format("%.2f",((double)count/width)*100) +"%";
            System.out.printf("(%s)",chars.charAt(i));
            System.out.printf("[%s%s%s%s] %s%s","\033[42m"," ".repeat(count),"\033[0m"," ".repeat(width-count),percent,
                                "\b".repeat(width+6 + percent.length()));
            
            if (i == 7){
                i = 0;
                count++;
            }
            Thread.sleep(200);
            count++;

        }
        
        
        /*double percount = 0;
        for(boolean i = true;i;count++){
            percount = ((double)count/40) * 100;
            String percent = String.format("%.2f%%",percount);
            System.out.print("\b".repeat(42+percent.length()));
            System.out.print("[");
            System.out.print("=".repeat(count));
            System.out.printf("%s]%s"," ".repeat(40-count),percent);
            
            Thread.sleep(200);
            if (count == 40){
                System.out.println();
                break;
            }
            
        }*/
    }    
}
