package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

class Department {
    private String name;
    private Lecturer[] lecturers;
    private int numOfLecturers;
    private int numOfStudents;

    public Department(String name, int numOfStudents) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        setNumOfStudents(numOfStudents);
    }

    public boolean setNumOfStudents(int numOfStudents) {
        if (numOfStudents > 0) {
            this.numOfStudents = numOfStudents;
            return true;
        }
        return false;
    }

    public boolean addLecturerToDepartment(Lecturer lecturer) {
        if (lecturer.getDepartment() != null) {
            return false;
        }
        if (numOfLecturers == lecturers.length) {
            lecturers = Arrays.copyOf(lecturers, lecturers.length == 0 ? 2 : lecturers.length * 2);
        }
        lecturers[numOfLecturers++] = lecturer;
        lecturer.setDepartment(this);
        return true;
    }

    public void removeLecturerFromDepartment(Lecturer lecturer) {
        int j = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            if (!lecturers[i].equals(lecturer)) {
                lecturers[j++] = lecturers[i];
            }
        }
        if (j < numOfLecturers) {
            lecturer.setDepartment(null);
        }
        numOfLecturers = j;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Department Name: ").append(name).append("\n");
        sb.append("Number of Students: ").append(numOfStudents).append("\n");
        sb.append("Lecturers in Department:\n");
        if (numOfLecturers == 0) {
            sb.append("- No lecturers assigned yet.\n");
        } else {
            for (int i = 0; i < numOfLecturers; i++) {
                if (lecturers[i] != null) {
                    sb.append("- ").append(lecturers[i].getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }

    // Getters
    public String getName() {
        return name;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

    public int getNumOfStudents() {
        return numOfStudents;
    }
}