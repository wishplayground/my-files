import java.util.Scanner;

class LinearsearchAlgo2 {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] names = {"Saman","Nipuna","Nadun","Asiri","Kalana","Ruwan","Ajith"};
        String duplicateIndex=" ";
        loop:
        do{ 
            System.out.print("Enter Name you want to search: ");
            String searchName = scanner.nextLine();
            searchName = searchName.toLowerCase();
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(searchName)){
                    
                    continue ;
                }else if( i == names.length -1) {
                    System.out.println("Not found");
                    continue loop;
                }
                
            }
        }while (true);
    }
}
