import java.util.Scanner;

class Demo10 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        app:{
            System.out.print("Enter the Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            boolean leapYear = false;
            
            int numOfDays = 365 , febDays = 28;

            if (2000 <year && year <2030) {
                leapYear = (year%4==0);
                numOfDays = 366;
                break app;
            }else System.out.println("Invalid year input");
    

            System.out.print("Enter the month: ");
            String month = scanner.nextLine().strip().toUpperCase();
            

            switch (month){
                case "1": case "JAN": case "JANUARY":
                    numOfDays -=31;
                case "2": case "FEB": case "FEBRUARY":
                    numOfDays -= (leapYear) ? 29 : 28;
                case "3": case "MAR": case "MARCH":
                    numOfDays -=31;
                case "4": case "APR": case "APRIL":
                    numOfDays -=30;
                case "5": case "MAY":
                    numOfDays -= 31;
                case "6": case "JUN": case "JUNE":
                    numOfDays -= 30;
                case "7": case "JUL": case "JULY":
                    numOfDays -= 31;
                case "8": case "AUG": case "AUGEST":
                    numOfDays -= 31;
                case "9": case "SEP": case "SEPTEMBER":
                    numOfDays -= 30;
                case "10": case "OCT": case "OCOBER":
                    numOfDays -= 31;
                case "11": case "NOV": case "NOVEMBER":
                    numOfDays -= 30;
                case "12": case "DEC": case "DECEMBER":
                    numOfDays -= 31;
                default :
                    System.out.println("Invalid month");
                    break;
            }
            System.out.println(numOfDays);

            }

        
    }    
}
