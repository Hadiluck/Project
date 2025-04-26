package amit_barak_hadi_abu_aklin.college;

public class Lecturer {
    private String name;
    private String id;
    private DegreeType degree;
    private String degreeName;
    private double salary;
    private Department department;
    private Committee[] committees;
    private int committeeCount;

    public Lecturer(String name, String id, DegreeType degree, String degreeName, double salary) {
        this.name = name;
        this.id = id;
        this.degree = degree;
        this.degreeName = degreeName;
        this.salary = salary;
        this.department = null;
        this.committees = new Committee[2];
        this.committeeCount = 0;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void assignDepartment(Department dept) {
        this.department = dept;
    }

    public DegreeType getDegree() {
        return degree;
    }

    public void addCommittee(Committee c) {
        if (!isInCommittee(c)) {
            if (committeeCount == committees.length) {
                Committee[] newArr = new Committee[committees.length * 2];
                for (int i = 0; i < committees.length; i++) {
                    newArr[i] = committees[i];
                }
                committees = newArr;
            }
            committees[committeeCount++] = c;
        }
    }

    public void removeCommittee(Committee c) {
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i].getName().equals(c.getName())) {
                for (int j = i; j < committeeCount - 1; j++) {
                    committees[j] = committees[j + 1];
                }
                committees[--committeeCount] = null;
                return;
            }
        }
    }

    private boolean isInCommittee(Committee c) {
        for (int i = 0; i < committeeCount; i++) {
            if (committees[i].getName().equals(c.getName())) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: ").append(name)
                .append(", ID: ").append(id)
                .append(", Degree: ").append(degree)
                .append(" (").append(degreeName).append(")")
                .append(", Salary: ").append(salary);
        if (department != null) {
            sb.append(", Department: ").append(department.getName());
        } else {
            sb.append(", Department: None");
        }
        if (committeeCount > 0) {
            sb.append(", Committees: ");
            for (int i = 0; i < committeeCount; i++) {
                sb.append(committees[i].getName());
                if (i != committeeCount - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append(", Committees: None");
        }
        return sb.toString();
    }
}