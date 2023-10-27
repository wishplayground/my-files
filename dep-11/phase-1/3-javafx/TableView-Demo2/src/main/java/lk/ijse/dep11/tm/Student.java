package lk.ijse.dep11.tm;

public class Student {

    private String id;
    private String name;
    private String programme;
    private String contactNum;

    public Student() {
    }

    public Student(String id, String name, String programme, String contactNum) {
        this.setId(id);
        this.setName(name);
        this.setProgramme(programme);
        this.setContactNum(contactNum);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }
}
