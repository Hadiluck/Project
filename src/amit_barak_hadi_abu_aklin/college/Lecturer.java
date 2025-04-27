package amit_barak_hadi_abu_aklin.college;

public class Lecturer {
    public enum Degree {FIRST, SECOND, DOC, PROF}

    private double salary;
    private String name;
    private String id;
    private Degree degree;
    private Department department;

    public Lecturer(double salary, Department department, String degree, String id, String name) {
        this.department = department;
        this.id = id;
        this.name = name;
        setSalary(salary);
        setDegree(degree);
    }

    public double getSalary() {
        return salary;
    }

    public boolean setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public Degree getDegree() {
        return degree;
    }

    public boolean setDegree(String degreeFromUser) {
        try {
            this.degree = Degree.valueOf(degreeFromUser.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}