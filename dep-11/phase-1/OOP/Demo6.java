public class Demo6 {

    public static void main(String[] args) {
        Student student1 = new Student(102, "Vidusha");
        Student student2 = new Student(103, "Waruna");

        student1.name = student2.name;
        Student student3 = student1;
        student3.id = student2.id;

        System.out.printf("id = %d   name = %s \n",student1.id,student1.name);
        System.out.printf("id = %d   name = %s \n",student2.id,student2.name);


        
    }
    
}

class Student{

    int id;
    String name;
    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

}
