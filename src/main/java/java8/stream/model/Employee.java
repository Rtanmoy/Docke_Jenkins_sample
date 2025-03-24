package java8.stream.model;

public class Employee {

    private int id;
    private String name;
    private String dept;
    private long slary;

    public Employee(int id, String name, String dept, long slary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.slary = slary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public long getSlary() {
        return slary;
    }

    public void setSlary(long slary) {
        this.slary = slary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", slary=" + slary +
                '}';
    }
}
