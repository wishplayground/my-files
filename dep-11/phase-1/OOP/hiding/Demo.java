class Demo{

    public static void main(String[] args) {
        Dream.execute();
    }
}

class SuperClass{
    static {
        System.out.println("Super class static Initializer");
    }
    static void execute(){
        System.out.println("Super Class");
    }
}

class Dream extends SuperClass implements Idea1, Idea2 {
    static{
        System.out.println("static initializer");
    }

}

interface SuperIdea{
    static void execute(){
        System.out.println("Super Idea");
    }

}

interface Idea1 extends SuperIdea{
    static void execute(){
        System.out.println("Idea1 is Extended by Super Idea");
    }
}

interface Idea2{
    int x = getX();
    int y = getY();
    static void execute(){
        System.out.println("Idea2 not Extended");
    }

    static int getX(){
        System.out.println("GetX");
        return 10;
    }

    static int getY(){
        System.out.println("GetY");
        return 11;
    }
}

