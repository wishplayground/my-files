public class Demo37 {
    public static void main(String[] args) {
        Ijse ijse = new Ijse();
        System.out.println(ijse.programe1);
        System.out.println(ijse.programe2);
        ijse = null;
        //can't access programme 1 or 2 any more called composition

        Programe programe1 = new Gdse();
        Programe programe2 = new Dep();
        Ijse ijse2 = new Ijse(programe1,programe2);
        System.out.println(ijse2.programe1);
        System.out.println(ijse2.programe2);
        ijse2 = null;
        //Still programe 1 and 2 can be accessed called Aggregation

    }
}

class Ijse{

    Programe programe1;
    Programe programe2;

    public Ijse(){
        this.programe1 = new Dep();
        this.programe2 = new Gdse();
    }

    public Ijse(Programe programe1, Programe programe2){
        this.programe1 = programe1;
        this.programe2 = programe2;
    }
}

interface Programe{


}

class Dep implements Programe{

}

class Gdse implements Programe{

}
