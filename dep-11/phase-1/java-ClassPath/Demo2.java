public class Demo2 extends Parent {

    public static void print(){
        System.out.println("Demo Static method");
    }
    static{
        System.out.println("Static initiallizer 1");
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        System.out.println("Enter main method");
        demo2.method();       
        print();
        Parent.print();
        System.out.println(myInt);
        //System.out.println(new Parent().m2);
        
        System.out.println("Exit from main method");
    }

    static{
        System.out.println("Static initiallizer 2");
    }                                                                                                                  
   void method(){
        System.out.println(m2);
    }


}
