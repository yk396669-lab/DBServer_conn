package college.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private String department;
    private double cgpa;

    public Student() {
    }

    public Student(int id, String name, String email, String department, double cgpa) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
    }

    public Student(String name, String email, String department, double cgpa) {
        this.name = name;
        this.email = email;
        this.department = department;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getCgpa() { return cgpa; }
    public void setCgpa(double cgpa) { this.cgpa = cgpa; }
}