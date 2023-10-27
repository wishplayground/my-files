import java.util.*;

class Demo1{

    public static void main(String[] args) {
        
        //Fixed arrays (java Language)
        //Dynemic arrays (Java SE Library)
        //1. Vector
        //2. Array List
        
        Vector<Integer> myVector = new Vector<>();
        ArrayList<String> mArrayList = new ArrayList<>();

        System.out.println(myVector);//not print memory location but elements inside it
        System.out.println(mArrayList);//not print memory location but elements inside it

        //because they Overide .toStringMethod

        //Add
        //Vector
        myVector.add(10);
        myVector.add(20);
        myVector.add(30);

        //Array List
        mArrayList.add("IJSE");
        mArrayList.add("SASHA");
        mArrayList.add("WISHU");

        System.out.println(myVector);
        System.out.println(mArrayList);


        //Remove
        /*myVector.remove(1);
        mArrayList.remove(0);
        System.out.println(myVector);
        System.out.println(mArrayList);*/

        //Remove by Value
        //myVector.remove(20); //Cannot be done because it cant remove by value when it is number array
        mArrayList.remove("IJSE");

        System.out.println(myVector);
        System.out.println(mArrayList);

        //size
        System.out.println(myVector.size());
        System.out.println(mArrayList.size());

        //Contains (check whether element exist in the array)
        System.out.println(myVector.contains(32));
        System.out.println(mArrayList.contains("SASHA"));

        //If include in the array to find index. if not exist prints -1

        System.out.println(myVector.indexOf(30));
        System.out.println(mArrayList.indexOf("DEP"));

        //Clear to clea all the data in the array
        myVector.clear();

        System.out.println(myVector);
        System.out.println(mArrayList);

    }
}