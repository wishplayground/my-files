public class Demo17 {
    public static void main(String[] args) {
        Animal pet = new Dog("boola");
        System.out.println(pet.name);
        pet.eat();

    }
}

class Animal{
    String name = "Animal";

    public Animal(String name){
        this.name = name;
    }
    void eat(){
        System.out.printf("%s is eating\n",name);
    }
    
}

class Dog extends Animal{
    String name;
    public Dog(String name){
        super(name);
        this.name = name;
    }
    void eat(){
        System.out.printf("%s is eating\n",name);
        super.eat();
    }
    
}

/* class Cat{
    void eat(){
        System.out.println("Cat is eating");
    }
} */
