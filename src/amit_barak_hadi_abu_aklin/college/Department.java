package amit_barak_hadi_abu_aklin.college;
class Department {
    private String name;
    private Lecturer[] lecturers;
    private int numOfLectures;
    private int numOfStudents;

    public Department(String name, int numOfStudents) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        setNumOfStudents(numOfStudents);
    }

    public boolean setNumOfStudents(int numOfStudents) {
        if (0 < numOfStudents) {
            this.numOfStudents = numOfStudents;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department Name: ").append(name).append("\n");
        sb.append("Number of Students: ").append(numOfStudents).append("\n");
        sb.append("Lecturers in Department: \n");

        if (numOfLecturers == 0) {
            sb.append(" No lecturers assigned yet. \n");
        } else {
            for (int i = 0; i < numOfLecturers; i++) {
                if (lecturers[i] != null) {
                    sb.append("- ").append(lecturers[i].getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}
