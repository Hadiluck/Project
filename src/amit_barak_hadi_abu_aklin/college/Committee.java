package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

public class Committee {
    private String name;
    private Lecturer headOf;
    private Lecturer[] lecturers;
    private int numOfLecturers;

    public Committee(String name, Lecturer headOf) {
        this.name = name;
        this.lecturers = new Lecturer[0];
        setHeadOf(headOf);
    }

    public boolean setHeadOf(Lecturer headOf) {
        if (headOf.getDegree() == Lecturer.Degree.PROF || headOf.getDegree() == Lecturer.Degree.DOC) {
            this.headOf = headOf;
            return true;
        }
        return false;
    }

    public void addLecturerToCommittee(Lecturer lecturer) {
        if (numOfLecturers == lecturers.length) {
            lecturers = Arrays.copyOf(lecturers, lecturers.length == 0 ? 2 : lecturers.length * 2);
        }
        lecturers[numOfLecturers++] = lecturer;
    }

    public void removeLecturerFromCommittee(Lecturer lecturer) {
        int j = 0;
        for (int i = 0; i < numOfLecturers; i++) {
            if (!lecturers[i].equals(lecturer)) {
                lecturers[j++] = lecturers[i];
            }
        }
        numOfLecturers = j;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Committee Name: ").append(name).append("\n");
        sb.append("Head of Committee: ").append(headOf != null ? headOf.getName() : "None").append("\n");
        sb.append("Lecturers in Committee:\n");
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

    public String getName() {
        return name;
    }

    public Lecturer getHeadOf() {
        return headOf;
    }

    public Lecturer[] getLecturers() {
        return lecturers;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }
}