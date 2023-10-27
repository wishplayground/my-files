import java.util.Arrays;

public class Demo8 {


    public static void main(String[] args) {
        
        /*page 2 */ Stack s1 = /*page 1*/new Stack(); 
        s1.push(10);//page 3
        s1.push(20);//page 4
        s1.print();//page 5

        
   }
    
}

class Stack{
    int[] numbers = new int[0];

    public Stack(){

    }

    public void push(int number){
        int[] newNum = new int[numbers.length+1];
        for (int i = 0; i < numbers.length; i++) {
            newNum[i] = numbers[i];
        }
        newNum[newNum.length-1] = number;
        numbers = newNum;

    }

    public void pop(){
        int[] newNum = new int[numbers.length -1];
        for (int i = 0; i < newNum.length; i++) {
            newNum[i] = numbers[i];
        }
        numbers = newNum;

    }

    public int peek(){
        return numbers[numbers.length-1];
    }

    void print(){
        System.out.println(Arrays.toString(numbers));
    }
}
