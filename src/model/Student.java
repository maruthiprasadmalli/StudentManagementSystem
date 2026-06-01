package model;

public class Student extends Person {

    private int id;
    private String phone;
    private String course;

    public Student(int id, String name, int age,
                   String email, String phone, String course) {
        super(name, age, email);
        this.id = id;
        this.phone = phone;
        this.course = course;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }

    @Override
    public void displayInfo() {
        System.out.println("ID     : " + id);
        super.displayInfo();
        System.out.println("Phone  : " + phone);
        System.out.println("Course : " + course);
    }
}