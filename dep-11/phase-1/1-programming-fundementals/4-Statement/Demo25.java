import java.util.Scanner;

class Demo25 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String name = "Wishva";
        /*for(int i = 0;true;i++){
            System.out.print("Enter your name: ");
            name = input.nextLine();
            if(name.isBlank() || name.isEmpty()){
                System.out.println("Invalid name try again!!");
                continue;
            }else{
                break;
            }
        }*/
        
        String strname = String.format("Welcome %s...", name);
        String str1 = "Welcome to DEP-11";
        String str2 = "We are born to code",allStr;
        int select = 1;
        mainloop:for (int i = 0; true;i++){
                    switch(select){
                        case 1:
                            allStr = strname;
                            break;
                        case 2:
                            allStr = str1;
                            break;
                        case 3:
                            allStr = str2;
                            break;
                        default:
                            break mainloop;
                    }
                    //System.out.println(select);
                    System.out.print(allStr.charAt(i));
                    Thread.sleep(200);
                    
                    
                    if (i== (allStr.length()-1)){
                        Thread.sleep(1000);
                        for (int j = 0;j <= strname.length();j++){
                            System.out.print("\b".repeat(j));
                            System.out.print(" ".repeat(j));
                            System.out.print("\r");
                            Thread.sleep(200);
                        }
                        i = -1;
                        select++;
                    }
                }
                System.out.println();
        
    }    
}
