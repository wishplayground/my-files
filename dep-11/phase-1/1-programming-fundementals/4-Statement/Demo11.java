import java.util.Scanner;

class Demo11 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a number between 0 -10: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        mySwitch://label statement owns just after expression
            switch (num *num){
                case 2*2 :
                    System.out.println("2 ^ 2");
                    abc:
                    if(true) break abc;
                    break;
                
                case 3*3 :lbl1 :{
                    System.out.println("3 ^ 3");
                    break lbl1;
                }

                case 4*4:
                    System.out.println("4 ^ 4");
                    break mySwitch;

                case 5*5: lbl2:{
                    System.out.println("5 ^ 5");
                    break lbl2;
                }

                case 1*1:
                    System.out.println("1 ^ 1");
                    break;
                default:
                    System.out.println("Invalid number");
             //////////////////////////////////////////////////////////////////

             switch (num *num){
                case 2*2 :
                    System.out.println("2 ^ 2");
                    abc:
                    {
                        System.out.println("Inside abc");
                        def:
                            System.out.println("I'm Associated with def");
                            inside:{
                                System.out.println("inside Inside");
                                if(true) break abc;
                                System.out.println("Still Inside");
                            }
                            System.out.println("Am I Inside def ?");
                    }
                    
                
                case 3*3 :lbl1 :{
                    System.out.println("3 ^ 3");
                    break lbl1;
                }

                case 4*4:
                    System.out.println("4 ^ 4");
                    break mySwitch;

                case 5*5: lbl2:{
                    System.out.println("5 ^ 5");
                    break lbl2;
                }

                case 1*1:
                    System.out.println("1 ^ 1");
                    break;
                default:
                    System.out.println("Invalid number");
            
        }
    }    
}
}
