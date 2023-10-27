public class Demo{
    public static void main(String[] args) {
        
    }
}

interface AwesomeIdea{
    void execute();
}

interface MySuperAwesomeIdea extends AwesomeIdea{
    default void execute(){
        System.out.println("My Super Idea");
    }

}

interface MyCrazyIdea extends AwesomeIdea{
    default void execute(){
        System.out.println("My crazy Idea");
    }

}

class IdeaWord implements MySuperAwesomeIdea, MyCrazyIdea{
    //solution is overiding
    @Override
    public void execute(){

    }
}