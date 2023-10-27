class Demo20 {
    public static void main(String[] args) {
        System.out.println(new Dog() instanceof Dog);
        System.out.println(new Dog() instanceof Animal);
        System.out.println(new Cat() instanceof Cat);
        System.out.println(new Cat() instanceof Animal);
        //System.out.println(new Box() instanceof Animal);
        System.out.println(new Dog() instanceof Object);
    }
}

class Animal{

}

class Dog extends Animal{}
class Cat extends Animal{}
class Box{}
